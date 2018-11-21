package com.myself.tree.binarySearchTree;

import java.util.Objects;

/**
 * 二分搜索树 存 key ：value
 * 每一个结点的左孩子小于结点，每一个结点的右孩子大于结点
 * 可以不是完全二叉树
 *
 * @author Created by zion
 * @Date 2018/11/20.
 */
public class BinaryTreeSearch {
    private TreeNode root;

    private int size;

    public BinaryTreeSearch() {
        this.root = null;
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 如果已经存在这个key了，就用新的信息覆盖旧的信息
     *
     * @param key
     * @param value
     */
    public void insert(Integer key, Object value) {
        root = insert(root, key, value);
    }

    /**
     * 递归函数，
     * 向nodewei根的树中插入结点
     *
     * @param node
     * @param key
     * @param value
     * @return
     */
    private TreeNode insert(TreeNode node, Integer key, Object value) {
        //递归到底了
        if (node == null) {
            size++;
            return new TreeNode(key, value);
        }
        if (Objects.equals(node.getKey(), key)) {
            node.setValue(value);
        } else if (key < node.getKey()) {
            node.setLeft(insert(node.getLeft(), key, value));
        } else {
            node.setRight(insert(node.getRight(), key, value));
        }
        return node;
    }

    public boolean containKey(Integer key) {
        return containKey(root, key);
    }

    private boolean containKey(TreeNode node, Integer key) {
        if (node == null) {
            return false;
        }
        if (Objects.equals(key, node.getKey())){
            return true;
        } else if (key < node.getKey()) {
            return containKey(node.getLeft(), key);
        } else {
            return containKey(node.getRight(), key);
        }
    }

    public Object search(Integer key) {
        return search(root, key);
    }

    private Object search(TreeNode node, Integer key) {
        if (node == null) {
            return null;
        }
        if (Objects.equals(node.getKey(), key)) {
            return node.getValue();
        } else if (key < node.getKey()) {
            return search(node.getLeft(), key);
        } else {
            return search(node.getRight(), key);
        }
    }
}
