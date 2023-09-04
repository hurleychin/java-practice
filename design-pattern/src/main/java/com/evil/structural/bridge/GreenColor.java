package com.evil.structural.bridge;

/**
 * GreenColor
 *
 * @author qinhu
 * @version 1.0.0
 * @since 2023-09-04
 */ // 具体颜色类：绿色
class GreenColor implements Color {
    @Override
    public void applyColor() {
        System.out.println("Applying green color");
    }
}
