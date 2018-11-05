package xsir;

import org.junit.Test;

/**
 * @author zhangcong
 * @date 2018/10/19
 */
public class SwapNodeInPairTest {

    private SwapNodeInPair swapNodeInPair = new SwapNodeInPair();

    @Test
    public void test() {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;

        ListNode result = swapNodeInPair.swapPairs(l1);
        System.out.println(result);
    }

}
