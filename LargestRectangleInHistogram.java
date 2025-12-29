
// public class LargestRectangleInHistogram {
//     public static void main(String[] args) {
//         int[] arr = {2,1,5,6,2,3};
//         System.out.println(histogram(arr));

//     }
//     static int histogram(int[] arr){
//         if (arr.length == 0) {
//             return 0;
//         }
//         for (int i = 0; i < arr.length; i++) {
//             int max = 0;
//             while (i != 0) { 
//                 int cs = arr[i];
//                 for (int j = i; arr[j-1]>arr[i] && j >= 0; j--) {
//                     cs = cs + arr[j];
//                 }
//             }
//         }
//     }
// }
