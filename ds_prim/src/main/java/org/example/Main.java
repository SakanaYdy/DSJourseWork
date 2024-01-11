package org.example;

import javax.swing.*;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    static int[][] g;
    static Random random = new Random();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        g = new int[n + 1][n + 1];
        for(int i = 0;i<n;i++){
            for(int j = i + 1;j<n;j++){
                g[i][j] = random.nextInt(20);  // 随机初始化两地之间的距离
                while(g[i][j] == 0) g[i][j] = random.nextInt(20);
                g[j][i] = g[i][j];
            }
        }
        NIO.write(g,n);
        List<PrimAlgorithm.Edge> result = PrimAlgorithm.prim(g, n);
        for (PrimAlgorithm.Edge edge : result) {
            System.out.println("Edge: " + edge.from + " - " + edge.to + " Weight: " + edge.weight);
        }

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MultiTree(result).setVisible(true);
            }
        });
    }
}