package com.evil.guava.utilities;

import com.google.common.base.Optional;

/**
 * @author qinhulin on 2018-10-22
 */
public class OptionalEcho {
    public static void main(String[] args) {
        Optional<Integer> possible = Optional.of(5);
        possible.isPresent(); // returns true
        possible.get(); // returns 5
    }
}
