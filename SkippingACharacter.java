public class SkippingACharacter {

    public static void main(String[] args) {
        String str = "bcabbaacgywjewraa";
        char skip = 'a';
        skipCharacter(str, skip);
        skipCharacter1("", str);
        System.out.println(skipCharacter2(str));
        System.out.println(skipstring("bdapplefg"));
        System.out.println(skipstringAppNotApple("bdapplrte"));
    }

    static void skipCharacter(String str, char skip) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != skip) {
                builder.append(str.charAt(i));
            }
        }
        System.out.println(builder);
    }

    static void skipCharacter1(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        if (ch == 'a') {
            skipCharacter1(p, up.substring(1));
        } else {
            skipCharacter1(p + ch, up.substring(1));
        }
    }

    static String skipCharacter2(String str) {
        if (str.isEmpty()) {
            return "";
        }
        char ch = str.charAt(0);
        if (ch == 'a') {
            return "" + skipCharacter2(str.substring(1));
        } else {
            return ch + skipCharacter2(str.substring(1));
        }
    }

    static String skipstring(String str) {
        if (str.isEmpty()) {
            return "";
        }
        char ch = str.charAt(0);
        if (str.startsWith("apple")) {
            return "" + skipstring(str.substring(5));
        }else {
            return ch + skipstring(str.substring(1));
        }
    }

    static String skipstringAppNotApple(String str) {
        if (str.isEmpty()) {
            return "";
        }
        char ch = str.charAt(0);
        if (str.startsWith("apple")) {
            return "" + skipstringAppNotApple(str.substring(5));
        } else if (str.startsWith("app")) {
            return "" + skipstringAppNotApple(str.substring(3));
        } else {
            return ch + skipstringAppNotApple(str.substring(1));
        }
    }
}
