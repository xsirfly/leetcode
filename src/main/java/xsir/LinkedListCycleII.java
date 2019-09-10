package xsir;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> dict = new HashSet<>();
        ListNode cur = head;
        while (cur != null) {
            if (dict.contains(cur)) {
                return cur;
            }
            dict.add(cur);
            cur = cur.next;
        }
        return null;
    }
}
