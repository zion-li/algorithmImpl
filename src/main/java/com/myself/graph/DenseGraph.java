package com.myself.graph;

/**
 * 稠密图,邻接矩阵实现（二维矩阵表示）
 * 无向图：矩阵对称
 * 有向图：不是对称关系
 *
 * @author Created by zion
 * @Date 2018/12/6.
 */
public class DenseGraph {
    /**
     * n 点数
     * m 边数
     */
    int n, m;

    /**
     * 是否有向
     */
    boolean directed;

    /**
     * 邻接矩阵
     */
    Boolean[][] matrix;

    /**
     * 构造函数，起始时每个顶点的边数目都为0
     *
     * @param n        顶点个个数
     * @param directed 是否是有向图
     */
    public DenseGraph(int n, boolean directed) {
        //节点数
        this.n = n;
        //每个结点的边数
        this.m = 0;
        //是否是有向图
        this.directed = directed;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = false;
            }
        }
    }

    /**
     * 返回当前节点数
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
     * 在结点v到结点W之间创建边
     *
     * @param v 结点v索引
     * @param w 结点w索引
     */
    public void addEdge(int v, int w) {
        if (0 <= v && v < n && 0 <= w && w < n) {
            if (hasEdge(v, w)) {
                return;
            }
            matrix[v][w] = true;
            if (!directed) {
                matrix[w][v] = true;
            }
            m++;
        }
    }

    public boolean hasEdge(int v, int w) {
        if (0 <= v && v < n && 0 <= w && w < n) {
            return matrix[v][w];
        }
        return false;
    }
}
