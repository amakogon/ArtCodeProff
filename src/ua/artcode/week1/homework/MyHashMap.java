package ua.artcode.week1.homework;

import java.io.Serializable;
import java.util.*;

/**
 * Created by amakogon on 11.06.2014.
 */
public class MyHashMap<K, V> implements Map<K, V>, Serializable {

    private transient int size;
    private static final double LOAD_FACTOR = 0.75;
    private static final int DEFAULT_CAPASITY = 16;
    private transient int threshold;

    private Entry[] table;

    public MyHashMap(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("capacity < 0 " + capacity);
        }
        this.threshold = capacity;
        table = new Entry[capacity];
    }

    public MyHashMap() {
        this(DEFAULT_CAPASITY);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        return getEntry(key) != null;
    }

    @Override
    public boolean containsValue(Object value) {
        if (value == null) {
            containsNullValue();
        }
        for (int i = 0; i < table.length; i++) {
            if (value.equals(table[i])) {
                return true;
            }
        }
        return false;
    }

    private boolean containsNullValue() {
        Entry[] tab = table;
        for (int i = 0; i < tab.length; i++)
            for (Entry e = tab[i]; e != null; e = e.next)
                if (e.value == null)
                    return true;
        return false;
    }

    @Override
    public V get(Object key) {
        if (size == 0) {
            return null;
        }
        Entry<K, V> entry = getEntry(key);
        return entry == null ? null : entry.getValue();
    }

    private Entry<K, V> getEntry(Object key) {
        if (size == 0) {
            return null;
        }
        int hash = key == null ? 0 : key.hashCode();
        int index = hash % table.length;
        for (Entry<K, V> entry = table[index]; entry != null; entry = entry.next) {
            if (hash == entry.hash && (key == entry.key || (key != null && key.equals(entry.getKey())))) {
                return entry;
            }
        }
        return null;
    }

    @Override
    public V put(K key, V value) {
        if (key == null) {
            putForNullKey(value);
        }
        int hash = key.hashCode();
        int index = hash % table.length;

        for (Entry<K, V> entry = table[index]; entry != null; entry = entry.next) {
            if (hash == entry.hash && entry.getKey().equals(key)) {
                V oldValue = entry.value;
                entry.value = value;
                return oldValue;
            }
        }
        addEntry(hash, key, value, index);
        return null;
    }

    private void addEntry(int hash, K key, V value, int index) {

        ensureCapascity();

        Entry<K, V> entry = table[index];
        table[index] = new Entry(key, value, entry, hash);
        size++;
    }

    private void ensureCapascity() {
        if (size >= threshold) {
        }
    }

    private V putForNullKey(V value) {
        for (Entry<K, V> entry = table[0]; entry != null; entry = entry.next) {
            if (entry.key == null) {
                V oldValue = entry.value;
                entry.value = value;
                return oldValue;
            }
        }
        addEntry(0, null, value, 0);
        return null;
    }

    @Override
    public V remove(Object key) {
        Entry<K,V> entry = getEntry(key);
        if(entry != null){
            put(entry.getKey() ,null);
        }
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        Arrays.fill(table, null);
        size = 0;
    }

    @Override
    public Set<K> keySet() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Collection<V> values() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        throw new UnsupportedOperationException();
    }

    private static class Entry<K, V> implements Map.Entry {

        int hash;
        final K key;
        V value;
        Entry<K, V> next;


        private Entry(K key, V value, Entry<K, V> next, int hash) {
            this.key = key;
            this.value = value;
            this.next = next;
            this.hash = hash;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public Object setValue(Object value) {
            return null;
        }
    }

}
