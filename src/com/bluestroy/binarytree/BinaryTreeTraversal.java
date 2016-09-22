package com.bluestroy.binarytree;

/**
 * Created by Troy on 2016/9/22.
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的遍历类。时间复杂度都是O(n)，空间复杂度都是O(logn)树的深度
 */
public class BinaryTreeTraversal {

    /**
     * 先序遍历（中、左、右）
     * @param node 当前的父节点
     * @param <T>   泛型
     */
    public static <T> void preOrder(TreeNode<T> node){
        if(node == null) return;
        else {
            //打印父节点值->遍历左子树->遍历右子树
            System.out.println(node.value);
            preOrder(node.leftChild);
            preOrder(node.rightChild);
        }
    }

    /**
     * 中序遍历（左、中、右）
     * @param node  当前的父节点
     * @param <T>   泛型
     */
    public static <T> void midOrder(TreeNode<T> node){
        if (node !=null){
            //遍历左子树->打印父节点值->遍历右子树
            midOrder(node.leftChild);
            System.out.println(node.value);
            midOrder(node.rightChild);
        }
    }

    /**
     * 后序遍历（左、右、中）
     * @param node  当前的父节点
     * @param <T>   泛型
     */
    public static <T> void postOrder(TreeNode<T> node){
        if (node !=null){
            //遍历左子树->遍历右子树->打印父节点值
            postOrder(node.leftChild);
            postOrder(node.rightChild);
            System.out.println(node.value);
        }
    }


    /**
     * 层序遍历
     * @param root  根节点
     * @param <T>   泛型
     */
    public static <T> void levelOrder(TreeNode<T> root){
        Queue<TreeNode<T>> queue = new LinkedList<TreeNode<T>>();
        queue.offer(root);
        while (!queue.isEmpty()){
            //父节点出队，输出
            TreeNode<T> node = queue.poll();
            System.out.println(node.value);
            //将其左右孩子入队。这样就实现了层次。其实一开始的数组顺序就是层序顺序。
            if (node.leftChild != null){
                queue.offer(node.leftChild);
            }
            if (node.rightChild !=null){
                queue.offer(node.rightChild);
            }
        }
    }


}
