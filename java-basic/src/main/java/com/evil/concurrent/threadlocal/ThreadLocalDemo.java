package com.evil.concurrent.threadlocal;

public class ThreadLocalDemo {
    private String content;

    private String threadContent;

    private ThreadLocal<String> threadLocalContent=new ThreadLocal<>();



    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getThreadContent() {
        return threadLocalContent.get();
    }

    public void setThreadContent(String threadContent) {
        this.threadLocalContent.set(threadContent);
    }

    public static void main(String[] args) {
        /** 非线程安全，会出现线程设置的值和取到的值不一致现象,使用ThreadLocal不会
         * Thread-3------>Thread-9
         * Thread-8------>Thread-11
         * Thread-3---threadLocal---> Thread-3
         * Thread-8---threadLocal---> Thread-8
         */
        ThreadLocalDemo demo=new ThreadLocalDemo();
        for(int i=0;i<10;i++){
            Thread newThread=new Thread(new Runnable() {
                @Override
                public void run() {
                    demo.setContent(Thread.currentThread().getName());
                    System.out.println(Thread.currentThread().getName()+"------>"+demo.getContent());

                    demo.setThreadContent(Thread.currentThread().getName());
                    System.out.println(Thread.currentThread().getName()+"---threadLocal---> "+demo.getThreadContent());
                }
            });
            newThread.start();
        }
    }
}
