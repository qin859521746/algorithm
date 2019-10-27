package com.ericqin.algorithm.day2;

import java.util.Scanner;

public class ArrayMockQueue {
    public static void main(String[] args) {

        //1.需要模拟队列  是否满  是否空  添加数据  出队列  显示队列数据  显示队列的头数据
        ArrayQueue arrayQueue = new ArrayQueue(3);
        char key = ' ';
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);

        while (loop) {
            System.out.println("s: 显示队列");
            System.out.println("e:退出");
            System.out.println("a:添加");
            System.out.println("g:获取元素");
            System.out.println("h:获取头部元素");
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'a':
                    try{
                        System.out.println("输入一个数：");
                        int i = scanner.nextInt();
                        arrayQueue.add(i);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'g':
                    try {
                        int queue = arrayQueue.getQueue();
                        System.out.println(queue);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int headerElement = arrayQueue.getHeaderElement();
                        System.out.println(headerElement);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出");
    }
}

class ArrayQueue {
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        front = -1;
        rear = -1;
        arr = new int[maxSize];
    }

    //1.是否空
    public boolean isEmpty() {
        return rear == front;
    }

    //2.是否满
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    //3.添加元素
    public void add(int newNumber) {
        if (isFull()) {
            throw new RuntimeException("队列满");
        }
        rear++;
        arr[rear] = newNumber;
    }

    //4.获取元素
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列空");
        }
        front++;
        return arr[front];
    }

    //5.展示队列元素
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空");
            return;
        }
        System.out.println("队列元素为：");
        for (int i : arr) {
            System.out.print(i + "  ");
        }
        System.out.println();
    }

    //6.获取队列头元素
    public int getHeaderElement() {
        if (isEmpty()) {
            throw new RuntimeException("队列 为空");
        }
        return arr[front + 1];
    }

}
