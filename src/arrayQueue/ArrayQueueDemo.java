package arrayQueue;

import java.util.Scanner;

public class ArrayQueueDemo {
    public static void main(String[] args) {
        //测试代码
        //创建一个队列
        ArrayQueue queue = new ArrayQueue(3);
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
                    int n = scanner.nextInt();
                    queue.addQQueue(n);
                    break;
                case 'g':
                    try{
                    int x = queue.getQueue();
                    System.out.printf("取出的数据是%d\n",x);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try{
                        System.out.println(queue.headqueue());
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':scanner.close();loop=false;break;
                default:
                    break;
            }
        }
        System.out.println("退出队列");
    }
}

class ArrayQueue {
    private int front;
    private int rear;
    private int arr[];
    private int maxSize;

    public ArrayQueue(int arrMaxsize) {
        maxSize = arrMaxsize;
        front = -1;//这里的队列是front指向数组头的前一个
        rear = -1;//而rear是指向数组尾部
        arr = new int[maxSize];
    }

    public boolean isFull() {
        return rear == maxSize - 1;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public void addQQueue(int n) {
        if (isFull()) {
            System.out.println("队列已满，无法加入队列");
            return;
        }
        rear++;
        arr[rear] = n;
    }

    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列空，不能取数据");
        }
        front++;
        return arr[front];
    }

    public void showQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列空，没有数据");
        }
        for (int i = 0; i < arr.length; i++)
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
    }

    public int headqueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列空,头部没有");
        }
        return arr[front + 1];
    }
}

/*
  思考，这样用数组模拟队列有一个问题，那就是数组只能用一次，当rear=font=maxSize-1后，
  虽然数组为空，但是不能再添加数据了。也就是存在a[0],a[1]……等的浪费。没有达到复用的效果。
 */
/*
  解决办法:用算法让数组模拟环形队列。
 */