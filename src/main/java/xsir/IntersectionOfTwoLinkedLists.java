package xsir;

import java.util.Stack;

/**
 * @author zhangcong
 * @date 2019/4/30
 */
public class IntersectionOfTwoLinkedLists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        Stack<ListNode> s1 = new Stack<>();
        Stack<ListNode> s2 = new Stack<>();
        ListNode cur = headA;
        while(cur != null) {
            s1.push(cur);
            cur = cur.next;
        }
        cur = headB;
        while (cur != null) {
            s2.push(cur);
            cur = cur.next;
        }
        ListNode pre = null;
        while (!s1.isEmpty() && !s2.isEmpty()) {
            ListNode a = s1.pop();
            ListNode b = s2.pop();
            if (a != b) {
                return pre;
            } else {
                pre = a;
            }
        }
        return pre;
    }

}
