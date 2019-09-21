package sortAgorithm;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class selectSort {
    public static void SelectSort(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            int index=i;
            int min=arr[index];
            for(int j=i+1;j<arr.length;j++){
                if(min>arr[j]){
                    min=arr[j];
                    index=j;
                }
            }
            if(index!=i)
            arr[index]=arr[i];
            arr[i]=min;//此句不可少，因为前面虽然有min=arr[index]和min=arr[j]；但是并不能说明arr[index]=arr[j];
        }
    }
}
