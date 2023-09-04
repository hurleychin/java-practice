package com.evil.behavioral.interpreter;

import java.util.Map;

/**
 * SubtractExpression
 *
 * @author qinhu
 * @version 1.0.0
 * @since 2023-09-04
 */ // 非终结符表达式：减法操作
class SubtractExpression implements Expression {
    private Expression left;
    private Expression right;

    public SubtractExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpret(Map<String, Integer> context) {
        return left.interpret(context) - right.interpret(context);
    }
}
