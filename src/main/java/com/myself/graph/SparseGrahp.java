package com.myself.graph;

import java.util.Vector;

/**
 * 稀疏图，邻接表实现
 * 对于每一行来说，每一个顶点只存储于这个顶点相连接的顶点的信息
 * 邻接表是一个二维容器，第一维是一个数组，存储所有顶点，第二维是链表，
 * 存储所有与这个点领接的点集。
 * 0 1          0结点只连接1
 * 1 0 2 3      1结点只连接0 2 3
 * 2 1 3        2结点只连接1 3
 * 3 1 2        3结点只连接1 2
 *
 * @author Created by zion
 * @Date 2018/12/6.
 */
public class SparseGrahp {
    /**
     * 图的节点个数
     */
    int n;
    /**
     * 图的边的条数
     */
    int m;
    /**
     * 是否是有向图
     */
    boolean director;
    /**
     * 图的邻接表中存储节点的数组，g[i]为与g相邻的所有顶点的编号
     */
    Vector<Vector<Integer>> g =new Vector<>();

    /**
     * 构造函数
     *
     * @param n
     * @param director
     */
    public SparseGrahp(int n, boolean director) {
        this.n = n;
        this.m = 0;
        this.director = director;
        for (int i = 0; i < n; i++) {
            g.add(i, new Vector<Integer>(n));
        }
    }

    /**
     * 放回当前节点数
     *
     * @return
     */
    public int v() {
        return this.n;
    }

    /**
     * 返回当前的边数
     *
     * @return
     */
    public int e() {
        return this.m;
    }

    /**
     * 允许有平行边了,
     * 以为取消了平行边，那么每一次添加边的时候，都要判断是否已经有了这个边
     * 此时的时间复杂度为O（n）级别了，成本太高了，所以允许了平行边。
     *
     * @param v 结点v索引
     * @param w 结点w索引
     */
    public void addEdge(int v, int w) {
        if (0 <= v && v < n && 0 <= w && w < n) {
            g.get(v).add(w);
            if (v != w && !director) {
                g.get(w).add(v);
            }
            m++;
        }
    }

    public boolean hasEdge(int v, int w) {
        if (0 < v && v < n && 0 < w && w < n) {
            for (int i = 0; i < g.get(v).size(); i++) {
                if (g.get(v).get(i) == w) {
                    return true;
                }
            }
        }
        return false;
    }
}
