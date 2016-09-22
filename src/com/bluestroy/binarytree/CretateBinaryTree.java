package com.bluestroy.binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Troy on 2016/9/22.
 */

/**
 * 数组表示法转换为二叉链表
 */
public class CretateBinaryTree {

    /**
     * 数组表示法转换为二叉链表
     * @param array 数组
     * @param nullValue 数组中的空值表示
     * @param <T>   泛型
     * @return  二叉链表的根节点
     */
    public static <T> TreeNode<T> arrayToBinaryTree(T[] array, T nullValue){
        if(array==null || array.length==0){
            return null;
        }

        //建树的过程本质是层序遍历的过程。

        //tempList保存当前的父节点，以便顺序往后寻找这些父节点们的孩子
        List<TreeNode<T>> tempList = new ArrayList<TreeNode<T>>();
        TreeNode<T> root = new TreeNode<T>(array[0]);
        tempList.add(root);
        int index =1;
        loop:
        while (tempList.size()>0 && index < array.length){
            //newList保存在寻找过程中新增的节点，他们在下次遍历时将作为父节点
            List<TreeNode<T>> newList = new ArrayList<TreeNode<T>>();
            for (TreeNode<T> node : tempList){
                if (index == array.length) break loop;

                //若左节点不空则设置左孩子，并将左节点加入新链表
                if (array[index]!=null && !array[index].equals(nullValue)){
                    node.leftChild = new TreeNode<T>(array[index]);
                    newList.add(node.leftChild);
                }
                //若左节点为空，则默认为空，检查下一个右节点
                index++;
                if (index == array.length) break loop;
                //如果右节点不空，则设置右孩子，并将左节点加入新链表
                if(array[index] !=null && !array[index].equals(nullValue)){
                    node.rightChild = new TreeNode<T>(array[index]);
                    newList.add(node.rightChild);
                }
                index++;
            }
            tempList = newList;
        }
        return root;    //返回根节点

    }
}
