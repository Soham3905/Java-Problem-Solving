import java.util.Arrays;

public class SetMismatch {
    public static void main(String[] args) {
        int[] nums = {1,1};
        System.out.println(Arrays.toString(missingNumber(nums)));
    }

    static int[] missingNumber(int[] nums){
         cyclicsort(nums);
         int i = 0;
        while(i<nums.length){
            if(nums[i]==i+1){
                i++;
            }else{
                return new int[]{nums[i],i+1};
            }
        }
        return new int[]{-1,-1};
    }
    static void cyclicsort(int[] arr){
        int i = 0;
        while(i<arr.length){
            int correct = arr[i]-1;
            if(arr[i] != arr[correct]){
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
