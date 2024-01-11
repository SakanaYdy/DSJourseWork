package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Random;

public class SimpleMenuPage extends JFrame {

    private JTextField inputField;
    private JButton createButton;
    private JButton displayButton;

    static int[][] g;
    static Random random = new Random();
    List<PrimAlgorithm.Edge> result;

    public SimpleMenuPage() {
        setTitle("管道修建");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // 输入框
        inputField = new JTextField("请输入居民区个数：");
        mainPanel.add(inputField, BorderLayout.CENTER);

        // 数据初始化以及最佳方案
        createButton = new JButton("数据初始化以及最佳方案计算");
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = inputField.getText();
                // System.out.println(inputField.getText());
                String[] split = input.split("：");
                int n = Integer.parseInt(split[1]);
                g = new int[n + 1][n + 1];
                for(int i = 0;i<n;i++){
                    for(int j = i + 1;j<n;j++){
                        g[i][j] = random.nextInt(20);  // 随机初始化两地之间的距离
                        while(g[i][j] == 0) g[i][j] = random.nextInt(20);
                        g[j][i] = g[i][j];
                    }
                }
                NIO.write(g,n);
                result = PrimAlgorithm.prim(g, n);
                for (PrimAlgorithm.Edge edge : result) {
                    System.out.println("Edge: " + edge.from + " - " + edge.to + " Weight: " + edge.weight);
                }
            }
        });
        mainPanel.add(createButton,BorderLayout.NORTH);

        // 显示按钮
        displayButton = new JButton("方案显示");
        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new MultiTree(result).setVisible(true);
                    }
                });
            }
        });
        mainPanel.add(displayButton, BorderLayout.SOUTH);

        // 将主面板添加到窗口中
        add(mainPanel);

        // 居中显示窗口
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SimpleMenuPage().setVisible(true));
    }
}
