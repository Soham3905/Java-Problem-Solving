import java.util.ArrayList;

public class SubsetsString {

    public static void main(String[] args) {
        subsets("", "abc");
        subsets1("", "abc");
        System.out.println(list);
        ArrayList<String> list2 = new ArrayList<>();
        subsets2("", "abc", list2);
        System.out.println(list2);
        System.out.println(subsets3("", "abc"));
        subsetsAscii("", "abc");
        System.out.println(subsetsAscii1("", "abc"));
    }

    static void subsets(String p, String up) {
        if (up.isEmpty()) {
            System.out.print(p + " ");
            return;
        }
        char ch = up.charAt(0);
        subsets(p + ch, up.substring(1));
        subsets(p, up.substring(1));
    }
    static ArrayList<String> list = new ArrayList<>();

    static ArrayList<String> subsets1(String p, String up) {
        if (up.isEmpty()) {
            list.add(p);
            return list;
        }
        char ch = up.charAt(0);
        subsets1(p + ch, up.substring(1));
        subsets1(p, up.substring(1));
        return list;
    }

    static ArrayList<String> subsets2(String p, String up, ArrayList<String> list2) {
        if (up.isEmpty()) {
            list2.add(p);
            return list2;
        }
        char ch = up.charAt(0);
        subsets2(p + ch, up.substring(1), list2);
        subsets2(p, up.substring(1), list2);
        return list2;
    }

    static ArrayList<String> subsets3(String p, String up) {
        if (up.isEmpty()) {
            ArrayList<String> list3 = new ArrayList<>();
            list3.add(p);
            return list3;
        }
        char ch = up.charAt(0);
        ArrayList<String> left = subsets3(p + ch, up.substring(1));
        ArrayList<String> right = subsets3(p, up.substring(1));
        left.addAll(right);
        return left;
    }

    static void subsetsAscii(String p, String up) {
        if (up.isEmpty()) {
            System.out.print(p + " ");
            return;
        }
        char ch = up.charAt(0);
        subsetsAscii(p + ch, up.substring(1));
        subsetsAscii(p, up.substring(1));
        subsetsAscii(p + (ch + 0), up.substring(1));
    }

    static ArrayList<String> subsetsAscii1(String p, String up) {
        if (up.isEmpty()) {
            ArrayList<String> list4 = new ArrayList<>();
            list4.add(p);
            return list4;
        }
        char ch = up.charAt(0);
        ArrayList<String> first = subsetsAscii1(p + ch, up.substring(1));
        ArrayList<String> second = subsetsAscii1(p, up.substring(1));
        ArrayList<String> third = subsetsAscii1(p + (ch + 0), up.substring(1));
        first.addAll(second);
        first.addAll(third);
        return first;
    }

}
