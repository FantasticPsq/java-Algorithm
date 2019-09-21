package sortAgorithm;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import static sortAgorithm.HeapSort.heapSort;
import static sortAgorithm.quickSort.QuickSort;
import static sortAgorithm.radixSort.RadixSort2;
import static sortAgorithm.shellSort.ShellSort2;
import static sortAgorithm.threeQuickSort.Quick_3_Ways;

public class test {
    public static void main(String[] args) {
//        int[] arr = {-4, 4, 2, 8, -1, -6};
        int[] arr=new int[80000000];
        for(int i=0;i<80000000;i++){
            arr[i]=(int)(Math.random()*800000000);
        }
        Date date1=new Date();
        SimpleDateFormat simpleDateFormat1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String strdate1=simpleDateFormat1.format(date1);
        System.out.println("选择排序前的时间是："+strdate1);
//        Quick_3_Ways(arr, 0, arr.length - 1);
//        RadixSort2(arr);
        //QuickSort(arr,0,arr.length-1);
        heapSort(arr);
        Date date2=new Date();
        SimpleDateFormat simpleDateFormat2=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String strdate2=simpleDateFormat2.format(date2);
        System.out.println("选择排序后的时间是："+strdate2);
        //System.out.println(Arrays.toString(arr));
    }
}
