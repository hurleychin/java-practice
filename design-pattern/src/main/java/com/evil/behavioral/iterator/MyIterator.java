package com.evil.behavioral.iterator;

import java.util.Iterator;

/**
 * MyIterator
 *
 * @author qinhu
 * @version 1.0.0
 * @since 2023-09-04
 */ // 自定义迭代器
class MyIterator<T> implements Iterator<T> {
    private T[] elements;
    private int position = 0;

    public MyIterator(T[] elements) {
        this.elements = elements;
    }

    @Override
    public boolean hasNext() {
        return position < elements.length;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new IllegalStateException("没有更多元素可遍历");
        }
        return elements[position++];
    }
}
