package sortAgorithm;
/*
    思路：依次将一组数据的每个数的个位，十位，百位等取出，放在当前位的值对应
    的桶里，如如果一组数的个位数分别是1,2,3,1,5等，就把第一个数放在第二个桶中，第二数放在第三个
    桶中，同理第四个数放在第二个桶中，然后在按照顺序依次取出，十位，百位一样。
 */

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class radixSort {
    public static void RadixSort(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max)
                max = arr[i];
        }
        int maxDigitalSize = 0; //= (max + "").length();
        while (max != 0) {
            max = max / 10;

        }
        //一下两处是经典的用时间换空间
        int[][] bucket = new int[10][arr.length];//列设置为arr.length是防止溢出
        //此处用BucketElementCounts来计算第k个桶中的元素个数BucketElementCounts[k]
        int[] BucketElementCounts = new int[10];
        for (int i = 0; i < 10; i++) {
            BucketElementCounts[i] = 0;
        }
        for (int i = 0, n = 1; i < maxDigitalSize; i++, n *= 10) {
            //把数据放入桶中
            for (int j = 0; j < arr.length; j++) {
                int digitalOfElement = arr[j] / n % 10;//取出个/十/百...位数
                //bucket[digitalOfElement][BucketElementCounts[digitalOfElement]]表示把当前位数的值放在对应桶中
                bucket[digitalOfElement][BucketElementCounts[digitalOfElement]] = arr[j];//存放在bucket中
                BucketElementCounts[digitalOfElement]++;
            }
            //把数据依次拿出放入arr中
            int index = 0;
            for (int k = 0; k < BucketElementCounts.length; k++) {
                if (BucketElementCounts[k] != 0) {
                    for (int l = 0; l < BucketElementCounts[k]; l++) {
                        arr[index++] = bucket[k][l];
                    }
                }
                BucketElementCounts[k] = 0;
            }
        }
    }

    public static void RadixSort2(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        int maxLength = (max + "").length();
        int[][] bucket = new int[10][arr.length];
        int[] bucketElementCounts = new int[10];

        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            for (int j = 0; j < arr.length; j++) {
                int digitOfElement = (Math.abs(arr[j]) / n) % 10;
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
                bucketElementCounts[digitOfElement]++;

            }
            int index = 0;
            for (int k = 0; k < bucketElementCounts.length; k++) {
                if (bucketElementCounts[k] != 0) {
                    for (int l = 0; l < bucketElementCounts[k]; l++) {
                        arr[index++] = bucket[k][l];
                    }
                }
                bucketElementCounts[k] = 0;

            }


        }
    }
}
