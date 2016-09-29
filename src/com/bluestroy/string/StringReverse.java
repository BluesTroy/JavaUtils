package com.bluestroy.string;

import java.util.Stack;

/**
 * Created by Troy on 2016/9/24.
 */

/**
 * 字符串反转的n种方法
 */
public class StringReverse {

    public static String reverse1(String s){
        return new StringBuilder(s).reverse().toString();
    }

    public static String reverse2(String s){
        char[] arr = s.toCharArray();
        int i = 0;
        int j= s.length()-1;
        for (;i<j;i++,j--){
            arr[i] = (char)(arr[i]^arr[j]);
            arr[j]=(char)(arr[j]^arr[i]);
            arr[i]=(char)(arr[i]^arr[j]);
        }
        System.out.println(arr);
        return new String(arr);
    }

    public static String reverse3(String s){
        int length = s.length();
        if(length<=1) return s;
        String left = s.substring(0,length/2);
        String right = s.substring(length/2,length);
        return reverse3(right)+reverse1(left);
    }

    public static String reverse4(String s){
        char[] arr = s.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        for (char c : arr) {
            stack.push(c);
        }
        StringBuilder sb = new StringBuilder();
        /* error!
        Iterator it = stack.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            System.out.println(sb.toString());
        }*/
        for (int i=0;i<s.length();i++){
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    public static String reverse5(String s){
        char[] arr = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i=arr.length-1; i>=0;i--){
            sb.append(arr[i]);
        }
        return sb.toString();
    }

    public static String reverse6(String s){
        String str = "";
        for (int i = 0;i<s.length();i++){
            str = s.charAt(i)+str;
        }
        return str;
    }

    public static void main(String[] args){
        String str = "hello world";
        System.out.println(reverse1(str));
        System.out.println(reverse2(str));
        System.out.println(reverse3(str));
        System.out.println(reverse4(str));
        System.out.println(reverse5(str));
        System.out.println(reverse6(str));
    }
}
