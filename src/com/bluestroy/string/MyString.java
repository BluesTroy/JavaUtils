package com.bluestroy.string;

import java.util.Arrays;

/**
 * Created by Troy on 2016/9/22.
 */
public class MyString {

    /**
     * 求一个字符串的最后一个单词的长度
     * @param s
     * @return
     */
    public int lengthOfLastWord(String s){
        if(s==null && s.length()==0) return 0;
        int count=0;
        int i=s.length()-1;
        //寻找第一个不为‘ ’的字符
        for (;i>=0;i--){
            if (s.charAt(i)==' ');
            else break;
        }
        //确定最后一个单词
        for (;i>=0;i--){
            if (s.charAt(i) ==' ')break;
            else count++;
        }
        return count;
    }

    /**
     * 求一个字符串的最后一个单词的长度
     * @param s
     * @return
     */
    public int lengthOfLastWord2(String s){
        String str[] = s.split("\\s");
        return str[str.length-1].length();
    }


    /**
     * 判断两个字符串是否是同分异构体
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s,String t){
        if (s == null && t== null) return true;
        else if (s ==null && t!=null) return false;
        else if (s != null && t== null) return false;
        else {
            if (s.length()!=t.length()) return false;
            char [] sArray = s.toCharArray();
            char [] tArray = t.toCharArray();
            Arrays.sort(sArray);
            Arrays.sort(tArray);
            return Arrays.equals(sArray,tArray);
        }
    }

    /**
     * 判断两个字符串是否是同分异构体法2，此法只考虑小写字母
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram2(String s, String t){
        if (s == null && t== null) return true;
        else if (s ==null && t!=null) return false;
        else if (s != null && t== null) return false;
        else {
            if (s.length() != t.length()) return false;
            //此方法只考虑了只有小写字母，故设数组长度为26
            int twentySix = 26;
            int n = s.length();
            int[] sTable = new int[twentySix];
            int[] tTable = new int[twentySix];
            //用hash表的思想统计每个字母出现的次数
            for (int i=0;i<n;i++){
                sTable[s.charAt(i)-'a']++;
                tTable[s.charAt(i)-'a']++;
            }
            //如果每个字母出现的次数都相同，返回true，否则返回false。
            for (int i=0;i<twentySix;i++)
                if (sTable[i]!=tTable[i])
                    return false;
            return true;
        }
    }

    public static void main(String[] args){
        MyString ms = new MyString();
        int x = ms.lengthOfLastWord("  fd jl jlkj ljlk l lj lkkjlj  ");
        System.out.println(x);
        x=ms.lengthOfLastWord("  fd jl jlkj ljlk l lj lkkjlj  ");
        System.out.println(x);
        System.out.println(ms.isAnagram("bca","aBc"));


    }



}
