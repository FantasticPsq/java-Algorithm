package sortAgorithm;

import java.text.SimpleDateFormat;
import java.util.Date;

public class bubbleSort {//8000个数时间大概为14秒
    static boolean flag = false;

    public static void main(String[] args) {
        //int[] arr = {-1, 8, 3, 5, -2};
        //System.out.println(Arrays.toString(arr));
        //时间测试
        int[] arr=new int[80000];
        for(int i=0;i<80000;i++){
            arr[i]=(int)(Math.random()*8000000);
        }
        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String data1Str=simpleDateFormat1.format(date1);
        System.out.println("这是冒泡排序前的时间:"+data1Str);
        BubbleSort(arr);
        Date date2 = new Date();
        SimpleDateFormat simpleDateFormat2=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String data2Str=simpleDateFormat2.format(date2);
        System.out.println("这是冒泡排序后的时间:"+data2Str);
    }

    public static void BubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    arr[j] = arr[j] ^ arr[j + 1];
                    arr[j + 1] = arr[j] ^ arr[j + 1];
                    arr[j] = arr[j] ^ arr[j + 1];
                }
            }
            if (!flag) {//此处是优化部分，当后面的已经是排好序的是就退出大循环了
                return;
            } else flag = false;
        }
    }
}