package com.evil.structural.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Composite
 *
 * @author qinhu
 * @version 1.0.0
 * @since 2023-09-04
 */ // Composite 组合对象
class Composite implements Component {
    private List<Component> children = new ArrayList<>();

    public void add(Component component) {
        children.add(component);
    }

    public void remove(Component component) {
        children.remove(component);
    }

    @Override
    public void operation() {
        System.out.println("组合对象执行操作，包含以下子对象：");
        for (Component child : children) {
            child.operation();
        }
    }
}
