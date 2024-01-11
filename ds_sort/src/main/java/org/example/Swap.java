package org.example;

public class Swap {
    public static void swap(int [] num,int l,int r){
        int t = num[l];
        num[l] = num[r];
        num[r] = t;
    }
}
