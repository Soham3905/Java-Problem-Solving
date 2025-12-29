
import java.util.ArrayList;

public class DiceRolls {

    public static void main(String[] args) {
        dice("", 4);
        System.out.println(dice1("", 4));
        dicefface("", 7, 8);
        System.out.println(diceface1("", 7, 8));
    }

    static void dice(String p, int target) {
        if (target == 0) {
            System.out.println(p);
            return;
        }
        for (int i = 1; i <= 6 && i <= target; i++) {
            dice(p + i, target - i);
        }
    }

    static ArrayList<String> dice1(String p, int target) {
        if (target == 0) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> ans = new ArrayList<>();
        for (int i = 1; i <= 6 && i <= target; i++) {
            ans.addAll(dice1(p + i, target - i));
        }
        return ans;
    }

    static void dicefface(String p, int target, int face) {
        if (target == 0) {
            System.out.println(p);
            return;
        }
        for (int i = 1; i <= face && i <= target; i++) {
            dicefface(p + i, target - i, face);
        }
    }

    static ArrayList<String> diceface1(String p, int target, int face) {
        if (target == 0) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> ans = new ArrayList<>();
        for (int i = 1; i <= face && i <= target; i++) {
            ans.addAll(diceface1(p + i, target - i, face));
        }
        return ans;
    }
}
