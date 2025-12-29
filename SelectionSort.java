import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};
        selectionsort(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void selectionsort(int[] arr){
    for(int i = 0; i < arr.length-1 ; i++){
        int last = arr.length - i -1;
        int maxindex = getMaxIndex(arr,0,last);
        swap(arr,maxindex,last);
    }
    }
    static int getMaxIndex(int[] arr,int first , int end){
        int max = first;
        for(int i = first ; i <= end ; i++){
            if(arr[i]>arr[max]){
                max=i;
            }
        }
        return max;
    }
    static void swap(int[] arr,int first,int second){
        int temp = arr[first];
        arr[first]=arr[second];
        arr[second]=temp;
    }
}