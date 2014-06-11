package ua.artcode.week1.homework;

import java.util.*;

/**
 * Created by amakogon on 11.06.2014.
 */
public class MyHashSet<E> extends AbstractSet<E> implements Set<E>{

    private transient Map<E,Object> map;
    private static final Object FAKE = new Object();

    public MyHashSet() {
        map = new HashMap<E, Object>();
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
    public boolean containsAll(Collection<?> c) {
        for(Object o : c){
            if(!contains(o)){
                return false;
            }
        }
        return true;
    }

    @Override
    public Iterator<E> iterator() {
        return map.keySet().iterator();
    }

    @Override
    public boolean add(E e) {
        return map.put(e,FAKE) == null;
    }

    @Override
    public boolean remove(Object o) {
        return map.remove(o) == FAKE;
    }

    @Override
    public void clear() {
        map.clear();
    }
}
