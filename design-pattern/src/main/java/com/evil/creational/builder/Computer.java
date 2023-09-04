package com.evil.creational.builder;

public class Computer {
    private String processor;
    private String memory;
    private String hardDisk;
    private String graphicsCard;

    public Computer(String processor, String memory, String hardDisk, String graphicsCard) {
        this.processor = processor;
        this.memory = memory;
        this.hardDisk = hardDisk;
        this.graphicsCard = graphicsCard;
    }

    // 省略 getter 和 toString 方法
}
