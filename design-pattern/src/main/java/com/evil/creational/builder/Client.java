package com.evil.creational.builder;

public class Client {
    public static void main(String[] args) {
        Computer computer1 = new ComputerBuilder()
            .setProcessor("Intel i7")
            .setMemory("16GB")
            .setHardDisk("512GB SSD")
            .build();

        Computer computer2 = new ComputerBuilder()
            .setProcessor("AMD Ryzen 9")
            .setMemory("32GB")
            .setHardDisk("1TB HDD")
            .setGraphicsCard("NVIDIA RTX 3080")
            .build();

        System.out.println("Computer 1: " + computer1);
        System.out.println("Computer 2: " + computer2);
    }
}
