package xsir;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author zhangcong
 * @date 2019/4/15
 */
public class PartitionList {

    public static ListNode partition(ListNode head, int x) {
        ListNode root = null, cur = head, curRes = null;
        ArrayDeque<ListNode> greater = new ArrayDeque<>();
        while(cur != null) {
            if (cur.val < x) {
                if (root == null) {
                    root = cur;
                    curRes = cur;
                } else {
                    curRes.next = cur;
                    curRes = cur;
                }
            } else {
                greater.addLast(cur);
            }
            cur = cur.next;
        }
        while (!greater.isEmpty()) {
            if (root == null) {
                root = greater.pop();
                curRes = root;
            } else {
                curRes.next = greater.pop();
                curRes = curRes.next;
            }
        }
        if (curRes != null) {
            curRes.next = null;
        }
        return root;
    }

//    1->4->3->2->5->2
    public static void  main(String[] args){
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(2);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        ListNode root = partition(n1, 3);
        while (root != null) {
            System.out.println(root.val);
            root = root.next;
        }
    }

}
