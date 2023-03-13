package com.lsz.iterator.mine.arraylist;

import java.util.ArrayList;

public class ArrayListApplication {

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);

        final ArrayListIterator1<Integer> iterator1 = new ArrayListIterator1<Integer>(arrayList);
        while (iterator1.hasNext()) {
            System.out.println(iterator1.currentItem());
            iterator1.next();
        }

        final ArrayListIterator2<Integer> iterator2 = new ArrayListIterator2<Integer>(arrayList);
        while (iterator2.hasNext()) {
            System.out.println(iterator2.next());
        }
    }
}
