package com.lsz.iterator.mine.arraylist;

import com.lsz.iterator.mine.api.Iterator1;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;

public class ArrayListIterator1<E> implements Iterator1<E> {

    private ArrayList<E> arrayList;

    private int curator;

    private int expectModCount;

    private int lastRet;

    public ArrayListIterator1(ArrayList<E> arrayList) {
        this.arrayList = arrayList;
        this.curator = 0;
        this.lastRet = -1;
//        this.expectModCount = arrayList.modCount;
    }

    public boolean hasNext() {
        return curator < arrayList.size();
    }

    public void next() {
        this.lastRet = this.curator++;
    }

    public E currentItem() {
        checkForModification();
        if (curator >= arrayList.size()) {
            throw new IllegalArgumentException("游标错误");
        }
        return arrayList.get(curator);
    }

    @Override
    public E remove() {
        if (lastRet == -1) {
            throw new IllegalArgumentException();
        }
        checkForModification();
        try {
            E e = this.arrayList.remove(lastRet);
            curator = lastRet;
            lastRet = -1;
//        this.expectModCount = arrayList.modCount;
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
