/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode prev = head;
        ListNode temp = head.next;
        ArrayList<Integer> list = new ArrayList<>();
        int i = 2;
        while (temp.next != null) {
            if (((prev.val > temp.val) && (temp.next.val > temp.val))
                    || ((prev.val < temp.val) && (temp.next.val < temp.val))) {
                list.add(i);
            }
            i++;
            prev = temp;
            temp = temp.next;
        }
        if (list.size() < 2) {
            return new int[] { -1, -1 };
        }
        int min = Integer.MAX_VALUE;
        for (int j = 1; j < list.size(); j++) {
            min = Math.min(min, list.get(j) - list.get(j - 1));
        }
        int max = list.get(list.size() - 1) - list.get(0);
        return new int[] { min, max };
    }
}