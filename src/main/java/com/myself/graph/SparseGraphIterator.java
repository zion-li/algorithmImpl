package com.myself.graph;

/**
 * 图的遍历
 * 邻接矩阵->O(v) v为结点个个数
 * 邻接表->O(1)
 *
 * @author Created by zion
 * @Date 2018/12/6.
 */
public class SparseGraphIterator {

    /**
     * 遍历的图
     */
    private SparseGrahp sparseGrahp;

    /**
     * 图的哪一个结点
     */
    private int v;
    /**
     * 当前迭代到的位置
     */
    private int index;

    /**
     * @param sparseGrahp 迭代的图
     * @param v           迭代的图的结点
     */
    public SparseGraphIterator(SparseGrahp sparseGrahp, int v) {
        this.sparseGrahp = sparseGrahp;
        this.v = v;
        this.index = 0;
    }

    public int begin() {
        index = 0;
        if (sparseGrahp.g.get(v).size() != 0) {
            return sparseGrahp.g.get(v).get(0);
        }
        return -1;
    }

    public int next() {
        index++;
        if (index < sparseGrahp.g.get(v).size()) {
            return sparseGrahp.g.get(v).get(index);
        }
        return -1;
    }

    public boolean end() {
        return index >= sparseGrahp.g.get(v).size();
    }

}
