package Search;

import java.util.Arrays;

public class fibonacciSearch {
    static int maxSize = 20;

    public static int[] fibonacci() {
        int[] f = new int[maxSize];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < maxSize; i++) {
            f[i] = f[i - 1] + f[i - 1];
        }
        return f;
    }

    public static int FibonacciSearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        int mid = 0;
        int k = 0;
        int[] f = fibonacci();
        while(high>f[k]-1){
            k++;
        }
        int[] temp= Arrays.copyOf(arr,f[k]);
        for(int i=high+1;i<temp.length;i++){
            temp[i]=arr[high];
        }
        while(low<=high){
            mid=low+f[k-1]-1;//斐波那契的黄金分割点
            if(key>arr[mid]){
                low=mid+1;
                k-=2;//由f[k]-1=f[k-1]-1+f[k-2]-1+1;后半部分为f[k-2]-1(左后一个+1被删除是由于mid不在其中
            }
            else if(key<arr[mid]){
                high=mid-1;
                k-=1;//同上，前半部分是f[k-1]-1;
            }
            else {
                if(mid<high){//检查是否是后面扩充时重复的，不是则返回Mid，否则返回high
                    return mid;
                }
                else return high;
            }
        }
        return -1;
    }
}
