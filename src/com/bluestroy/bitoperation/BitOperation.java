package com.bluestroy.bitoperation;

/**
 * Created by Troy on 2016/9/28.
 */
public class BitOperation {

    //非递归法实现加法运算
    public int add(int a, int b){
        int result = a;
        while(b!=0){
            result = a^b;
            b=(a&b)<<1;
            a = result;
        }
        return result;
    }

    //递归法实现加法运算
    public int add2(int a, int b){
        if ((a&b)==0) return a^b;
        return add2(a^b,(a&b)<<1);
    }

    //减法运算
    public int sub(int a, int b){
        //b的相反数是~b+1
        return add(a, ~b+1);
    }


    public static void main(String[] args){
        BitOperation bo = new BitOperation();
        System.out.println(bo.add(3,4));
        System.out.println(bo.add2(3,4));
        System.out.println(~3+1);
        System.out.println(bo.sub(4,3));
    }

}
