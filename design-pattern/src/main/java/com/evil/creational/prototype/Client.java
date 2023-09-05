package com.evil.creational.prototype;

public class Client {
    public static void main(String[] args) {
        Sheep originalSheep = new Sheep("Dolly");

        // 克隆原始羊
        Sheep clonedSheep = originalSheep.clone();
        clonedSheep.setName("Molly");

        // 输出原始羊和克隆羊的名称
        System.out.println("原始羊的名称: " + originalSheep.getName());
        System.out.println("克隆羊的名称: " + clonedSheep.getName());
    }
}
