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

    /**
     * 反转一个单词
     * @param sArray    要反转的数组
     * @param startIndex    要反转部分的起始下标
     * @param endIndex  要反转部分的终止下标
     */
    private void reverse(char [] sArray, int startIndex, int endIndex){
        char temp;
        for (;startIndex<endIndex;startIndex++,endIndex--){
            temp = sArray[startIndex];
            sArray[startIndex]=sArray[endIndex];
            sArray[endIndex]=temp;
        }
    }

    /**
     * 反转句子中单词的顺序，要求单词内部不变。
     * @param s 要反转的字符数组
     */
    public void reverseWords(char[] s){
        if (s == null && s.length ==0) return;
        int n = s.length;
        int i=0;
        int j;
        while (i<n){
            j=i;
            //找到要反转的单词的第一个字母下标i和最后一个字母下标j
            while (j<n){
                if (s[j]==' ') break;
                else j++;
            }
            reverse(s,i,j-1);
            //跳过空格
            while (j<n && s[j]==' ') j++;
            //继续进行下一个单词
            i=j;
        }
        //最后反转整个句子
        reverse(s,0,n-1);
    }

    /**
     * 调用String api实现反转句子中单词的顺序
     * @param s
     * @return
     */
    public String reverseWords2(String s){
        String [] strArray = s.split("\\s");
        StringBuilder result= new StringBuilder();
        for (int i = strArray.length-1;i>0;i--){
            result.append(strArray[i]+" ");
        }
        result.append(strArray[0]);
        return result.toString();
    }


    public static void main(String[] args){
        MyString ms = new MyString();
        int x = ms.lengthOfLastWord("  fd jl jlkj ljlk l lj lkkjlj  ");
        System.out.println(x);
        x=ms.lengthOfLastWord("  fd jl jlkj ljlk l lj lkkjlj  ");
        System.out.println(x);
        System.out.println(ms.isAnagram("bca","aBc"));

        String str = "hello world good night!";
        char[] sArray = str.toCharArray();
        ms.reverseWords(sArray);
        System.out.println(sArray);
        String ss = ms.reverseWords2(str);
        System.out.println();

    }



}
