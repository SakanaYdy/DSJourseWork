package org.example;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class NIO {

    public static void write(int[][] g,int n){
        // 将各个位置之间的距离信息写入文件
        try(PrintWriter pw = new PrintWriter("location.txt")){
            pw.println(n);
            for(int i = 0;i<n;i++){
                for(int j = 0;j<n;j++){
                    pw.print(i + " ");
                    pw.print(j + " ");
                    pw.println(g[i][j]);
                }
            }
            System.out.println("文件写入成功");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void read(int[][] g){
        try(Scanner sc = new Scanner(new File("location.txt"))){
            String t = sc.nextLine();
            System.out.println(t);
            int n;
            String[] s1 = t.split(" ");
            n = Integer.parseInt(s1[0]);
            g = new int[n][n];
            for(int i = 0;i<n;i++){
                for(int j = i;j<n;j++){
                    t = sc.nextLine();
                    String[] s = t.split(" ");
                    System.out.println(s[0] + " " + s[1] + " " + s[2]);
                    g[i][j] = Integer.parseInt(s[2]);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
