package com.myself.tree.binarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 广度优先遍历算法
 * 借助一个队列实现的
 *
 * @author Created by zion
 * @Date 2018/11/21.
 */
public class BFSSearch {

    private Queue<TreeNode> queue = new LinkedList<>();

    public void levelOrder(TreeNode node) {
        queue.offer(node);
        while (!queue.isEmpty()) {
            TreeNode tmpNode = queue.poll();

            System.out.println(tmpNode.getKey() + ":" + tmpNode.getValue());

            if (tmpNode.getLeft() != null) {
                queue.offer(tmpNode.getLeft());
            }
            if (tmpNode.getRight() != null) {
                queue.offer(tmpNode.getRight());
            }
        }
    }
}
