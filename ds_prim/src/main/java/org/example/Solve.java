package org.example;

public class Solve {

    // 如果图不连通，则返回INF(值是0x3f3f3f3f), 否则返回最小生成树的树边权重之和
    public static boolean[] prim(int[][] g,int n) {
        int[] dist = new int[n + 1];
        boolean[] st = new boolean[n + 1];
        for(int i = 1;i<=n;i++) dist[i] = Integer.MAX_VALUE;

        int res = 0;
        for (int i = 0; i < n; i++) {
            int t = -1;
            for (int j = 1; j <= n; j++)
                if (!st[j] && (t == -1 || dist[t] > dist[j]))
                    t = j;

            // if (i!=0 && dist[t] == Integer.MAX_VALUE) return Integer.MAX_VALUE;

            if (i != 0) res += dist[t];
            st[t] = true;

            for (int j = 1; j <= n; j++) dist[j] = Math.min(dist[j], g[t][j]);
        }

        return st;
    }
}
