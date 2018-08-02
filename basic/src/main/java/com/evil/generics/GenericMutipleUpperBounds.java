package com.evil.generics;

import java.util.Collection;
import java.util.Collections;
import java.util.List;


public class GenericMutipleUpperBounds {
        /**
         *  某个类型需要用 extends 限定，且有多种类型的时候，只能存在一个是类，并且类写在第一位，接口列在后面
         */
        public <T extends Number & Comparable<T>> void sortNumbers(List<T> n){
        Collections.sort(n);

    }
}
