package com.lsz.iterator.mine.arraylist;

import com.lsz.iterator.mine.api.Iterator2;
import com.lsz.iterator.mine.api.List2;

import java.util.ArrayList;

public class ArrayList2<E> implements List2 {

    private ArrayList<E> arrayList;


    @Override
    public Iterator2 iterator() {
        return new ArrayListIterator2(this.arrayList);
    }
}
