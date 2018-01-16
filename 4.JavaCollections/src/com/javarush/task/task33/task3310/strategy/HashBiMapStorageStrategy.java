package com.javarush.task.task33.task3310.strategy;

import com.google.common.collect.HashBiMap;

/**
 * Created by GETMAN on 15.05.2017.
 */
public class HashBiMapStorageStrategy implements StorageStrategy {
    private HashBiMap<Long, String> data;

    public HashBiMapStorageStrategy() {
        this.data = HashBiMap.create();
    }

    @Override
    public boolean containsKey(Long key) {
        return data.containsKey(key);
    }

    @Override
    public boolean containsValue(String value) {
        return data.containsValue(value);
    }

    @Override
    public void put(Long key, String value) {
        data.put(key, value);
    }

    @Override
    public Long getKey(String value) {
        return data.inverse().get(value);
    }

    @Override
    public String getValue(Long key) {
        return data.get(key);
    }
}