
import java.util.*;

public class Practice {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();

    }

    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        Arrays.sort(hBars);
        Arrays.sort(vBars);

        int ans = Math.min(helper(hBars), helper(vBars));
        return ans*ans;
    }

    public int helper(int[] bars){
        int result = 1;
        int count = 1;
        for (int i = 1; i < bars.length; i++) {
            if (bars[i]==bars[i-1]+1) {
                count++;
            }else{
                count = 1;
            }
            result = Math.max(result, count);
        }
        return result+1;
    }

}
