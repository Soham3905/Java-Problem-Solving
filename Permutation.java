
import java.util.ArrayList;

public class Permutation {

    public static void main(String[] args) {
        permutations("", "abc");
        System.out.println(permutations1("", "abc"));
        ArrayList<String> list2 = new ArrayList<>();
        System.out.println(permutation2("", "abc", list2));
        System.out.println(permutations3("", "abc"));
        System.out.println(permutation4("", "abc"));
        System.out.println(permutation5("", "abc"));
    }

    static void permutations(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0, i);
            String s = p.substring(i, p.length());
            permutations(f + ch + s, up.substring(1));
        }
    }
    static ArrayList<String> list = new ArrayList<>();

    static ArrayList<String> permutations1(String p, String up) {
        if (up.isEmpty()) {
            list.add(p);
            return list;
        }
        char ch = up.charAt(0);
        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0, i);
            String s = p.substring(i, p.length());
            permutations1(f + ch + s, up.substring(1));
        }
        return list;
    }

    static ArrayList<String> permutation2(String p, String up, ArrayList<String> list2) {
        if (up.isEmpty()) {
            list2.add(p);
            return list2;
        }

        char ch = up.charAt(0);
        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0, i);
            String s = p.substring(i, p.length());
            permutation2(f + ch + s, up.substring(1), list2);
        }
        return list2;
    }

    static ArrayList<String> permutations3(String p, String up) {
        if (up.isEmpty()) {
            ArrayList<String> list3 = new ArrayList<>();
            list3.add(p);
            return list3;
        }
        char ch = up.charAt(0);
        ArrayList<String> ans = new ArrayList<>();
        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0, i);
            String s = p.substring(i, p.length());
            ans.addAll(permutations3(f + ch + s, up.substring(1)));
        }
        return ans;
    }
    static int count = 0;

    static int permutation4(String p, String up) {
        if (up.isEmpty()) {
            count++;
            return count;
        }
        char ch = up.charAt(0);
        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0, i);
            String s = p.substring(i, p.length());
            permutation4(f + ch + s, up.substring(1));
        }
        return count;
    }

    static int permutation5(String p, String up) {
        if (up.isEmpty()) {
            return 1;
        }
        char ch = up.charAt(0);
        int cnt = 0;
        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0, i);
            String s = p.substring(i, p.length());
            cnt = cnt + permutation5(f + ch + s, up.substring(1));
        }
        return cnt;
    }
}
