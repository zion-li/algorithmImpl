package com.myself.tree.unionFind;

/**
 * 并查集，剞劂连接关系问题
 * union--find两个操作
 * 每一个连接起来的组，都有相同的标示（数组中元素相同的元素为相连的）
 *
 * @author Created by zion
 * @Date 2018/11/21.
 */
public class UnionFind {

    private int[] parent;
    /**
     * 以i为根的结点的结点层数
     */
    private int[] rank;
    /**
     * 结点元素的个数
     */
    private int size;

    public UnionFind(int n) {
        this.parent = new int[n];
        this.size = 0;
        //所有元素都是独立的组，都不连接
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }


    public int find(int p) {
        if (p >= 0 && p < size) {
            //1:方法一
//            while (p != parent[p]) {
//                //路径压缩，提高性能
//                parent[p] = parent[parent[p]];
//                p = parent[p];
//            }
//            return p;
            //方法二
            if (p != parent[p]) {
                parent[p] = find(parent[p]);
            }
            return parent[p];
        }
        return -1;
    }

    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }


    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) {
            return;
        }
        if (rank[pRoot] < rank[qRoot]) {
            parent[pRoot] = qRoot;
        } else if (rank[qRoot] < rank[pRoot]) {
            parent[qRoot] = pRoot;
        } else {
            parent[pRoot] = qRoot;
            rank[qRoot] += 1;

        }
    }
}
