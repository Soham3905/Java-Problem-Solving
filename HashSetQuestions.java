
import java.util.HashSet;
public class HashSetQuestions {
    public static void main(String[] args) {
        int[] arr = {2,2,2,2,2,2};
        String[] words = {"cd","ac","dc","ca","zz"};
        System.out.println(leetcode2442(arr));
        System.out.println(leetcode2744(words));
    }

    static int leetcode2442(int[] arr) {
        int result = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int ele : arr){
            set.add(ele);
            while (ele != 0) { 
                int rem = ele%10;
                result = result*10 + rem;
                ele = ele/10;
            }
            set.add(result);
            result = 0;
        }
        return set.size();
    }
    static int leetcode2744(String[] words){
        HashSet<String> set = new HashSet<>();
        int count = 0;
        for(String str : words){
            String revstr = reverse(str);
            if (set.contains(revstr)) {
                count++;
                set.remove(revstr);
            }else{
                set.add(str);
            }
        }
        return count;
    }
    static String reverse(String str) {
       StringBuilder sb = new StringBuilder(str);
       return sb.reverse().toString();
    }
}
