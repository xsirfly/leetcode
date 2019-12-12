package xsir;

public class ReverseLinkedList {
    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = head, cur = pre.next, next = null;
        head.next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        System.out.println(reverseList(n1));
    }
}
