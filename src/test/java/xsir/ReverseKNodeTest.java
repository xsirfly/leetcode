package xsir;

import org.junit.Test;

public class ReverseKNodeTest {

    private ReverseKNode reverseKNode = new ReverseKNode();

    @Test
    public void test() {
        ReverseKNode.ListNode l1 = new ReverseKNode.ListNode(1);
        ReverseKNode.ListNode l2 = new ReverseKNode.ListNode(2);
//        ReverseKNode.ListNode l3 = new ReverseKNode.ListNode(3);
//        ReverseKNode.ListNode l4 = new ReverseKNode.ListNode(4);
//        ReverseKNode.ListNode l5 = new ReverseKNode.ListNode(5);

        l1.next = l2;
//        l2.next = l3;
//        l3.next = l4;
//        l4.next = l5;

        ReverseKNode.ListNode res = reverseKNode.reverseKGroup(l1, 2);
        System.out.println(res);
    }
}
