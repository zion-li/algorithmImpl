package com.myself.tree.binarySearchTree;

import java.util.Objects;

/**
 * 二分搜索树 存 key ：value
 * 每一个结点的左孩子小于结点，每一个结点的右孩子大于结点
 * 可以不是完全二叉树
 * 可以退化成为 链表 ->O(N) 级别的
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
        if (Objects.equals(key, node.getKey())) {
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

    public TreeNode getMin() {
        if (root == null) {
            return null;
        }
        return getMin(root);
    }

    private TreeNode getMin(TreeNode node) {
        if (node.getLeft() == null) {
            return node;
        }
        return getMin(node.getLeft());
    }

    public TreeNode getMax() {
        if (root == null) {
            return null;
        }
        return getMax(root);
    }

    private TreeNode getMax(TreeNode node) {
        if (node.getRight() == null) {
            return node;
        }
        return getMax(node.getRight());
    }

    public void deleteMin() {
        if (root != null) {
            root = deleteMin(root);
        }
    }

    private TreeNode deleteMin(TreeNode node) {
        //如果当前节点的左孩子已经为空了，证明当前节点就是最小节点
        if (node.getLeft() == null) {
            size--;
            //这么写已经覆盖了两种情况
            return node.getRight();
        }
        node.setLeft(deleteMin(node.getLeft()));
        return node;
    }

    public void deleteMax() {
        if (root != null) {
            root = deleteMax(root);
        }
    }

    public TreeNode deleteMax(TreeNode node) {
        //如果当前节点的左孩子已经为空了，证明当前节点就是最小节点
        if (node.getRight() == null) {
            size--;
            //这么写已经覆盖了两种情况
            return node.getLeft();
        }
        node.setLeft(deleteMin(node.getRight()));
        return node;
    }

    /**
     * 如果删除的结点不止最小值，也不止最大值
     * 这时候应该找到这个结点d的s
     * s=min(d->right)
     * s-right=deleteMin(d_right)
     * 更新树形结构
     */
    public void deleteKey(Integer key) {
        if (root != null) {
            root = deleteKey(root, key);
        }
    }

    /**
     * 用的是右子树的最小值
     *
     * @param node
     * @param key
     * @return
     */
    private TreeNode deleteKey(TreeNode node, Integer key) {
        //寻找
        if (node == null) {
            return null;
        }
        if (key < node.getKey()) {
            node.setLeft(deleteKey(node.getLeft(), key));
            return node;
        } else if (key > node.getKey()) {
            node.setRight(deleteKey(node.getRight(), key));
            return node;
        } else {
            //这块是真正的处理方法
            if (node.getLeft() == null) {
                size--;
                //这么写已经覆盖了两种情况
                return node.getRight();
            }
            if (node.getRight() == null) {
                size--;
                //这么写已经覆盖了两种情况
                return node.getLeft();
            }
            //指向了node右子树的最小值
            TreeNode nextNode = new TreeNode(getMin(node.getRight()));
            //而，这里又删除了右子树的最小值，你删除了，但是有nextNode直向这个最小值，也会跟着没有了
            //所以需要新生成一个结点
            nextNode.setRight(deleteMin(node.getRight()));
            nextNode.setLeft(node.getLeft());
            return nextNode;
        }
    }
}
