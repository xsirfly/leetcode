package xsir;

/**
 * @author zhangcong
 * @date 2018/10/19
 */
public class SwapNodeInPair {

    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode cur = head, tmp = null, pre = null;
        ListNode result = head.next == null ? head : head.next;
        while (cur != null && cur.next != null) {
            if (pre != null) {
                pre.next = cur.next;
            }
            tmp = cur.next;
            cur.next = cur.next.next;
            tmp.next = cur;
            pre = cur;
            cur = cur.next;
        }
        return result;
    }

}
