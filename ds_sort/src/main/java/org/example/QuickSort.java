package org.example;

public class QuickSort implements Sort {
    @Override
    public void MySort(int[] num) {
        quickSort(num,0 , num.length - 1);
    }

    public void quickSort(int[] q,int l,int r){
        if(l >= r) return;

        int i = l -1, j = r + 1,x = q[l + r >> 1];
        while(i < j){
            do i ++; while(q[i] < x);
            do j --; while(q[j] > x);
            if(i < j) Swap.swap(q,i,j);
        }
        quickSort(q,l,j); quickSort(q,j + 1,r);
    }

}
