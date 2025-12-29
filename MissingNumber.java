

public class MissingNumber {
    public static void main(String[] args) {
        int[] nums = {0,1};
        System.out.println(missingNumber(nums));
    }
    // static int missingNumber(int[] nums) {
    //     Arrays.sort(nums);
    //     int ans = 0;
    //     int i = 0;
    //     while(i<nums.length){
    //         if(nums[i] == ans){
    //             ans++;
    //             i++;
    //         }else{
    //             return ans;
    //         }
    //     }
    //     return nums.length;
    // }

    static int missingNumber(int[] nums){
         cyclicsort(nums);
         int i = 0;
        while(i<nums.length){
            if(nums[i]==i){
                i++;
            }else{
                return i;
            }
        }
        return nums.length;
    }
    static void cyclicsort(int[] arr){
        int i = 0;
        while(i<arr.length){
            int correct = arr[i];
            if( arr[i] < arr.length && arr[i] != arr[correct]){
                swap(arr,i,correct);
            }else{
                i++;
            }
        }
    }
    static void swap(int[] arr,int first,int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}