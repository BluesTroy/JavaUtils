package com.bluestroy;

import java.util.*;

/**
 * Created by Troy on 2016/9/20.
 */
public class Main {
    public static void println(Object o){
        System.out.println(o);
    }

    /**
     * Arrays工具类常用方法示例
     */
    public static void arraysUsage(){
        int[] a = {-3,3,5,11,54,63,74};
        int[] b = {-3,3,5,11,54,63,74};
        Integer[] c = {15,6,788,2,3,56,9};
        Arrays.toString(a); //打印数组
        int y =Arrays.binarySearch(a,11);   //二分查找，返回找到的下标，找不到返回负数
        int[] xa=Arrays.copyOf(a,3);    //复制数组的前三个元素为另一个数组
        int[] xb = Arrays.copyOfRange(a,0,2);   //复制数组下标>=0,<2的部分
        boolean z =Arrays.equals(a,b);  //判断两个数组内容是否相同
        Arrays.fill(a,7);   //数组元素全部填充为7
        Arrays.fill(a,2,4,0);   //数组下标>=2,<4的元素填充为0
        Arrays.sort(c,2,6); //对数组下标>=2,<6的部分升序排序
        Arrays.sort(c);     //对数组进行升序排序
        Arrays.sort(c,Collections.<Integer>reverseOrder());//对数组进行降序排序
        Arrays.sort(c,new Comparator<Integer>(){//自定义降序排序排序
            @Override
            public int compare(Integer a, Integer b){
                return b.compareTo(a);
            }
        });
        Arrays.sort(c);     //对数组进行升序排序
        Arrays.sort(c, 0, 4, new Comparator<Integer>() { //自定义数组下标>=0,<4的部分降序
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });


        println(Arrays.toString(c));
        println(Arrays.toString(xa));
        println(Arrays.toString(xb));
        println(Arrays.toString(a));
        println(z);
        println(Arrays.toString(a));
    }

    /**
     * Collections工具类常用方法总结
     */
    public static void collectionsUsage(){
    List list = new ArrayList<Integer>();
    Collections.addAll(list,2,5,4,6,9);//将后面的元素都添加到list中
    Collections.reverseOrder();//返回一个Comparator<T>倒序排序的接口对象
    println(list);
    Collections.reverse(list);  //将列表逆序排序
    Collections.sort(list); //将列表升序排序
    println(list);
    Collections.sort(list,Collections.reverseOrder());  //将列表降序排序

    List list2 = new ArrayList<Integer>();
    Collections.addAll(list2,2,6,8,9,12,16,45);
    int index = Collections.binarySearch(list2,12); //二分查找，返回下标，无则返回负数
    println(list);
    println(index);

    Object max = Collections.max(list); //返回最大值
    Object min = Collections.min(list); //返回最小值
    println("max:"+max);
    println("min:"+min);

    List list3 = new ArrayList<Integer>(){{add(2);add(3);add(5);add(7);add(6);add(8);}};//初始化
//        Collections.synchronizedList(list);
    //查找是否有某子列表，有则返回第一个子列表下标，无则返回-1
    int sindex = Collections.indexOfSubList(list3,Arrays.asList(2,3));
    //查找是否有某子列表，有则返回最后一个子列表下标，无则返回-1
    int lindex = Collections.lastIndexOfSubList(list3,Arrays.asList(2,3));
    println("first index:"+sindex);
    println("last index:"+lindex);

    Collections.rotate(list3,2);//集合中元素后移2个位置，益处的循环到前面
    println(list3);
    Collections.shuffle(list3);//对集合进行洗牌，即打乱顺序
    println(list3);
    Collections.swap(list3,0,1);//交换集合中第0个和第一个元素
    println(list3);

    //list本身不是同步的，此法得到线程安全的list
    //【注意】即直接使用它提供的单个函数，可以同步。但若多个函数想同步，必须自己做同步。
    List safeList = Collections.synchronizedList(list3);

    //三个final类型的类变量，在某些情况下，我们经常需要返回一个空的集合对象，
    //比如在数据查询时，并不需要发挥一个NULL或是异常，那么就可以返回一个空的集合对象。
    List emptyList = Collections.EMPTY_LIST;    //创建一个空列表
    emptyList = Collections.emptyList();    //同上，下面类推
    Map emptyMap = Collections.EMPTY_MAP;  //创建一个空map
    Set emptySet = Collections.EMPTY_SET;  //创建一个空集合
    }
    public static void main(String[] args){
//        arraysUsage();
//        collectionsUsage();
        bitOperation();
//        int a[] ={2,6,8,9,12,33};
//        int x = Arrays.binarySearch(a,7);
//        println(x);
//        int y = binarySearch(a,0,a.length-1,7);
//        println("terstl....");
//        println(y);
        println("ddddddddddddccccc...");
        //字符串翻转
        String str = "kfdoweijre";
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        System.out.println(sb.toString());
    }

    /**
     *
     * @param a             待查找的数组
     * @param startIndex  待查找的数组的起始下标
     * @param endIndex  待查找的数组的终点下标
     * @param key       待查找的值
     * @return  返回找到的数的下标，找不到则返回负数（应该插入的位置下标的相反数）
     */
    public static int binarySearch(int[]a ,int startIndex, int endIndex,int key){
        int low = startIndex;
        int high = endIndex;
        while (low<=high){
            int mid = (low+high) >> 1;
            if (key < a[mid])
                high = mid -1;
            else if (key > a[mid])
                low = mid +1;
            else return mid;        //返回找到的数的下标
        }
        return -low;    //没找到则返回应该插入的下标的相反数
    }


    /**
     * 常见的位运算
     */
    public static void bitOperation(){
        int a= 56;
        int b =23;

        /******不用临时变量交换两个数*****/
        a^=b;
        b^=a;
        a^=b;
        println("a:"+a);
        println("b:"+b);

        /*****乘2运算*****/
        int c = a << 1 ;
        println(c);

        /*****除2运算*****/
        int d = b>>1;
        println(d);

        /*****乘2的n次方   x << n ********/
        int e = 3 << 2;
        println(e);

        /********除2的n次方  x >> n  ******/
        println(8 >> 2);

        /********* 判断一个数的奇偶性，true奇数，false偶数 *****/
        println((9 & 1)==1);
        println((8 & 1)==1);

        /**** 判断两个数符号是否相同，true相同，false不同 ***/
        println((8 ^ -2)>=0);
        //求平均数
        println((3+2)>>1);

        /**** >>是算术（有符号）右移，它使用最高位填充移位后左侧的空位，不改变符号。
         * >>> 是逻辑无符号（）右移，它用0填充左侧的空为。没有算术含义   */
        println(">>和>>>的区别：");
        println((byte)-4>>1);
        println((byte)-4>>>1);

    }

}
