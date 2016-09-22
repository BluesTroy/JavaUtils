package com.bluestroy.binarytree;

/**
 * Created by Troy on 2016/9/22.
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * 反转二叉树。即交换二叉树的左右子树
 */
public class BinaryTreeReverse {

    public <T> TreeNode<T> invertTree(TreeNode<T> root){
        return root;
    }

    /**
     * 先序遍历法反转二叉树。
     * @param root
     * @param <T>
     */
    public <T> void preOrder(TreeNode<T> root){
        if(root!=null){
            TreeNode<T> temp = root.leftChild;
            root.leftChild = root.rightChild;
            root.rightChild = temp;
            preOrder(root.leftChild);
            preOrder(root.rightChild);
        }
    }

    /**
     * 后序遍历发反转二叉树。
     * @param root
     * @param <T>
     */
    public <T> void postOrder(TreeNode<T> root){
        if(root!=null){
            postOrder(root.leftChild);
            postOrder(root.rightChild);
            TreeNode<T> temp = root.leftChild;
            root.leftChild = root.rightChild;
            root.rightChild = temp;
        }
    }

    /**
     * 中序遍历法反转二叉树
     * @param root
     * @param <T>
     */
    public <T> void midOrder(TreeNode<T> root){
        if(root!=null){
            midOrder(root.leftChild);
            TreeNode<T> temp = root.leftChild;
            root.leftChild = root.rightChild;
            root.rightChild = temp;
            midOrder(root.leftChild);
        }
    }

    /**
     * 层序遍历法反转二叉树
     * @param root
     * @param <T>
     * @return
     */
    public <T> TreeNode<T> levelOrder(TreeNode<T> root){
        if (root == null) return null;
        else {
            Queue<TreeNode<T>> queue = new LinkedList<TreeNode<T>>();
            queue.offer(root);
            while (!queue.isEmpty()){
                TreeNode node  = queue.poll();
                if(node.leftChild!=null){
                    queue.offer(node.leftChild);
                }
                if (node.rightChild!=null){
                    queue.offer(node.rightChild);
                }
                TreeNode<T> temp = node.leftChild;
                node.leftChild = node.rightChild;
                node.rightChild = temp;
            }
            return root;
        }
    }

}
