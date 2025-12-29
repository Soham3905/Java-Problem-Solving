public class MinelementinArray {
    public static void main(String[] args) {
        int[] arr = {18, 12, 7, 8, 14, 28};
        System.out.println(minelement(arr));
    }
    static int minelement(int arr[]){
        int min = arr[0];
        for(int i=1 ; i < arr.length ; i++){
          if(arr[i]<min){
            min = arr[i];
        }
        }
        return min;
    }
}
