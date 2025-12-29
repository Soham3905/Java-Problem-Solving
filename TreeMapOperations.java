
import java.util.TreeMap;

public class TreeMapOperations {

    public static void main(String[] args) {
        TreeMap<String, Integer> map = new TreeMap<>();
        map.put("Soham", 44);
        map.put("Tejas", 55);
        map.put("Rupesh", 22);
        map.put("Rishab", 16);
        System.out.println(map);
        System.out.println(map.containsKey("Soham"));
        System.out.println(map.containsValue(55));
        map.put("Soham", 98);
        System.out.println(map);
        map.put("Rishab", 98);
        System.out.println(map);
        System.out.println(map.size());
        map.remove("Rishab");
        System.out.println(map + " " + map.size());

        map.remove("Ritesh");
        System.out.println(map + " " + map.size());

        System.out.println(map.get("Soham"));
        for (String key : map.keySet()) {
            int value = map.get(key);
            System.out.print(key + " " + value + " ");
        }

        System.out.println();
        map.put("Shivansh", 98);
        for (int val : map.values()) {
            System.out.print(val + " ");
        }
        System.out.println();

        for (Object pair : map.entrySet()) {
            System.out.println(pair);
        }

    }
}
