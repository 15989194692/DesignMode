package com.lsz.iterator.mine.linkedlist;

import com.lsz.iterator.mine.api.Iterator1;

import java.util.LinkedList;

public class LinkedListIterator1<E> implements Iterator1<E> {
    private LinkedList<E> linkedList;

    private int curator;

    public LinkedListIterator1(LinkedList<E> linkedList) {
        this.linkedList = linkedList;
        this.curator = 0;
    }

    @Override
    public boolean hasNext() {
        return curator < linkedList.size();
    }

    @Override
    public void next() {
        curator++;
    }

    @Override
    public E currentItem() {
        if (curator >= linkedList.size()) {
            throw new IllegalArgumentException("游标越界");
        }
        return linkedList.get(curator);
    }

    @Override
    public E remove() {
        return null;
    }
}
