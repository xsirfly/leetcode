package xsir;

/**
 * @author zhangcong
 * @date 2018/10/17
 */
public class MergeTwoSortedLists {

    /**
     * 1, 2, 4
     * 1, 3, 4
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode cur1 = l1, cur2 = l2, cur;
        if (l1.val < l2.val) {
            cur = l1;
            cur1 = l1.next;
        } else {
            cur = l2;
            cur2 = l2.next;
        }
        while(cur1 != null || cur2 != null) {
            if (cur1 == null) {
                cur.next = cur2;
                break;
            }
            if (cur2 == null) {
                cur.next = cur1;
                break;
            }
            if (cur1.val < cur2.val) {
                cur.next = cur1;
                cur1 = cur1.next;
            } else {
                cur.next = cur2;
                cur2 = cur2.next;
            }
            cur = cur.next;
        }
        return l1.val < l2.val ? l1 : l2;
    }

}
