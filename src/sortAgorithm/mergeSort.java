package sortAgorithm;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class mergeSort {
    public static void MergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            MergeSort(arr, left, mid, temp);
            MergeSort(arr, mid + 1, right, temp);
            Merge(arr, left, mid, right, temp);
        }
    }

    public static void Merge(int[] arr, int left, int mid, int right, int[] temp) {
//        int mid = (left + right) / 2;
        int i = left;
        int j = mid + 1;//j不是mid,二十mid+1
        int t = 0;
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t] = arr[i];
                t++;
                i++;
            } else {
                temp[t] = arr[j];
                t++;
                j++;
            }
        }
        while (i <= mid) {
            temp[t] = arr[i];
            t++;
            i++;
        }
        while (j <= right) {//注意j<=right,=不可少
            temp[t] = arr[j];
            t++;
            j++;
        }
        int tempLeft = left;
        t = 0;
        while (tempLeft <= right) {
            arr[tempLeft] = temp[t];
            tempLeft++;
            t++;
        }
    }
}
