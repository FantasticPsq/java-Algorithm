package Search;

public class insertValueSearch {
    public static int InsertValueSearch(int[] arr,int left,int right,int FindValue){
        if(left>right)
            return -1;
        int mid=left+(right-left)*(FindValue-arr[left])/(arr[right]-arr[left]);
        if(FindValue>arr[mid])
            return InsertValueSearch(arr,left,mid-1,FindValue);
        else if(FindValue<arr[mid]){
            return InsertValueSearch(arr,mid+1,right,FindValue);
        }
        else {
            return mid;
        }
    }
}
