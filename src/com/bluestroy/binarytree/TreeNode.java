package com.bluestroy.binarytree;

/**
 * Created by Troy on 2016/9/22.
 */

/**
 * 二叉树的节点，包括节点的值，和两个指向左右孩子节点的指针
 * @param <T>   泛型
 */
public class TreeNode<T> {
    public T value;    //节点的值
    public TreeNode<T> leftChild;  //左孩子节点
    public TreeNode<T> rightChild; //右孩子节点

    public TreeNode(T value, TreeNode<T> leftChild, TreeNode<T> rightChild) {
        this.value = value;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public TreeNode(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "value=" + value +
                '}';
    }
}
