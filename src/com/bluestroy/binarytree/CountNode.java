package com.bluestroy.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Troy on 2016/9/22.
 */
public class CountNode {
    public static int count = 0;

    /**
     * 统计节点个数，先序遍历法(中左右)
     * @param node
     * @param <T>
     */
    public static <T> void preOrder(TreeNode<T> node){
        if(node != null){
            count++;
            preOrder(node.leftChild);
            preOrder(node.rightChild);
        }
    }

    /**
     * 统计节点个数，后序遍历法（左右中）
     * @param node
     * @param <T>
     * @return 节点个数
     */
    public static <T> int postOrder(TreeNode<T> node){
        if(node == null){
            return 0;
        }else {
            int leftCount = postOrder(node.leftChild);
            int rightCount = postOrder(node.rightChild);
            return leftCount+rightCount+1;
        }
    }

    /**
     * 统计叶子节点个数，中序遍历法（左中右）
     * @param node
     * @param <T>
     */
    public static <T> void midOrder(TreeNode<T> node){
        if(node!=null){
            midOrder(node.leftChild);
            if(node.leftChild == null && node.rightChild==null){
                count++;
            }
            midOrder(node.rightChild);
        }
    }

    /**
     * 统计叶子节点个数
     * @param node
     * @param <T>
     * @return
     */
    public static <T> int countLeaf(TreeNode<T> node){
        if(node == null){
            return 0;
        }else if (node.leftChild ==null && node.rightChild==null){
            return 1;
        }else {
            int leftLeaf = countLeaf(node.leftChild);
            int rightLeaf = countLeaf(node.rightChild);
            return leftLeaf+rightLeaf;
        }
    }

    /**
     * 统计值为x的节点个数，层序遍历法
     * @param root  根节点
     * @param x 要统计的值
     * @param <T>   泛型
     * @return  值为x的节点个数
     */
    public static <T> int leafOrder(TreeNode<T> root, T x){
        Queue<TreeNode<T>> queue = new LinkedList<TreeNode<T>>();
        queue.offer(root);
        int cnt = 0;
        while (!queue.isEmpty()){
            TreeNode<T> node = queue.poll();
            if(node.value.equals(x)){
                cnt++;
            }
            if(node.leftChild!=null){
                queue.offer(node.leftChild);
            }
            if (node.rightChild!=null){
                queue.offer(node.rightChild);
            }
        }
        return cnt;
    }


}
