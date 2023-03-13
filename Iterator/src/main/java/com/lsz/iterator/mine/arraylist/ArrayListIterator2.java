package com.lsz.iterator.mine.arraylist;

import com.lsz.iterator.mine.api.Iterator2;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;

public class ArrayListIterator2<E> implements Iterator2<E> {

    private ArrayList<E> arrayList;

    private int curator;

    private int expectModCount;

    private int lastRet;

    public ArrayListIterator2(ArrayList<E> arrayList) {
        this.arrayList = arrayList;
        curator = 0;
        lastRet = -1;
//        expectModCount = arrayList.modCount;
    }

    public boolean hasNext() {
        return curator < this.arrayList.size();
    }

    public E next() {
        checkForModification();
        if (curator >= arrayList.size()) {
            throw new IllegalArgumentException("游标越界");
        }
        return arrayList.get(this.lastRet = curator++);
    }

    @Override
    public E remove() {
        if (lastRet == -1) {
            throw new IllegalArgumentException();
        }
        checkForModification();
        try {
            E e = arrayList.remove(lastRet);
            curator = lastRet;
            lastRet = -1;
//            expectModCount = arrayList.modCount;
            return e;
        } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            throw new ConcurrentModificationException();
        }
    }

    private void checkForModification() {
        /*if (this.expectModCount != this.arrayList.modCount) {
            throw new ConcurrentModificationException();
        }*/
    }
}
