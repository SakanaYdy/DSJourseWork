package org.example;

import java.util.PriorityQueue;

public class HeapSort implements Sort {
    @Override
    public void MySort(int[] num) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int t:num) heap.add(t);
        int n = 0;
        while (!heap.isEmpty()) num[n ++] = heap.poll();
    }
}
