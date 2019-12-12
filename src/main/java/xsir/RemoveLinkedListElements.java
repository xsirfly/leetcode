package xsir;

public class RemoveLinkedListElements {
    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode pre = null, cur = head;
        while (cur != null) {
            if (cur.val == val) {
                if (pre == null) {
                    head = cur.next;
                    cur = cur.next;
                } else {
                    pre.next = cur.next;
                    cur = pre.next;
                }
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(6);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(4);
        ListNode n6 = new ListNode(5);
        ListNode n7 = new ListNode(6);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        ListNode res = removeElements(n1, 6);
    }
}
