package xsir;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> dict = new HashSet<>();
        ListNode cur = head;
        while (cur != null) {
            if (dict.contains(cur)) {
                return true;
            }
            dict.add(cur);
            cur = cur.next;
        }
        return false;
    }
}
