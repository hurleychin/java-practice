package com.evil.behavioral.iterator;

import java.util.Iterator;

/**
 * MyCollection
 *
 * @author qinhu
 * @version 1.0.0
 * @since 2023-09-04
 */ // 自定义集合接口
interface MyCollection<T> {
    Iterator<T> iterator();
}
