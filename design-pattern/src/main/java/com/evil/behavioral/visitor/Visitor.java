package com.evil.behavioral.visitor;

// 访问者接口
interface Visitor {
    void visit(Circle circle);
    void visit(Rectangle rectangle);
}

