package com.evil.oom;

import javassist.ClassPool;

/**
 * @author qinhulin on 2018-07-02
 */
public class PermGenOOM {
    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 100_000_000; i++) {
            generate("cn.moondev.User" + i);
        }
    }

    public static Class generate(String name) throws Exception {
        ClassPool pool = ClassPool.getDefault();
        return pool.makeClass(name).toClass();
    }
}
