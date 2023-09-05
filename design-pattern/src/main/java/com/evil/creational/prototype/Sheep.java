package com.evil.creational.prototype;

/**
 * Sheep
 *
 * @author qinhu
 * @version 1.0.0
 * @since 2023-09-05
 */ // 实现Cloneable接口，允许对象被复制
class Sheep implements Cloneable {
    private String name;

    public Sheep(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 实现clone方法，通过复制当前对象创建一个新的对象
    @Override
    public Sheep clone() {
        try {
            return (Sheep) super.clone();
        } catch (CloneNotSupportedException e) {
            // 处理克隆失败异常
            System.out.println("克隆失败：" + e.getMessage());
            return null;
        }
    }
}
