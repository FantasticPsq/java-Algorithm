package arrayStock;


import java.util.Scanner;

public class ArrayStockDemo {
    public static void main(String[] args) {
        ArrayStock arraystock = new ArrayStock(6);
        String key = "";
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("show:显示栈的情况");
            System.out.println("pop:取出一个数据");
            System.out.println("push:把数据压入栈中");
            System.out.println("exit:退出栈");
            key = scanner.next();
            switch (key) {
                case "show":
                    arraystock.showStock();
                    break;
                case "pop":
                    try {
                        System.out.println("弹出:" + arraystock.pop());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "push":
                    int value = scanner.nextInt();
                    arraystock.push(value);
                    break;
                case "exit":
                    scanner.close();
                    loop = false;
                    break;
            }
        }
        System.out.println("退出程序。。。");
    }
}

class ArrayStock {
    private int maxSize;
    private int[] stock;
    private int top = -1;

    public ArrayStock(int maxSize) {
        this.maxSize = maxSize;
        stock = new int[this.maxSize];
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(int number) {
        if (isFull()) {
            System.out.println("栈已满，无法压入");
            return;
        }
        top++;
        stock[top] = number;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈已空，无法弹出");
        }
        return stock[top--];
    }

    public void showStock() {
        if (isEmpty()) {
            System.out.println("栈为空");
        }
        for (int i = 0; i <= top; i++) {
            System.out.printf("stock[%d]=%d\n", i, stock[i]);
        }
    }

    /*使用数组栈实现中缀表达式的计算的思路是:
    1.需要一个index指针来遍历栈,并且需要一个数栈和一个符号栈。
    2.需要判断运算符的优先级的方法（此需程序员自定义）
    3.如果index指向的是一个数，需要判断它的下一个是否也为一个数;
    直到一个数的后面一个是运算符，用一个拼接字符串把第一个数到最后一个数（中间没有运算符）
    拼接起来。如果index指向的是一个运算符：
        3.0如果该运算符是第一个要入符号栈的运算符，那么直接入栈。当它不是第一个时：
            3.1如果该运算符的优先级小于或等于前一个运算符，那么需要pop出（弹出）两个数，并且把当前index指向的
            运算符的前一个运算符弹出（pop)，并且把弹出的两个数进行此运算符的运算，然后把运算结果入数栈，再把
            当前index指向的运算符入符号栈。
            3.2如果该运算符的优先级大于前一个运算符的优先级，那么直接入符号栈。
    4.最后出栈，按出栈顺序计算表达式的结果。
     */
    public int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-')
            return 0;
        else return -1;
    }

    //判断是否是运算符
    public boolean isOper(char oper) {
        return oper == '*' || oper == '/' || oper == '+' || oper == '-';
    }

    public double caculate(double num1, double num2, char oper) {
        switch (oper) {//注意-和/的顺序
            case '+':
                return num1 + num2;
            case '-':
                return num2-num1;
            case '*':
                return num1*num2;
            case '/':
                return num2/num1;
                default:System.out.println("运算符有误");return -1;
        }

    }

}
