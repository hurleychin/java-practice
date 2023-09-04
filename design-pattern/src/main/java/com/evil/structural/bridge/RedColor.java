package com.evil.structural.bridge;

// 具体颜色类：红色
class RedColor implements Color {
    @Override
    public void applyColor() {
        System.out.println("Applying red color");
    }
}

