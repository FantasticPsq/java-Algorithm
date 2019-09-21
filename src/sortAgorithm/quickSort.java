package sortAgorithm;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class quickSort {
    public static void QuickSort(int[] arr, int left, int right) {
        if (left > right) return;
        int index = arr[left];
        int i = left;
        int j = right;
        while (i != j) {
            while (index <= arr[j]&&i<j)
                j--;
            while (index >= arr[i]&&i<j)
                i++;
            if(i<j){
                arr[i] = arr[i] ^ arr[j];
                arr[j] = arr[i] ^ arr[j];
                arr[i] = arr[i] ^ arr[j];
            }
        }
        arr[left]=arr[i];
        arr[i]=index;
        QuickSort(arr,left,i-1);
        QuickSort(arr,i+1,right);
    }
}

