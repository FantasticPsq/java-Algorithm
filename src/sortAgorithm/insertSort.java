package sortAgorithm;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class insertSort {
    public static void InsertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int insertValue = arr[i];
            int index = i - 1;//index指向有序这一边的最后一个数的位置
            while (index >= 0 && insertValue < arr[index]) {
                arr[index + 1] = arr[index];
                index--;
            }
            if(index+1!=i)
                arr[index+1]=insertValue;
        }
    }
}
