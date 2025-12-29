
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class HashmapQuestions {

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram(s, t));
        int[] nums = {2, 7, 11, 1};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(nums, target)));
        int[] arr = {1, 2, 2, 1, 1, 3};
        System.out.println(uniqueOccurrences(arr));
        int[] arr1 = {2, 2, 2, 8};
        System.out.println(Arrays.toString(findEvenNumbers(arr1)));
        System.out.println(lengthOfLongestSubstring(s));
    }

    static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> smap = new HashMap<>();
        for (char key : s.toCharArray()) {
            smap.put(key, smap.getOrDefault(key, 0) + 1);
        }
        HashMap<Character, Integer> tmap = new HashMap<>();
        for (char key : t.toCharArray()) {
            tmap.put(key, tmap.getOrDefault(key, 0) + 1);
        }
        for (char key : s.toCharArray()) {
            if (!Objects.equals(smap.get(key), tmap.get(key))) {
                return false;
            }
        }
        return true;
    }

    static int[] twoSum(int[] nums, int target) {
        int[] ans = {-1, -1};
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int remaining = target - nums[i];
            if (map.containsKey(remaining)) {
                return new int[]{map.get(remaining), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return ans;
    }

    static boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int key : arr) {
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        HashSet<Integer> set = new HashSet<>();
        for (int key : map.values()) {
            set.add(key);
        }
        return set.size() == map.size();
    }

    static int[] findEvenNumbers(int[] digits) {
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int key : digits) {
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        for (int i = 100; i < 1000; i += 2) {
            int x = i;
            int c = x % 10;
            x = x / 10;
            int b = x % 10;
            x = x / 10;
            int a = x;
            if (map.containsKey(a)) {
                int afreq = map.get(a);
                map.put(a, afreq - 1);
                if (afreq == 1) {
                    map.remove(a);
                }
                if (map.containsKey(b)) {
                    int bfreq = map.get(b);
                    map.put(b, bfreq - 1);
                    if (bfreq == 1) {
                        map.remove(b);
                    }
                    if (map.containsKey(c)) {
                        list.add(i);
                    }
                    map.put(b, bfreq);
                }
                map.put(a, afreq);
            }
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    static int lengthOfLongestSubstring(String s) {
        // Two pointer approach , i and j sliding window from i to j
        if (s.length() <= 1) {
            return s.length();
        }
        int maxlen = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int i = 0, j = 0;
        while (j < s.length()) {
            char ch = s.charAt(j);
            if (map.containsKey(ch) && map.get(ch) >= i) {
                int len = j - i;
                maxlen = Math.max(len, maxlen);
                while (s.charAt(i) != ch) {
                    i++;
                }
                i++;
            }
            map.put(ch, j);
            j++;
        }
        int len = j - i;
        maxlen = Math.max(len, maxlen);
        return maxlen;
    }

    public boolean canArrange(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int key : arr) {
            int ele = key % k;
            if (ele < 0) {
                ele += k;
            }
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }
        if (map.containsKey(0)) {
            if (map.get(0) % 2 != 0) {
                return false;
            }
            map.remove(0);
        }
        if (k % 2 == 0 && map.containsKey(k / 2)) {
            if (map.get(k / 2) % 2 != 0) {
                return false;
            }
            map.remove(k / 2);
        }
        for (int key : map.keySet()) {
            int remaining = k - key;
            if (!map.containsKey(remaining)) {
                return false;
            }
            int keyfreq = map.get(key);
            int remainingfreq = map.get(remaining);
            if (keyfreq != remainingfreq) {
                return false;
            }
        }
        return true;
    }

    public void topview(TreeNode root) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        int minlevel = Integer.MAX_VALUE;
        int maxlevel = Integer.MIN_VALUE;
        while (!q.isEmpty()) {
            Pair temp = q.remove();
            TreeNode node = temp.node;
            int level = temp.level;
            minlevel = Math.min(level, minlevel);
            maxlevel = Math.max(maxlevel, level);
            if (!map.containsKey(level)) {
                map.put(level, node.val);
            }
            if (node.left != null) {
                q.add(new Pair(node.left, level - 1));
            }
            if (node.right != null) {
                q.add(new Pair(node.right, level + 1));
            }
        }
        for (int i = minlevel; i <= maxlevel; i++) {
            System.out.print(map.get(i) + " ");
        }
    }

    public void bottomview(TreeNode root) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        int minlevel = Integer.MAX_VALUE;
        int maxlevel = Integer.MIN_VALUE;
        while (!q.isEmpty()) {
            Pair temp = q.remove();
            TreeNode node = temp.node;
            int level = temp.level;
            minlevel = Math.min(level, minlevel);
            maxlevel = Math.max(maxlevel, level);
            map.put(level, node.val);
            if (node.left != null) {
                q.add(new Pair(node.left, level - 1));
            }
            if (node.right != null) {
                q.add(new Pair(node.right, level + 1));
            }
        }
        for (int i = minlevel; i <= maxlevel; i++) {
            System.out.print(map.get(i) + " ");
        }
    }

    public class Pair {

        TreeNode node;
        int level;

        Pair(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    public static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode next;

        // TreeNode() {
        // }
        // TreeNode(int val) {
        //     this.val = val;
        // }
        // TreeNode(int val, TreeNode left, TreeNode right) {
        //     this.val = val;
        //     this.left = left;
        //     this.right = right;
        // }
        public TreeNode getNext() {
            return next;
        }

        public void setNext(TreeNode next) {
            this.next = next;
        }
    }

    public int countNicePairs(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + reverse(nums[j]) == nums[j] + reverse(nums[i])) {
                    count++;
                }
            }
        }
        return count;
    }

    public int reverse(int num) {
        int result = 0;
        while (num != 0) {
            int rem = num % 10;
            result = (result * 10) + rem;
            num = num / 10;
        }
        return result;
    }

    public int countNicePairsOptimized(int[] nums) {
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int key : nums) {
            int ele = key - reverse(key);
            if (map.containsKey(ele)) {
                int freq = map.get(ele);
                count += freq;
                count %= 1000000007;
                map.put(ele, freq + 1);
            } else {
                map.put(ele, 1);
            }
        }
        return count;
    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node head2 = new Node(head.val);
        Node temp2 = head2;
        Node temp = head.next;
        while (temp != null) {
            Node duplicate = new Node(temp.val);
            temp2.next = duplicate;
            temp2 = duplicate;
            temp = temp.next;
        }
        HashMap<Node, Node> map = new HashMap<>();
        temp2 = head2;
        temp = head;
        while (temp != null) {
            map.put(temp, temp2);
            temp = temp.next;
            temp2 = temp2.next;
        }
        for (Node original : map.keySet()) {
            Node duplicate = map.get(original);
            if (original.random != null) {
                duplicate.random = map.get(original.random);
            }
        }
        return head2;
    }

    public class Node {

        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public int countPalindromicSubsequence(String s) {
        HashMap<Character, Integer> firstMap = new HashMap<>();
        HashMap<Character, Integer> lastMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!firstMap.containsKey(ch)) {
                firstMap.put(ch, i);
            }
            lastMap.put(ch, i);
        }
        int count = 0;
        for (char ch : firstMap.keySet()) {
            int firstindex = firstMap.get(ch);
            int lastindex = lastMap.get(ch);
            HashSet<Character> set = new HashSet<>();
            for (int i = firstindex + 1; i <= lastindex - 1; i++) {
                set.add(s.charAt(i));
            }
            count += set.size();
        }
        return count;
    }
}
