public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = {23, 45, 1, 2, 8, 19, -3, 16, -11, 28};
        System.out.println(linearsearch(arr, 19));
        System.out.println(searchinrange(arr, 19, 2, 8));
    }
    static int linearsearch(int[] arr, int target){
        if(arr.length == 0){
            return -1;
        }
        for(int i = 1; i < arr.length ; i++){
            if(target == arr[i]){
               return i;
            }
        }
         return -1;
    }   
    static int searchinrange(int[] arr,int target,int start,int end){
        if(arr.length == 0){
            return -1;
        }
        for(int i = start ; i <= end ; i++){
            if(target == arr[i]){
                return i;
            }
        }
        return -1;
    }
}
