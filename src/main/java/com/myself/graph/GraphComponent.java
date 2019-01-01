package com.myself.graph;

/**
 * 图的联通分量，（深度优先遍历）
 * 深度优先遍历
 * 0 1 2 5 6
 * 1 0
 * 2 0
 * 3 4 5
 * 4 3 5 6
 * 5 0 3 4
 * 6 0 4
 * 过程
 * 0 1 看1 退回0 0的2 退回0 0的5  5的3 3的4  4的6 退回4 退回3 退回5 退回0 完成0结点的遍历
 *
 * @author Created by zion
 * @Date 2019/1/1.
 */
public class GraphComponent {

    /**
     * 稀疏图
     */
    private SparseGrahp sparseGrahp;

    /**
     * 当期的结点是否已经被访问过了
     */
    Boolean[] visited;
    /**
     * 联通分量
     */
    int ccount;

    public GraphComponent(SparseGrahp sparseGrahp) {
        this.sparseGrahp = sparseGrahp;
        this.ccount = 0;
        this.visited = new Boolean[sparseGrahp.v()];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }

        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                dfs(i);
                ccount++;
            }
        }
    }

    public int getCcount() {
        return ccount;
    }

    /**
     * 深度优先遍历一个树
     *
     * @param i
     */
    private void dfs(int i) {
        visited[i] = true;
        //看所有相邻的结点
        SparseGraphIterator s = new SparseGraphIterator(sparseGrahp, i, 0);
        for (int j = s.begin(); !s.end(); j = s.next()) {
            if (!visited[j]) {
                dfs(j);
            }
        }

    }
}
