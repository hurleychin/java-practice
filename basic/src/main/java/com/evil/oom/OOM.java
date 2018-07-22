package com.evil.oom;

/**
 * @author qinhulin on 2018-07-01
 */
public class OOM {
    static final int SIZE=2*1024*1024;

    /** 当你尝试编译并指定12M堆空间运行时（java -Xmx12m OOM）将会失败并抛出java.lang.OutOfMemoryError: Java heap space，当13M堆空间时，将正常的运行。
     * @param a
     */
    public static void main(String[] a) {
        int[] i = new int[SIZE];
    }
}
