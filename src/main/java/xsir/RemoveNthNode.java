package xsir;

/**
 * @author zhangcong
 * @date 2018/10/9
 */
public class RemoveNthNode {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode pre = null, cur, end;
        cur = end = head;
        while (n > 1 && end != null) {
            end = end.next;
            n--;
        }
        if (end == null) {
            return head.next;
        }
        while (end.next != null) {
            pre = cur;
            cur = cur.next;
            end = end.next;
        }
        // just
        if (pre == null) {
            return cur.next;
        }
        pre.next = cur.next;
        return head;
    }

}
