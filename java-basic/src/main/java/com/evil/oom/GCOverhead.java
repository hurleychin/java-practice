package com.evil.oom;

import java.util.Map;
import java.util.Random;

/**
 * @author qinhulin on 2018-07-01
 */
public class GCOverhead {
    /** 默认情况下，当应用程序花费超过98%的时间用来做GC并且回收了不到2%的堆内存时，会抛出java.lang.OutOfMemoryError:GC overhead limit exceeded错误
     * -Xmx100m -XX:+UseParallelGC  java.lang.OutOfMemoryError: GC overhead limit exceeded
     * -Xmx10m -XX:+UseParallelGC  java.lang.OutOfMemoryError: Java heap space
     * -Xmx100m -XX:+UseConcMarkSweepGC 或者-XX:+UseG1GC  java.lang.OutOfMemoryError thrown from the UncaughtExceptionHandler in thread "main"
     * -XX:-UseGCOverheadLimit  毫无诚意的解决方案,仅仅将GC overhead limit exceeded 替换成了 Java heap space
     * @param args
     * @throws Exception
     */
    public static void main(String args[]) throws Exception {
        Map map = System.getProperties();
        Random r = new Random();
        while (true) {
            Thread.sleep(2000);
            map.put(r.nextInt(), "value");
        }
    }
}
