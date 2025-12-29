public class MaxSubarraySum {
    public static void main(String[] args) {
        int[] arr = {-2,-3,4,-1,-2,1,5,-3};
        maxsubarray(arr);
        kadanesalgo(arr);
    }
    static void maxsubarray(int[] arr){
        int maxsum = Integer.MIN_VALUE;
        int totalsubarrrays = 0;
        for(int i=0;i<arr.length;i++){
            for(int j=i;j<arr.length;j++){
                int currentsum = 0;
                for(int k=i;k<=j;k++){
                    System.out.print(arr[k]+" ");  
                    currentsum += arr[k];      
                }
                if(currentsum>maxsum){
                    maxsum = currentsum;
                }
                totalsubarrrays++;
                System.out.println();
            }
        }
        System.out.println(totalsubarrrays);
        System.out.println(maxsum);
    }
    static void kadanesalgo(int[] arr){
        int currentsum = 0;
        int maxsum = Integer.MIN_VALUE;
        for(int i = 0 ; i < arr.length ; i++){
             currentsum += arr[i];
             if(currentsum<0){
                currentsum=0;
             }
             maxsum = Math.max(currentsum, maxsum);
        }
        System.out.println(maxsum);
    }

}
