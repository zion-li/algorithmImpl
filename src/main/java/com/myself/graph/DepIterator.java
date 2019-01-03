package com.myself.graph;

/**
 * 图的深度优先遍历
 * 0 1 2 5 6
 * 1 0
 * 2 0
 * 3 4 5
 * 4 3 5 6
 * 5 0 3 4
 * 6 0 4
 * 过程：
 * 0 0.1 1.0 退回0.1 0.2 2.0 退回0.2 0.5 5.0 5.3 3.4 4.3 4.5 4.6 6.0 6.4 退回4 退回3 退回5 退回0 0.6 结束
 *
 * @author Created by zion
 * @Date 2019/1/3.
 */
public class DepIterator {

    /**
     * 遍历的图
     */
    private SparseGrahp sparseGrahp;

    /**
     * 是否已经遍历过了
     */
    boolean[] visited;

    /**
     * 相连结点的Id相同
     */
    int[] ids;
    /**
     * 连通分量的个数
     */
    int ccount;

    public DepIterator(SparseGrahp sparseGrahp) {
        this.sparseGrahp = sparseGrahp;
        this.ids = new int[sparseGrahp.v()];
        this.visited = new boolean[sparseGrahp.v()];
        this.ccount = 0;
        for (int i = 0; i < sparseGrahp.v(); i++) {
            visited[i] = false;
            ids[i] = -1;
        }

        for (int i = 0; i < sparseGrahp.v(); i++) {
            if (!visited[i]) {
                dfs(i);
                ccount++;
            }
        }
    }

    public int count() {
        return ccount;
    }

    public boolean isConntcted(int v, int w) {
        if (0 < v && v < sparseGrahp.v() && 0 <= w && w < sparseGrahp.v()) {
            return ids[v] == ids[w];
        }
        return false;
    }

    /**
     * 对v这个结点进行一次深度优先遍历
     *
     * @param v
     */
    private void dfs(int v) {
        visited[v] = true;
        ids[v] = ccount;
        SparseGraphIterator sparseGraphIterator = new SparseGraphIterator(sparseGrahp, v);
        for (int i = sparseGraphIterator.begin(); !sparseGraphIterator.end(); i = sparseGraphIterator.next()) {
            if (!visited[i]) {
                dfs(i);
            }
        }
    }
}
