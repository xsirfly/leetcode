package xsir;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

class ReverseKNode {

    public static class ListNode {

        int val;
        ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) {
            return head;
        }
        Deque<ListNode> stack = new ArrayDeque<>(k);
        ListNode cur = head, newListNode = null, result = null, nextSegStart = null;
        int num;
        while (cur != null) {
            num = k;
            while (num > 0 && cur != null) {
                stack.push(cur);
                cur = cur.next;
                num--;
            }
            if (num > 0) {
                if (nextSegStart == null) {
                    return head;
                }
                newListNode.next = nextSegStart;
                return result;
            }
            while (!stack.isEmpty()) {
                if (result == null) {
                    newListNode = stack.pop();
                    result = newListNode;
                } else {
                    newListNode.next = stack.pop();
                    newListNode = newListNode.next;
                    newListNode.next = null;
                }
            }
            nextSegStart = cur;

        }
        return result;
    }
}
