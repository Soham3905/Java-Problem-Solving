public class MaxelementinArray {
    public static void main(String[] args) {
        int[] arr = {2,3,6,45,78,9,5};
        System.out.println(maxelement(arr));
        System.out.println(maxinrange(arr, 0, 3));
    }
    static int maxelement(int[] arr){
        if(arr.length == 0){
            return -1;
        }
        int max = arr[0];
        for(int i = 1; i< arr.length ; i++){
          if(arr[i] > max){
            max = arr[i];
          }
        }
        return max;
    }
    static int maxinrange(int[] arr,int start,int end){
        if(arr.length == 0){
            return -1;
        }
        if( start > end){
            return -1;
        }
        int max = arr[start];
        for(int i = start + 1; i <= end ; i++){
            if(arr[i]>max){
                max = arr[i];
            }
        }
        return max;
    }
}
