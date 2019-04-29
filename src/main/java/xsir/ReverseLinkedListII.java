package xsir;

/**
 * @author zhangcong
 * @date 2019/4/16
 */
public class ReverseLinkedListII {

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || m <= 0 || n <= 0 || m == n) {
            return head;
        }
        int i = 1;
        ListNode firstPre = null, first = null, cur = head, next = null, pre = null;
        while (cur != null) {
            if (i >= m && i <= n) {
                if (first == null) {
                    if (i != 1) {
                        firstPre = pre;
                    }
                    first = cur;
                }
                next = cur.next;
                cur.next = pre;
                pre = cur;
                if (i == n) {
                    if (firstPre != null) {
                        firstPre.next = cur;
                    } else {
                        head = cur;
                    }
                    first.next = next;
                    break;
                }
                cur = next;
            } else {
                pre = cur;
                cur = cur.next;
            }
            i++;
        }
        return head;
    }

    public static void  main(String[] args){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        ListNode l = reverseBetween(l1, 2, 4);
        while (l != null) {
            System.out.println(l.val);
            l = l.next;
        }
    }

}
