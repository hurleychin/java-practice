package com.evil.behavioral.interpreter;

import java.util.Map;

/**
 * VariableExpression
 *
 * @author qinhu
 * @version 1.0.0
 * @since 2023-09-04
 */ // 终结符表达式：变量
class VariableExpression implements Expression {
    private String variableName;

    public VariableExpression(String variableName) {
        this.variableName = variableName;
    }

    @Override
    public int interpret(Map<String, Integer> context) {
        if (context.containsKey(variableName)) {
            return context.get(variableName);
        }
        return 0;
    }
}
