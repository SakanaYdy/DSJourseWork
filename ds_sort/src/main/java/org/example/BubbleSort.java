package org.example;

public class BubbleSort implements Sort {
    @Override
    public void MySort(int[] num) {
        int n = num.length;
        for(int i = 0;i<n;i++){
            for(int j = i + 1;j < n;j++){
                if(num[i] > num[j]) Swap.swap(num,i,j);
            }
        }
    }

}
