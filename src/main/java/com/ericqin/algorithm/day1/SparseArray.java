package com.ericqin.algorithm.day1;


import java.io.*;

public class SparseArray {
    public static void main(String[] args) throws IOException {
        // 1. 定义10*10的数组
        int normalArray[][] = new int[10][10];

        //2.定义 5*8：40   4*6：24   3*5：15  8*4：32 有值
        normalArray[4][7] = 7;
        normalArray[3][5] = 5;
        normalArray[2][4] = 4;
        normalArray[7][3] = 3;

        //3. 输出初始化二维数组
        System.out.println("初始二维数组是：");
        printArray(normalArray);

        // 4. 判断有几个不为0的数 并记录行数和列数
        int count = 0;
        for (int i = 0; i < normalArray.length; i++) {
            for (int j = 0; j < normalArray[0].length; j++) {
                if (normalArray[i][j] != 0) {
                    count++;
                }
            }
        }

        //5.定义稀疏数组
        int sparseArray[][] = new int[count + 1][3];
        int arrayNumber = 0;
        //6. 转化为稀疏数组
        //6.1 一共多少行(normalArray.length)  多少列(normalArray[0].length)  几个元素不为0 分别是什么？
        sparseArray[0][0] = normalArray.length;
        sparseArray[0][1] = normalArray[0].length;
        sparseArray[0][2] = count;
        for (int i = 0; i < normalArray.length; i++) {
            for (int j = 0; j < normalArray.length; j++) {
                if (normalArray[i][j] != 0) {
                    arrayNumber++;
                    sparseArray[arrayNumber][0] = i;
                    sparseArray[arrayNumber][1] = j;
                    sparseArray[arrayNumber][2] = normalArray[i][j];
                }
            }
        }
        //7.遍历稀疏数组
        System.out.println("-----------------");
        System.out.println("转化后稀疏数组是：");
        printArray(sparseArray);

        //8.放入文件中
        File file = new File("D:\\Project\\algorithm\\src\\main\\resources\\sparseArray.txt");
        Writer writer = new FileWriter(file);
        for (int i = 0; i < sparseArray.length; i++) {
            for (int j = 0; j < sparseArray[0].length; j++) {
                writer.write(sparseArray[i][j] + "  ");
            }
            writer.write("\r\n");
        }
        writer.close();

        //9.从文件中读取值
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String str =null;
        int row =0;
        int newSparseArray [][] = new int [count+1][3];
        while ((str = reader.readLine())!=null){
            String[] strArray = str.split("  ");
            for (int i=0;i<strArray.length;i++){
                newSparseArray[row][i] = Integer.parseInt(strArray[i]);
            }
            row++;
        }
        reader.close();
        //获取稀疏数组
        System.out.println("从文件中获取稀疏数组为：");
        printArray(newSparseArray);


        int newNormalArray[][] = new int[newSparseArray[0][0]][newSparseArray[0][1]];
        // 转为正常二维数组
        for (int i=1;i<newSparseArray.length;i++){
                newNormalArray[newSparseArray[i][0]][newSparseArray[i][1]] = newSparseArray[i][2];
        }

        System.out.println("正常二维数组是：");
        printArray(newNormalArray);
    }

    private static void printArray(int array[][]) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.print(array[i][j] + "  ");
            }
            System.out.println();
        }
    }
}
