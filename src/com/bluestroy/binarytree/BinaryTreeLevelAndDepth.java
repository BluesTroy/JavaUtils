package com.bluestroy.binarytree;

/**
 * Created by Troy on 2016/9/22.
 */
public class BinaryTreeLevelAndDepth {

    /**
     * 打印每个节点的层数
     * @param root
     * @param <T>
     */
    public <T> void printLevel(TreeNode<T> root){
        preOrderLevel(root,1);
    }

    /**
     * 打印node节点的层数
     * @param root
     * @param node
     * @param <T>
     */
    public <T> void printNodeLevel(TreeNode<T> root, TreeNode<T> node){
        int level = preOrderNodeLevel(root,node,1);
        System.out.println(level);
    }

    /**
     * 先序遍历，打印每个节点的层数
     * @param node
     * @param level
     * @param <T>
     */
    public <T> void preOrderLevel(TreeNode<T> node , int level){
        if(node!=null){
            System.out.println(node.value+" "+level);
            preOrderLevel(node.leftChild,level+1);
            preOrderLevel(node.rightChild,level+1);
        }
    }

    /**
     * 先序遍历，求node节点的层数
     * @param root  树的根节点
     * @param node  要求的node节点
     * @param level 根节点的层数，一般为1
     * @param <T>   泛型
     * @return
     */
    public <T> int preOrderNodeLevel(TreeNode<T> root, TreeNode<T> node, int level){
        if(root!=null){
            //找到该节点,则打印该节点的层数
            if (root.equals(node)){
                return level;
            }
            preOrderLevel(root.leftChild,level+1);
            preOrderLevel(root.rightChild,level+1);
        }
        return -1;//层数返回-1表示没有找到该节点
    }

    /**
     * 求树的高度，即树的最大深度，即根节点到叶子节点的最长路径长度。
     * 树中叶子节点所在层次的最小值
     * @param root  根节点
     * @param level 根节点的层数，一般为1
     * @param <T>   泛型
     * @return  树的高度
     */
    public <T> int preOrderMaxDepth(TreeNode<T> root, int level){
        int maxLevel =0;
        if(root!=null){
            if(root.leftChild==null && root.rightChild==null){
                if (level > maxLevel){
                    maxLevel = level;
                }
            }
            preOrderMaxDepth(root.leftChild, level+1);
            preOrderMaxDepth(root.rightChild, level+1);
        }
        return maxLevel;
    }

    /**
     * 递归法求树的高度。
     * @param root  根节点
     * @param <T>   泛型
     * @return  树的高度
     */
    public <T> int maxDepth(TreeNode<T> root){
        return root==null? 0: Math.max(maxDepth(root.leftChild),
                maxDepth(root.rightChild))+1;
    }

    /**
     *
     * @param root
     * @param <T>
     * @return
     */
    public <T> int minDepth(TreeNode<T> root){
        return root ==null? 0: preOrderMinDepth(root,1);
    }

    /**
     * 求一颗非空二叉树的最小深度。即根节点到叶子节点的最短路径的长度。
     * 树中叶子节点所在层次的最小值
     * @param root  根节点
     * @param level 根节点的层数，一般为1
     * @param <T>   泛型
     * @return  二叉树的最小深度
     */
    private  <T> int preOrderMinDepth(TreeNode<T> root, int level){
        int minLevel = Integer.MAX_VALUE;
        if (root != null){
            if (root.leftChild==null && root.rightChild==null){
                if (level < minLevel){
                    minLevel = level;
                }
            }
            preOrderMinDepth(root.leftChild, level+1);
            preOrderMinDepth(root.rightChild, level+1);
        }
        return minLevel;
    }
}
