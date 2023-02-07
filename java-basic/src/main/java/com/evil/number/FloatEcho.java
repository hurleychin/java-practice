package com.evil.number;

import java.math.BigDecimal;

public class FloatEcho {
    public static void main(String[] args) {

        double a=0.1;
        double b=0.2;
        double c=0.3;
        System.out.println((a+b)==c);

    }

    private static void testFloat(){
        System.out.println(Float.valueOf("499999.78"));
        System.out.println(Float.toHexString(499999.78f));
        //1111010000100011111.1100011110101110000101000111101011100001010001111011
        //e=18+127=145d=10010001
        //why not            .11000
        //m=11101000010001111111001  //末尾进1
        //0 10010001 11101000010001111111001
        //1111010000100011111.11001=49999.(0.5+0.25+0.03125)=499999.78125
        System.out.println(Float.valueOf("599999.78"));
        System.out.println(Float.toHexString(599999.78f));
        //10010010011110111111.1100011110101110000101000111101011100001010001111011
        //e=19+127=146d=10010010
        //m=00100100111101111111100
        //0 10010010 00100100111101111111100
        //10010010011110111111.1100=599999.(0.5+0.25)=599999.75
        System.out.println(Float.valueOf("5999999.78"));

        System.out.println(integerToBinary(499999));
        System.out.println(fractionalToBinary(0.78));

        System.out.println(integerToBinary(599999));
        System.out.println(fractionalToBinary(0.78));

        System.out.println(integerToBinary(5999999));
        System.out.println(fractionalToBinary(0.78));
    }

    /**
     * 十进制整数转二进制采用“除 2 取余，逆序排列”
     * @param i
     * @return
     */
    private static String integerToBinary(Integer i){
        StringBuilder sb=new StringBuilder();
        for(;;){
            if(i==0) {
                break;
            }
            sb.append(i%2);
            i=i/2;
        }
        return sb.reverse().toString();
    }

    /**
     * 十进制小数转二进制采用“乘 2 取整，顺序排列”
     * @param d
     * @return
     */
    private static String fractionalToBinary(Double d){

        BigDecimal r=new BigDecimal(d);
        StringBuilder sb=new StringBuilder();
        for(;;){
            r=r.multiply(BigDecimal.valueOf(2));
            sb.append(r.intValue());
            r=r.subtract(BigDecimal.valueOf(r.intValue()));
            if(0==r.compareTo(new BigDecimal(0))){
               break;
            }

        }
        return sb.toString();

    }



}
