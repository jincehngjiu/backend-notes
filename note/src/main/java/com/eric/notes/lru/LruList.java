package com.eric.notes.lru;

import java.util.LinkedList;

/**
 * <p>
 * TODO
 * </p>
 *
 * @author Eric Jin
 * @since 5/8/25 AM8:00
 */
public class LruList<E> {

    private final int maxSize;

    private final LinkedList<E> list = new LinkedList<>();

    public LruList(int maxSize) {
        this.maxSize = maxSize;
    }

    public void add(E e) {
        if (list.size()<maxSize) {
            list.addFirst(e);
        }else {
            list.removeLast();
            list.addFirst(e);
        }
    }
    public E get(int index){
        E e = list.get(index);
        list.remove(index);
        add(e);
        return e;
    }

}
