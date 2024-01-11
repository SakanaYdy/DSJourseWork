package org.example;

public class ShellSort implements Sort {
    @Override
    public void MySort(int[] num) {
        int n = num.length;
        for(int d = n / 2;d>= 1; d/= 2){
            for(int i = d;i<n;i ++){
                int tmp = num[i];
                int j;
                for(j = i -d;j >=0 && tmp < num[j]; j -=d) num[j + d] = num[j];
                num[j + d] = tmp;
            }
        }
    }
}
