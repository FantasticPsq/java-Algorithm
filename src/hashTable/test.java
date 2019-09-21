package hashTable;

import java.util.Hashtable;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable(7);
        String key = "";
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("add:添加雇员");
            System.out.println("list:列举雇员");
            System.out.println("exit:退出程序");
            System.out.println("find:查找雇员");
            key = scanner.next();
            switch (key) {
                case "add":
                    System.out.println("请输入id");
                    int n = scanner.nextInt();
                    System.out.println("请输入名字");
                    String name = scanner.next();
                    Emp emp = new Emp(name, n);
                    hashTable.add(emp);
                    break;
                case "list":
                    hashTable.show();
                    break;
                case "exit":
                    System.out.println("退出程序~~");
                    scanner.close();
                    System.exit(0);
                case "find":
                    System.out.println("please input the id");
                    n = scanner.nextInt();
                    hashTable.find(n);
                    break;
                default:
                    break;
            }
        }
    }
}
