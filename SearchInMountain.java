public class SearchInMountain {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,3,1};
        int target = 5;
        System.out.println(search(arr, target));
    }
     static int search(int arr[],int target){
        
        int peak = peakIndexInMountainArray(arr);
        int ans = orderAgnosticBS(arr, target, 0, peak);
        if(ans != -1){
          return  ans;
        }
       return orderAgnosticBS(arr, target, peak+1, arr.length-1);
     }
     static int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length -1;
        while(start<end){
            int mid = start + (end - start)/2;
            if(arr[mid]>arr[mid+1]){
                end = mid;
            }else{
                start = mid +1;
            }
        }
        return start;// or return end as both are =
    }
    static int orderAgnosticBS(int[] arr , int target,int start,int end){
        boolean check = arr[start] < arr[end];
        while(start <= end){
            int mid = start + (end-start)/2;
            if(arr[mid]==target){
                return mid;
            }
            if(check){
                if(target<arr[mid]){
                    end = mid -1;
                }else{
                    start = mid+1;
                }
            }else{
                if(target < arr[mid]){
                    start = mid+1;
                }else{
                    end = mid -1;
                }
            }
        }
        return -1;
    }
}
