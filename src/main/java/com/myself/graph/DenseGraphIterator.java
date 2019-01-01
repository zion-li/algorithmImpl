package com.myself.graph;

/**
 * 稠密图的遍历
 *
 * @author Created by zion
 * @Date 2018/12/6.
 */
public class DenseGraphIterator {

    /**
     * 一个稠密图
     */
    private DenseGraph denseGraph;

    private int v;
    /**
     * 当前的位置,不能从0开始，不见得有这条边，应该找第一个为true的
     */
    private int index;

    /**
     * 构造器，初始的时候，不应该找index=0，应该找index=true的点
     *
     * @param denseGraph 迭代的图
     * @param v          迭代的图的结点
     */
    public DenseGraphIterator(DenseGraph denseGraph, int v) {
        this.denseGraph = denseGraph;
        this.v = v;
        this.index = -1;
    }

    public int begin() {
        index = -1;
        return next();
    }

    public int next() {
        for (index += 1; index < denseGraph.v(); index++) {
            if (denseGraph.matrix[v][index]) {
                return index;
            }
        }
        return -1;
    }

    public boolean end() {
        return index >= denseGraph.matrix[v].length;
    }
}
