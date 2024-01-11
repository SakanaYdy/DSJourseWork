package org.example;

import java.io.PrintWriter;
import java.util.Scanner;

public class NIO {
    /**
     * 向数据文件中写入数据
     * @param data
     * @param fileName
     */
    public static void write(int[] data,String fileName){
        // 写入文件
        try (PrintWriter writer = new PrintWriter(fileName)) {
            for (int value : data) {
                writer.println(value);
            }
            System.out.println("数据已写入文件");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 读取数据文件
     */
    public static void read(int[] data,String fileName){
        int i = 0;
        try(Scanner sc= new Scanner(fileName)){
            while (sc.hasNextInt()) {
                int t = sc.nextInt();
                data[i++] = t;
            }
            System.out.println("数据读取完毕");
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
