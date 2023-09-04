package com.evil.behavioral.interpreter;

import java.util.Map;

/**
 * ConstantExpression
 *
 * @author qinhu
 * @version 1.0.0
 * @since 2023-09-04
 */ // 终结符表达式：常量
class ConstantExpression implements Expression {
    private int value;

    public ConstantExpression(int value) {
        this.value = value;
    }

    @Override
    public int interpret(Map<String, Integer> context) {
        return value;
    }
}
