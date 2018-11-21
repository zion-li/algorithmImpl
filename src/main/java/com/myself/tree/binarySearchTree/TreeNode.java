package com.myself.tree.binarySearchTree;

/**
 * 二叉树的结点结构
 *
 * @author Created by zion
 * @Date 2018/11/20.
 */
public class TreeNode {

    private Integer key;

    private Object value;

    private TreeNode left;

    private TreeNode right;

    public TreeNode() {
    }

    public TreeNode(Integer key, Object value) {
        this.key = key;
        this.value = value;
        this.left = this.right = null;
    }

    public TreeNode(TreeNode node) {
        this.key = node.getKey();
        this.value = node.getValue();
        this.left = node.getLeft();
        this.right = node.getRight();
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}
