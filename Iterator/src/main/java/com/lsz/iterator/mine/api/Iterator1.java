package com.lsz.iterator.mine.api;

public interface Iterator1<E> {

    boolean hasNext();

    void next();

    E currentItem();

    E remove();
}
