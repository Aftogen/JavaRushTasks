package com.javarush.task.task37.task3707;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;


public class AmigoSet<E> extends AbstractSet<E> implements Serializable, Cloneable, Set<E>{
    private static final Object PRESENT = new Object();
    private transient HashMap<E,Object> map;
    public AmigoSet() {
        map = new HashMap<E, Object>();
    }

    public AmigoSet(Collection<? extends E> collection) {
        int capacity = Math.max(16, (int)(collection.size()/0.75f +1));
        map = new HashMap<E, Object>(capacity);
        addAll(collection);
    }
    @Override
    public boolean add(E e) {
        return map.put(e, PRESENT) == null;
    }


    @Override
    public Iterator iterator() {
        return map.keySet().iterator();
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return map.containsKey(o);
    }

    @Override
    public boolean remove(Object o) {
        return map.remove(o)==null;
    }

    @Override
    public void clear() {
        map.clear();
    }
    private void writeObject(ObjectOutputStream s) throws IOException {
        // Write out any hidden serialization magic
        s.defaultWriteObject();

        // Write out HashMap capacity and load factor
        s.writeFloat(HashMapReflectionHelper.callHiddenMethod(map, "loadFactor"));
        s.writeInt(HashMapReflectionHelper.callHiddenMethod(map, "capacity"));

        // Write out size
        s.writeInt(map.size());

        // Write out all elements in the proper order.
        for (E e : map.keySet()) {
            s.writeObject(e);
        }
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        // Read in any hidden serialization magic
        s.defaultReadObject();

        // Read capacity and verify non-negative
        float loadFactor = s.readFloat();
        // Read load factor and verify positive and non NaN
        int capacity = s.readInt();

        // Write out size
        int mapSize = s.readInt();

        // Write out all elements in the proper order.
        for (int i = 0; i < mapSize; i++) {
             map.put((E) s.readObject(), PRESENT);
        }
    }


    @Override
    public Object clone() throws CloneNotSupportedException {
        try {
            map.clone();
        }catch (Exception e){
            throw new  InternalError();
        }

        return super.clone();
    }

}
