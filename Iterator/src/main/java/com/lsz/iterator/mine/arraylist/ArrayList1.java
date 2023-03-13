package com.lsz.iterator.mine.arraylist;

import com.lsz.iterator.mine.api.Iterator1;
import com.lsz.iterator.mine.api.List1;

import java.util.ArrayList;

public class ArrayList1<E> implements List1 {

    private ArrayList<E> arrayList;

    @Override
    public Iterator1 iterator() {
        return new ArrayListIterator1(this.arrayList);
    }
}
