package org.example;

import java.util.Arrays;

public class Test {

    public static void main(String[] args) {
        int[] arr = {9,4,5,3,1,6,2,7,8,0};
        // 冒泡排序
//        BubbleSort bubbleSort = new BubbleSort();
//        bubbleSort.MySort(arr);

        // 快速排序
//        QuickSort quickSort = new QuickSort();
//        quickSort.MySort(arr);

        // 堆排序
//        HeapSort heapSort = new HeapSort();
//        heapSort.MySort(arr);

        // 归并排序
//        MergeSort mergeSort = new MergeSort();
//        mergeSort.MySort(arr);

        // 希尔排序
        ShellSort shellSort = new ShellSort();
        shellSort.MySort(arr);
        System.out.println(Arrays.toString(Arrays.stream(arr).toArray()));
    }

}
