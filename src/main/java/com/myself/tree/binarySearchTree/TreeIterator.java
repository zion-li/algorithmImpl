package com.myself.tree.binarySearchTree;

import java.util.Stack;

/**
 * 树形结构遍历
 *
 * @author Created by zion
 * @Date 2018/11/21.
 */
public class TreeIterator {

    /**
     * 树形结构遍历（递归方式）
     *
     * @param node
     */
    public void preOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node.getValue());
        preOrder(node.getLeft());
        preOrder(node.getRight());
    }

    /**
     * 树形结构遍历（非递归方式）
     * 借助：FILO栈
     *
     * @param node
     */
    public void preOrderNonRecursive(TreeNode node) {
        //保存所有遍历到的结点
        Stack<TreeNode> stack = new Stack<>();
        while (true) {
            while (node != null) {
                System.out.println(node.getValue());
                stack.push(node);
                node = node.getLeft();
            }
            if (stack.isEmpty()) {
                break;
            }
            node = stack.pop();
            node = node.getRight();
        }
    }

    /**
     * 递归中序遍历
     *
     * @param node
     */
    public void innOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        innOrder(node.getLeft());
        System.out.println(node.getValue());
        innOrder(node.getRight());
    }

    /**
     * 非递归中序遍历
     *
     * @param node
     */
    public void inOrderNonRecursive(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        while (true) {
            while (node != null) {
                stack.push(node);
                node = node.getLeft();
            }
            if (stack.isEmpty()) {
                break;
            }
            System.out.println(node.getValue());
            node = stack.pop();
            node = node.getRight();
        }
    }

    /**
     * 递归后序遍历
     *
     * @param node
     */
    public void postOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        postOrder(node.getLeft());
        postOrder(node.getRight());
        System.out.println(node.getValue());
    }

    /**
     * 非递归后序遍历
     */
    public void postOrderNonRecursive(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        while (true) {
            if (node != null) {
                stack.push(node);
                node = node.getLeft();
            } else {
                if (stack.isEmpty()) {
                    return;
                }
                if (stack.lastElement().getRight() == null) {
                    node = stack.pop();
                    System.out.println(node.getValue());
                    while (node == stack.lastElement().getRight()) {
                        System.out.println(stack.lastElement().getValue());
                        node = stack.pop();
                        if (stack.isEmpty()) {
                            break;
                        }
                    }
                }

                if (!stack.isEmpty()) {
                    node = stack.lastElement().getRight();
                } else {
                    node = null;
                }
            }
        }
    }
}
