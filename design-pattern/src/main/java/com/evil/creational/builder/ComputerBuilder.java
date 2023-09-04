package com.evil.creational.builder;

public class ComputerBuilder {
    private String processor;
    private String memory;
    private String hardDisk;
    private String graphicsCard;

    public ComputerBuilder setProcessor(String processor) {
        this.processor = processor;
        return this;
    }

    public ComputerBuilder setMemory(String memory) {
        this.memory = memory;
        return this;
    }

    public ComputerBuilder setHardDisk(String hardDisk) {
        this.hardDisk = hardDisk;
        return this;
    }

    public ComputerBuilder setGraphicsCard(String graphicsCard) {
        this.graphicsCard = graphicsCard;
        return this;
    }

    public Computer build() {
        return new Computer(processor, memory, hardDisk, graphicsCard);
    }
}
