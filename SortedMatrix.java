import java.util.Arrays;

public class SortedMatrix {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
      
        // 1st approach -------------->>>>
        // System.out.println(Arrays.toString(linearsearch(arr, 2)));
        // 2nd approach -------------->>>>>
        // int rowlength = arr.length;
        // int collength = arr[0].length;
        // int[] ans = binarysearch(arr, rowlength, collength);
        // System.out.println(Arrays.toString(ans));
        // System.out.println(binarySearch(ans, 2));

        // 3rd approach ------------->>>>>
         System.out.println(Arrays.toString(search(arr, 9)));
}
    //  static int[] linearsearch(int[][] arr , int target){
    //     if(arr.length == 0){
    //         return new int[]{-1,-1};
    //     }
    //     for(int row  = 0 ; row < arr.length ; row++){
    //         for(int col = 0; col < arr[row].length ; col++){
    //             if(arr[row][col]==target){
    //                 return new int[]{row,col};
    //             }
    //         }
    //     }
    //     return new int[]{-1,-1};
    //  }
    //  static int[] binarysearch(int[][] arr,int rowlength,int collength){
    //     int[] ans = new int[rowlength*collength];
    //     int i = 0;
    //     for(int row  = 0 ; row < arr.length ; row++){
    //         for(int col = 0; col < arr[row].length ; col++){
    //                 ans[i] = arr[row][col];
    //                 i++;
    //             }
    //         }
    //         return ans;
    //     }
    //     static int binarySearch(int[] arr,int target){
    //         int start = 0;
    //         int end = arr.length -1;     
    //        while(start<=end){
    //          int mid = start + (end-start)/2;
    //          if(target < arr[mid]){
    //              end = mid -1;
    //          }else if(target > arr[mid]){
    //              start = mid + 1;
    //          }else {
    //              return mid;
    //          }
    //         }
    //         return -1;
    //      }

          static int[] binarysearch(int[][] matrix, int row,int cStart , int cEnd , int target){
               while(cStart <= cEnd){
                  int mid = cStart + (cEnd - cStart)/2;
                  if(matrix[row][mid]==target){
                    return new int[]{row,mid};
                  }
                  if(matrix[row][mid]<target){
                    cStart = mid + 1;
                  }else{
                    cEnd = mid - 1;
                  }
               }
               return new int[]{-1,-1};
          }
          static int[] search(int[][] matrix, int target){
            int rows = matrix.length;
            int cols = matrix[0].length; // be cautious, matrix may be empty
            if(cols == 0){
                return new int[]{-1,-1};
            }
            if(rows == 1){
                return binarysearch(matrix, 0, 0, cols-1, target);
            }
            int rStart = 0;
            int rEnd = rows-1;
            int cMid = cols/2;

            // run the loop till 2 rows are remaining
            while(rStart < (rEnd-1)){
                int mid = rStart+(rEnd-rStart)/2;
                if(matrix[mid][cMid]==target){
                    return new int[]{mid,cMid};
                }
                if(matrix[mid][cMid]<target){
                    rStart = mid;
                }else{
                    rEnd = mid;
                }
            }
            // now we have two rows
        // check whether the target is in the col of 2 rows
             if(matrix[rStart][cMid]==target){
            return new int[]{rStart,cMid};
            }
            
            if(matrix[rStart+1][cMid]== target){
                return new int[]{rStart+1,cMid};
            }

            // search in 1st half
            if(target<=matrix[rStart][cMid-1]){
                return binarysearch(matrix, rStart, 0, cMid-1, target);
            }
            // search in 2nd half
            if(target>=matrix[rStart][cMid+1] && target <= matrix[rStart][cols-1]){
                return binarysearch(matrix, rStart, cMid+1, cols-1, target);
            }
            // search in 3rd half
            if(target<= matrix[rStart+1][cMid-1]){
                return binarysearch(matrix, rStart+1, 0, cMid-1, target);
            }else{
                return binarysearch(matrix, rStart+1, cMid+1, cols-1, target);
            }

          }
     }
