package com.evil.arraycopy;

import java.util.Arrays;

/**
 * @author qinhulin on 2018-01-13
 */
public class ArrayCopy {
    public static void main(String[] args){
        String[] sqls={"a","b","c","d","e"};
        int capacity=2;
        int count=(sqls.length%capacity==0)?(sqls.length/capacity):(sqls.length/capacity+1);
        String[] exeSql;
        for(int i=1;i<=count;i++ ){
            int point=i*capacity;
            if(point>=sqls.length){
                exeSql= Arrays.copyOfRange(sqls,(i-1)*capacity,sqls.length);
            }else {
                exeSql=Arrays.copyOfRange(sqls,(i-1)*capacity,point);
            }
            for(String s:exeSql){
                System.out.print(s);
            }
            System.out.print("\n");
        }

    }
}
