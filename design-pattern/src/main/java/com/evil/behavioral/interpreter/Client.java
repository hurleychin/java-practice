package com.evil.behavioral.interpreter;


import java.util.HashMap;
import java.util.Map;

public class Client {
    public static void main(String[] args) {
        // 构建表达式：a + (b - 1)
        Expression expression = new AddExpression(
            new VariableExpression("a"),
            new SubtractExpression(
                new VariableExpression("b"),
                new ConstantExpression(1)
            )
        );

        // 定义上下文，为变量赋值
        Map<String, Integer> context = new HashMap();
        context.put("a", 5);
        context.put("b", 3);

        // 解释执行表达式
        int result = expression.interpret(context);
        System.out.println("解释执行结果: " + result);
    }
}
