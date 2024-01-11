package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import java.util.ArrayList;

public class MultiTree extends JFrame {

    private List<PrimAlgorithm.Edge> edges;
    private JPanel treePanel;

    private static class TreeNode {
        int data;
        List<TreeNode> children;

        TreeNode(int data) {
            this.data = data;
            this.children = new ArrayList<>();
        }
    }

    private TreeNode root;

    public MultiTree(List<PrimAlgorithm.Edge> edges) {
        this.edges = edges;
        setTitle("Multi Tree Visualization");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        treePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawTree(g, getWidth() / 2, 60, root, 300);
            }
        };

        JButton addButton = new JButton("show");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buildTreeFromEdges();
                repaint();
            }
        });

        JPanel controlPanel = new JPanel();
        controlPanel.add(addButton);

        setLayout(new BorderLayout());
        add(treePanel, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);
    }

    private void drawTree(Graphics g, int x, int y, TreeNode node, int xOffset) {
        if (node != null) {
            g.setColor(Color.BLACK);
            g.fillOval(x - 15, y - 15, 30, 30);
            g.setColor(Color.WHITE);
            g.drawString(String.valueOf(node.data), x - 5, y + 5);

            int numOfChildren = node.children.size();
            int startX = x - (numOfChildren - 1) * xOffset / 2;

            for (int i = 0; i < numOfChildren; i++) {
                int newX = startX + i * xOffset;
                int newY = y + 50;
                g.setColor(Color.BLACK);
                g.drawLine(x, y, newX, newY);
                drawTree(g, newX, newY, node.children.get(i), xOffset / 2);
                // 显示边的权值
                g.setColor(Color.BLUE);
                g.drawString(String.valueOf(getEdgeWeight(node.data, node.children.get(i).data)),
                        (x + newX) / 2, (y + newY) / 2);
            }
        }
    }

    private void buildTreeFromEdges() {
        for (PrimAlgorithm.Edge edge : edges) {
            addEdge(edge);
        }
    }

    private void addEdge(PrimAlgorithm.Edge edge) {
        root = insert(root, edge);
    }

    private TreeNode insert(TreeNode root, PrimAlgorithm.Edge edge) {
        if (root == null) {
            TreeNode newNode = new TreeNode(edge.from);
            newNode.children.add(new TreeNode(edge.to));
            return newNode;
        }

        TreeNode parentNode = findNode(root, edge.from);
        if (parentNode != null) {
            parentNode.children.add(new TreeNode(edge.to));
        }

        return root;
    }

    private TreeNode findNode(TreeNode root, int val) {
        if (root == null) return null;
        if (root.data == val) return root;

        for (TreeNode child : root.children) {
            TreeNode found = findNode(child, val);
            if (found != null) {
                return found;
            }
        }

        return null;
    }

    private int getEdgeWeight(int from, int to) {
        for (PrimAlgorithm.Edge edge : edges) {
            if (edge.from == from && edge.to == to) {
                return edge.weight;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        List<PrimAlgorithm.Edge> edges = List.of(
                new PrimAlgorithm.Edge(1, 2, 5),
                new PrimAlgorithm.Edge(1, 3, 8),
                new PrimAlgorithm.Edge(3, 4, 12),
                new PrimAlgorithm.Edge(3, 5, 16)
        );

        SwingUtilities.invokeLater(() -> new MultiTree(edges).setVisible(true));
    }
}


