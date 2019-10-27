package com.ericqin.algorithm.day2;

import java.util.Scanner;

public class ArrayMockCircularQueue {
    public static void main(String[] args) {
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        ArrayCircularQueue arrayCircularQueue = new ArrayCircularQueue(4);
        while (loop) {
            System.out.println("s: 显示队列");
            System.out.println("e:退出");
            System.out.println("a:添加");
            System.out.println("g:获取元素");
            System.out.println("h:获取头部元素");
            key = scanner.next().charAt(0);

            switch (key) {
                case 's':
                    arrayCircularQueue.show();
                    break;
                case 'a':
                    System.out.println("输入一个数：");
                    int i = scanner.nextInt();
                    arrayCircularQueue.add(i);
                    break;
                case 'g':
                    try {
                        int i1 = arrayCircularQueue.get();
                        System.out.println(i1);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    int head = arrayCircularQueue.getHead();
                    System.out.println(head);
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
            }
        }

    }
}

class ArrayCircularQueue {
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public ArrayCircularQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }

    //1.是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    //2.是否满
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    //3.添加
    public void add(int newNumber) {
        if (isFull()) {
            System.out.println("队列满");
            return;
        }
        arr[rear] = newNumber;
        rear = (rear + 1) % maxSize;
    }

    //4.取数据
    public int get() {
        if (isEmpty()) {
            throw new RuntimeException("队列空");
        }
        int temp = arr[front];
        front = (front + 1) % maxSize;
        return temp;
    }

    //5.获取第一个元素
    public int getHead() {
        return arr[front];
    }

    //6.打印队列
    public void show() {
        if (isEmpty()) {
            System.out.println("队列为空");
            return;
        }
        for (int i = front; i < front + size(); i++) {
            System.out.print(arr[i % maxSize] + "  ");
        }
        System.out.println();
    }

    public int size() {
        return (rear + maxSize - front) % maxSize;   // +maxSize主要是可能存在负数取模
    }

}
