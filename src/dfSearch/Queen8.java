package dfSearch;

/*
这不是标准的dfs
*/

import javax.swing.*;

public class Queen8 {
    int maxSize = 8;
    int[] arr = new int[maxSize];
    static int count = 0;
    static int JudgeCount = 0;

    public static void main(String[] args) {
        Queen8 queen8=new Queen8();
        System.out.println("这些方法可以:");
        queen8.check(0);//从0处开始检查
        System.out.printf("方法总共有%d个",count);
        System.out.println("一共循环了 "+JudgeCount+"次");
    }
    public void check(int n){
        if(n==maxSize){
            print();
            return;
        }
        for(int i=0;i<maxSize;i++){
            arr[n]=i;
            if(Judge(n)) {
                check(n+1);
            }
        }
    }
    public void print(){
        count++;
        for(int i=0;i<maxSize;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    //检测是否冲突
    public boolean Judge(int n) {
        JudgeCount++;
        for (int i = 0; i < n; i++)
            if (arr[n] == arr[i] || Math.abs(n - i) == Math.abs(arr[n] - arr[i]))
                return false;
        return true;
    }
}
