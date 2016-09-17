package com.bluestroy.sort;

import sun.misc.Sort;

import java.util.Arrays;

/**
 * Created by Troy on 2016/9/17.
 */
public class SortUtil {
    public static void main(String [] args){
        int[] a = {2,45,6,8,21,6,4};
        SortUtil.heapSort(a);
        System.out.println(Arrays.toString(a));
    }



    /**
     * 冒泡排序
     *
     * @param a 待排序的数组
     */
    public static void bubbleSort(int a[]) {
        int temp = 0;
        //n个数，进行n-1次扫描
        for (int i = a.length - 1; i > 0; i--) {
            //每次扫描都比较前i个数，每两个相邻的数，将小的放前面
            for (int j = 0; j < i; j++) {
                if (a[j] > a[j + 1]) {
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 快速排序
     *
     * @param a     待排序的数组
     * @param left  待排序区间的开始下标
     * @param right 待排序区间的结束下标
     */
    public static void quickSort(int a[], int left, int right) {
        if (left >= right) {
            return;
        }
        int i = left;
        int j = right;
        int key = a[i];    //以第一个数为关键字
        //经过一趟后，关键字在中间的某处，左边的都比其小，右边的都比其大
        while (i < j) {
            //先从j开始由右往左，遇见比关键字小的则将此数放到左边i的位置，然后i++
            while (i < j && a[j] >= key) {
                j--;
            }
            if (i < j) {
                a[i] = a[j];
                i++;
            }
            //然后再从i开始由左往右，遇见比关键字大的数则将此数放到j的位置，然后j--
            while (i < j && a[i] <= key) {
                i++;
            }
            if (i < j) {
                a[j] = a[i];
                j--;
            }
        }
        a[i] = key;
        //然后对左右区间分别执行快排算法
        quickSort(a, left, i - 1);
        quickSort(a, i + 1, right);
    }

    /**
     * 直接选择排序
     *
     * @param a 待排序的数组
     */
    public static void selectionSort(int a[]) {
        int min = 0, temp = 0;
        //进行n次扫描
        for (int i = 0; i < a.length; i++) {
            min = i;
            //每一次扫描取出待排序中最小的元素
            for (int j = i + 1; j < a.length; j++) {
                if (a[min] > a[j]) {
                    min = j;
                }
            }
            //将该最小的元素放到待排序序列的第一个位置
            if (min != i) {
                temp = a[min];
                a[min] = a[i];
                a[i] = temp;
            }
        }
    }

    /**
     * 调整堆，使满足堆的定义。此例为大根堆
     *
     * @param a          待排序的数组
     * @param startIndex 待调整堆的开始下标
     * @param endIndex   待调整堆的结束下标
     */
    public static void heapAdjust(int a[], int startIndex, int endIndex) {
        //start和end分别为【初始下标】和【结束下标】
        int temp;
        int i;
        for (; 2 * startIndex + 1 <= endIndex; startIndex = i) {
            i = 2 * startIndex + 1;
            if (i < endIndex && a[i] < a[i + 1]) {
                i++;  //i为较大孩子节点的下标
            }
            if (a[startIndex] < a[i]) { //左右孩子中获胜者与父亲比较
                //将孩子结点上位，则以孩子结点的位置进行下一轮的筛选
                temp = a[startIndex];
                a[startIndex] = a[i];
                a[i] = temp;
//                start = i;
            } else {
                //因为整棵树是从下往上调整数，所以，若父节点不需要调整，说明该节点子树已满足堆性质，跳出循环
                break;
            }
        }
    }

    /**
     * 堆排序
     *
     * @param a 待排序的数组
     */
    public static void heapSort(int a[]) {
        for (int i = a.length / 2 - 1; i >= 0; --i) {   //从最后一个非叶节点开始，建立初始堆
            heapAdjust(a, i, a.length - 1);
        }
        //进行排序
        for (int i = a.length - 1; i > 0; --i) {
            //将待排序区最后一个元素和第一个元素进行交换
            int temp = a[i];
            a[i] = a[0];
            a[0] = temp;
            //将剩下的无序元素调整为大顶堆
            heapAdjust(a, 0, i - 1);
        }
    }

    /**
     * 直接插入排序
     *
     * @param a 待排序的数组
     */
    public static void insertionSort(int a[]) {
        int temp;
        int j;
        //遍历数组
        for (int i = 1; i < a.length; i++) {
            temp = a[i]; //将待排序的第一个元素放到监视哨中，作为要插入的数
            j = i - 1;  //从后往前开始查找的位置j
            while (j > -1 && temp < a[j]) {
                a[j + 1] = a[j];    //将大于该数的右移
                j--;
            }
            a[j + 1] = temp;    //最终找到插入位置为j+1
        }
    }

    /**
     * 希尔排序，步长依次为 n/2,n/4,.....
     *
     * @param a 待排序的数组
     */
    public static void shellSort(int a[]) {
        int d = a.length / 2; //初始步长
        while (d >= 1) {
            for (int x = 0; x < d; x++) {   //一共有x组
                //对每一组进行直接插入排序
                for (int i = x + d; i < a.length; i += d) {
                    int temp = a[i];
                    int j = i - d;
                    while (j > x - 1 && temp < a[j]) {
                        a[j + d] = a[j];
                        j -= d;
                    }
                    a[j + d] = temp;
                }
            }
            d = d / 2;  //缩短步长
        }
    }


    /**
     * 二路归并
     *
     * @param a          要归并的数组
     * @param startIndex 要归并数组的起始下标-即第一个子序列的开始下标
     * @param midIndex   要归并数组的中点下标-即第二个子序列的开始下标
     * @param endIndex   要归并数组的终点下标
     */
    public static void merge(int a[], int startIndex, int midIndex, int endIndex) {
        int i = startIndex; //第一个序列的下标
        int j = midIndex + 1;//第二个序列的下标
        int k = 0;   // k是临时数组的下标
        int[] array = new int[endIndex - startIndex + 1]; //临时合并数组
        //每次取出两个序列中的小者，将其放到合并数组中（两个子序列已时排好序的）
        while (i <= midIndex && j <= endIndex) {
            if (a[i] <= a[j]) {
                array[k] = a[i];
                i++;
                k++;
            } else {
                array[k] = a[j];
                j++;
                k++;
            }
        }
        //若第一个序列没扫描完，则将其全部复制到合并数组
        while (i <= midIndex) {
            array[k] = a[i];
            i++;
            k++;
        }
        //若第二个序列没扫描完，则将其全部复制到合并数组
        while (j <= endIndex) {
            array[k] = a[j];
            j++;
            k++;
        }
        //将合并数组复制到原序列中
        for (k = 0, i = startIndex; i <= endIndex; i++, k++) {
            a[i] = array[k];
        }
    }

    /**
     * 归并排序，内部使用递归
     *
     * @param a          要排序的数组
     * @param startIndex 要排序的起始下标
     * @param endIndex   要排序的终点下标
     */
    public static void mergeSort(int a[], int startIndex, int endIndex) {
        int midIndex;
        if (startIndex < endIndex) {
            midIndex = (startIndex + endIndex) / 2;
            mergeSort(a, startIndex, midIndex);
            mergeSort(a, midIndex + 1, endIndex);
            merge(a, startIndex, midIndex, endIndex);
        }

    }


}
