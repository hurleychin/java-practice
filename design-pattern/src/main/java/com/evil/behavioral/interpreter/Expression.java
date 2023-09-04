package com.evil.behavioral.interpreter;

import java.util.Map;

/**
 * Expression
 *
 * @author qinhu
 * @version 1.0.0
 * @since 2023-09-04
 */ // 抽象表达式接口
interface Expression {
    int interpret(Map<String, Integer> context);
}
