/*
   用数组模拟环形队列，算法中流出一个空间用于连接，front指向
   队列头部，rear指向队列尾部的下一个位置，如果rear=maxSize-1,则其下一个
   位置为0,也就是预留rear的下一个位置用于连接。
*/
package arrayQueue;

import java.util.Scanner;

public class CircleArrayQueue {
    public static void main(String[] args) {
        CircleQueue queue = new CircleQueue(4);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("s(show):显示队列");
            System.out.println("a(add):添加数据到队列");
            System.out.println("g(get):获取队列");
            System.out.println("h(headOfQueue):显示队列头部");
            System.out.println("e(exit):退出");
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("请输入一个数");
                    int m = scanner.nextInt();
                    queue.addQQueue(m);
                    break;
                case 'g':
                    try {
                        System.out.printf("取出的数据是%d\n", queue.getQueue());
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try{
                        System.out.println(queue.headqueue());
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
        System.out.println("退出队列");
    }
}

class CircleQueue {
    private int front;
    private int rear;
    private int arr[];
    private int maxSize;

    public CircleQueue(int arrMaxsize) {
        maxSize = arrMaxsize;
        front = 0;//这里的队列是front指向数组头的前一个
        rear = 0;//而rear是指向数组尾部
        arr = new int[maxSize];
    }

    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public void addQQueue(int n) {
        if (isFull()) {
            System.out.println("队列已满，无法加入队列");
            return;
        }
        arr[rear] = n;
        rear=(rear+1)%maxSize;//防止越界
    }

    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列空，不能取数据");
        }
        int value=front;
        front = (front+1)%maxSize;//防止越界.
        return arr[value];
    }

    public void showQueue() {
        if (isEmpty()) {
            System.out.println("对列空,没有数据s");
        }
        for (int i = front; i < front + (rear - front + maxSize) % maxSize; i++)//之所以rear-front后面要加上maxSize,是有时rear<front
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
    }

    public int headqueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列空,头部没有");
        }
        int value=front;
        return arr[value];
    }
}