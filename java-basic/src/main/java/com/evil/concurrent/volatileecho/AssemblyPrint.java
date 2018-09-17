package com.evil.concurrent.volatileecho;

/**
 * @author qinhu
 * @date 2018-09-09
 */
public class AssemblyPrint {

/*    descriptor: I
    flags: ACC_PRIVATE, ACC_STATIC, ACC_VOLATILE*/
    private static volatile int i=0;

    public static void main(String[] args) {
/*        0x00000000035fda7e: lock add dword ptr [rsp],0h  ;*putstatic i
                ; - com.evil.concurrent.volatileecho.AssemblyPrint::main@2 (line 11)*/
        i++;
    }
}
