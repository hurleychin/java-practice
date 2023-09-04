package com.evil.behavioral.iterator;

import java.util.Iterator;

/**
 * MyList
 *
 * @author qinhu
 * @version 1.0.0
 * @since 2023-09-04
 */ // 自定义集合实现
class MyList<T> implements MyCollection<T> {
    private T[] elements;

    public MyList(T[] elements) {
        this.elements = elements;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator<>(elements);
    }
}
