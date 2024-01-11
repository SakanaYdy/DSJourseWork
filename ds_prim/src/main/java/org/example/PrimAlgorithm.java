package org.example;

import java.util.ArrayList;
import java.util.List;

public class PrimAlgorithm {
    public static List<Edge> prim(int[][] g, int n) {
        int[] dist = new int[n];
        int[] parent = new int[n];
        boolean[] st = new boolean[n];
        List<Edge> edges = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            dist[i] = Integer.MAX_VALUE;
            parent[i] = -1;
        }

        dist[0] = 0;

        for (int i = 0; i < n; i++) {
            int t = -1;
            for (int j = 0; j < n; j++)
                if (!st[j] && (t == -1 || dist[t] > dist[j]))
                    t = j;

            if (i != 0) {
                edges.add(new Edge(parent[t], t, g[parent[t]][t]));
            }

            st[t] = true;

            for (int j = 0; j < n; j++) {
                if (!st[j] && g[t][j] < dist[j]) {
                    dist[j] = g[t][j];
                    parent[j] = t;
                }
            }
        }

        return edges;
    }

    public static class Edge {
        int from;
        int to;
        int weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

    }

    public static void main(String[] args) {
        int n = 5;
        int[][] graph = {
                {0, 2, 0, 6, 0},
                {2, 0, 3, 8, 5},
                {0, 3, 0, 0, 7},
                {6, 8, 0, 0, 9},
                {0, 5, 7, 9, 0}
        };

        List<Edge> result = prim(graph, n);
        System.out.println("Minimum Spanning Tree Edges:");
        for (Edge edge : result) {
            System.out.println("Edge: " + edge.from + " - " + edge.to + " Weight: " + edge.weight);
        }
    }
}
