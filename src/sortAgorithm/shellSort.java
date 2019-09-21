package sortAgorithm;
/*
希尔排序是对InsertSort的优化，通过缩短步长来分组排序，最后统一
步长=arr.length/(2^n),n=1,2,,,,
 */

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class shellSort {

    public static void ShellSort(int[] arr) {
        int temp;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {//arr.length-gap为计算的总次数
                for (int j = i-gap ; j>=0; j -= gap) {//此处j一定是要j>=0,否则最后一轮会少交换一次
                        if(arr[j]>arr[j+gap]){
                            temp=arr[j];
                            arr[j]=arr[j+gap];
                            arr[j+gap]=temp;
                        }
                }
            }
        }
    }
    public static void ShellSort2(int[] arr){
        for(int gap=arr.length;gap>0;gap/=2){
            for(int i=gap;i<arr.length;i++){
                int j=i;
                int temp=arr[j];
                while(j>=gap&&temp<arr[j-gap]){
                    arr[j]=arr[j-gap];
                    j-=gap;
                }
                arr[j]=temp;
            }
        }
    }
}
