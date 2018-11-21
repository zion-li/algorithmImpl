package com.myself.tree.binarySearchTree;

/**
 * 树形结构遍历
 *
 * @author Created by zion
 * @Date 2018/11/21.
 */
public class TreeIterator {

    public void preOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node.getValue());
        preOrder(node.getLeft());
        preOrder(node.getRight());
    }

    public void innOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        innOrder(node.getLeft());
        System.out.println(node.getValue());
        innOrder(node.getRight());
    }

    public void postOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        postOrder(node.getLeft());
        postOrder(node.getRight());
        System.out.println(node.getValue());
    }

}
