package xsir;

public class InsertionSortList {
    public static ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode cur = head, next = null, pre = null;
        ListNode icur, ipre;
        while (cur != null) {
            next = cur.next;
            icur = head;
            ipre = null;
            while (icur != null && icur != cur) {
                if (icur.val > cur.val) {
                    break;
                }
                ipre = icur;
                icur = icur.next;
            }
            if (icur != cur) {
                if (ipre != null) {
                    ipre.next = cur;
                } else {
                    head = cur;
                }
                cur.next = icur;
                if (pre != null) {
                    pre.next = next;
                }
            } else {
                pre = cur;
            }
            cur = next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(4);
//        ListNode n2 = new ListNode(2);
//        ListNode n3 = new ListNode(1);
//        ListNode n4 = new ListNode(3);
//        n1.next = n2;
//        n2.next = n3;
//        n3.next = n4;
        ListNode res = insertionSortList(n1);
        System.out.println(res);
    }
}
