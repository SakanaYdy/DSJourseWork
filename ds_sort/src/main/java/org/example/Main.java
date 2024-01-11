package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;

public class Main extends JFrame {
    private JButton generateButton;
    private JButton startBubbleSortButton;
    private JButton startShellSortButton;
    private JButton startQuickSortButton;
    private JButton startMergeSortButton;
    private JButton showMergeSortResultButton;
    private JTextArea resultTextArea;

    private int[] data;  // 保存生成的数据

    Sort sort;

    public Main() {
        // 设置窗口标题
        super("操作页面");

        // 设置布局为边界布局
        setLayout(new BorderLayout());

        // 创建生成数据按钮
        generateButton = new JButton("生成数据");
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generateData();
            }
        });

        // 创建冒泡排序按钮
        startBubbleSortButton = new JButton("堆排序");
        startBubbleSortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NIO.read(data,"generated_data.txt");
                long start = System.currentTimeMillis();
                sort = new HeapSort();
                sort.MySort(data);
                long end = System.currentTimeMillis();
                resultTextArea.append("\n堆排序消耗时间:" + (end - start)+ "ms");
                NIO.write(data,"HeapSort");
            }
        });


        // 创建希尔排序按钮
        startShellSortButton = new JButton("希尔排序");
        startShellSortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NIO.read(data,"generated_data.txt");
                long start = System.currentTimeMillis();
                sort = new ShellSort();
                sort.MySort(data);
                long end = System.currentTimeMillis();
                resultTextArea.append("\n希尔排序消耗时间:" + (end - start) + "ms");
                NIO.write(data,"ShellSort");
            }
        });


        // 创建快速排序按钮
        startQuickSortButton = new JButton("快速排序");
        startQuickSortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NIO.read(data,"generated_data.txt");
                long start = System.currentTimeMillis();
                sort = new QuickSort();
                sort.MySort(data);
                long end = System.currentTimeMillis();
                resultTextArea.append("\n快速排序消耗时间:" + (end - start) + "ms");
                NIO.write(data,"QuickSort");
            }
        });


        // 创建归并排序按钮
        startMergeSortButton = new JButton("归并排序");
        startMergeSortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NIO.read(data,"generated_data.txt");
                long start = System.currentTimeMillis();
                sort = new MergeSort();
                sort.MySort(data);
                long end = System.currentTimeMillis();
                resultTextArea.append("\n归并排序消耗时间:" + (end - start)+ "ms");
                NIO.write(data,"MergeSort");
            }
        });
        showMergeSortResultButton = new JButton("排序结果");
        showMergeSortResultButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showData();
            }
        });

        // 创建文本区域用于显示结果
        resultTextArea = new JTextArea();
        resultTextArea.setEditable(false);

        // 创建面板用于放置生成数据按钮和按钮面板
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(generateButton, BorderLayout.NORTH);

        // 创建按钮面板
        JPanel buttonPanel = new JPanel(new GridLayout(8, 1));
        buttonPanel.add(startBubbleSortButton);
        buttonPanel.add(startShellSortButton);
        buttonPanel.add(startQuickSortButton);
        buttonPanel.add(startMergeSortButton);
        buttonPanel.add(showMergeSortResultButton);

        // 添加按钮和文本区域到窗口
        add(topPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.WEST);
        add(new JScrollPane(resultTextArea), BorderLayout.CENTER);

        // 设置窗口大小和关闭操作
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    // 数据生成
    private void generateData() {
        // 生成随机数据并显示在文本区域中
        Random random = new Random();
        data = new int[10000];
        for (int i = 0; i < data.length; i++) {
            data[i] = random.nextInt(100000);
        }
        resultTextArea.setText("生成的数据: " + Arrays.toString(data));

        NIO.write(data,"generated_data.txt");
    }

    // 结果显示
    public void showData(){
        resultTextArea.append("\n排序后结果" + Arrays.toString(data));
    }
    // main
    public static void main(String[] args) {
        // 创建操作页面窗口并显示
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

}
