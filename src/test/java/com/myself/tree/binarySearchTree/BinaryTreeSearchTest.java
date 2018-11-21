package com.myself.tree.binarySearchTree;

import org.junit.Test;

/**
 * @author Created by zion
 * @Date 2018/11/21.
 */
public class BinaryTreeSearchTest {
    @Test
    public void size() throws Exception {

    }

    @Test
    public void isEmpty() throws Exception {

    }

    @Test
    public void insert() throws Exception {
        BinaryTreeSearch binaryTreeSearch = new BinaryTreeSearch();
        binaryTreeSearch.insert(6, 6);
        binaryTreeSearch.insert(4, 4);
        binaryTreeSearch.insert(7, 7);
        binaryTreeSearch.insert(3, 3);
//        binaryTreeSearch.insert(2, 2);
//        binaryTreeSearch.insert(3, 3);
//        binaryTreeSearch.insert(8, 8);
//        binaryTreeSearch.insert(9, 9);

        boolean flag = binaryTreeSearch.containKey(1);
        Object s = binaryTreeSearch.search(33);
        System.out.println(s);

        TreeIterator treeIterator = new TreeIterator();
        treeIterator.preOrder(binaryTreeSearch.getNode());
        System.out.println();
        treeIterator.innOrder(binaryTreeSearch.getNode());

    }

    @Test
    public void containKey() throws Exception {

    }

    @Test
    public void search() throws Exception {

    }

}