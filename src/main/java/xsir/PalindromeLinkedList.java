package xsir;

import java.util.Stack;

public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> s = new Stack<>();
        ListNode cur = head;
        while (cur != null) {
            s.push(cur.val);
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            if (cur.val != s.pop()) {
                return false;
            }
            cur = cur.next;
        }
        return true;
    }
}
