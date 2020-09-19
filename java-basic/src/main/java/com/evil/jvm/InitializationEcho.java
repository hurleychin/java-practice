package com.evil.jvm;

/** 初始化顺序
 * @author qinhulin on 2020-09-09
 */
public class InitializationEcho {
    public InitializationEcho(){
        System.out.print("3");
    }

    {
        System.out.print("2");
    }

    static{
            System.out.print("1");
    }

    public static void main(String[] args) {
       InitializationEcho StaticInitEcho=new InitializationEcho();
    }
}

