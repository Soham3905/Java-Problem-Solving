
import java.util.ArrayList;

public class PhonePad {

    public static void main(String[] args) {
        pad("", "12");
        System.out.println(pad1("", "12"));
        ArrayList<String> list2 = new ArrayList<>();
        System.out.println(pad2("", "12", list2));
        System.out.println(pad3("", "12"));
        System.out.println(pad4("", "12"));
        System.out.println(pad5("", "12"));
    }

    static void pad(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }
        int digit = up.charAt(0) - '0';  // this will convert '2' into 2
        for (int i = (digit - 1) * 3; i < (digit * 3); i++) {
            char ch = (char) ('a' + i);
            pad(p + ch, up.substring(1));
        }
    }

    static ArrayList<String> list = new ArrayList<>();

    static ArrayList<String> pad1(String p, String up) {
        if (up.isEmpty()) {
            list.add(p);
            return list;
        }
        int digit = up.charAt(0) - '0';  // this will convert '2' into 2
        for (int i = (digit - 1) * 3; i < (digit * 3); i++) {
            char ch = (char) ('a' + i);
            pad1(p + ch, up.substring(1));
        }
        return list;
    }

    static ArrayList<String> pad2(String p, String up, ArrayList<String> list2) {
        if (up.isEmpty()) {
            list2.add(p);
            return list2;
        }
        int digit = up.charAt(0) - '0';  // this will convert '2' into 2
        for (int i = (digit - 1) * 3; i < (digit * 3); i++) {
            char ch = (char) ('a' + i);
            pad2(p + ch, up.substring(1), list2);
        }
        return list2;
    }

    static ArrayList<String> pad3(String p, String up) {
        if (up.isEmpty()) {
            ArrayList<String> list3 = new ArrayList<>();
            list3.add(p);
            return list3;
        }
        int digit = up.charAt(0) - '0';
        ArrayList<String> ans = new ArrayList<>();
        for (int i = (digit - 1) * 3; i < digit * 3; i++) {
            char ch = (char) (i + 'a');
            ans.addAll(pad3(p + ch, up.substring(1)));
        }
        return ans;
    }

    static int count = 0;

    static int pad4(String p, String up) {
        if (up.isEmpty()) {
            count++;
            return count;
        }
        int digit = up.charAt(0) - '0';  // this will convert '2' into 2
        for (int i = (digit - 1) * 3; i < (digit * 3); i++) {
            char ch = (char) ('a' + i);
            pad4(p + ch, up.substring(1));
        }
        return count;
    }

    static int pad5(String p, String up) {
        if (up.isEmpty()) {
            return 1;
        }
        int cnt = 0;
        int digit = up.charAt(0) - '0';  // this will convert '2' into 2
        for (int i = (digit - 1) * 3; i < (digit * 3); i++) {
            char ch = (char) ('a' + i);
            cnt = cnt + pad5(p + ch, up.substring(1));
        }
        return cnt;
    }

}
