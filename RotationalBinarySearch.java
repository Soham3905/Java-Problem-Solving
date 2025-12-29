public class RotationalBinarySearch {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int target = 4;
        System.out.println(search(nums, target));
    }
    static int search(int[] nums, int target) {
        int piv = pivot(nums);
        if(piv == -1){
            return binarySearch(nums, target, 0, nums.length-1);
        }
       if(nums[piv] == target){
        return piv;
       }
       if(target>=nums[0]){
        return binarySearch(nums, target, 0, piv-1);
       }
       return binarySearch(nums, target, piv+1, nums.length);
    }
    static int pivot(int[] nums){
        int start = 0;
        int end = nums.length-1;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(mid < end && nums[mid]>nums[mid+1]){
                return mid;
            }
            if(mid > start && nums[mid]<nums[mid-1]){
                return mid-1;
            }
            if(nums[mid]<=nums[start]){
                end = mid-1;
            }else{
                start = mid +1;
            }
        }
        return -1;
    }
    static int binarySearch(int[] nums,int target,int start,int end){  
       while(start<=end){
         int mid = start + (end-start)/2;
         if(target < nums[mid]){
             end = mid -1;
         }else if(target > nums[mid]){
             start = mid + 1;
         }else {
             return mid;
         }
        }
        return -1;
     }
}
