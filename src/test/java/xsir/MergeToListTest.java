package xsir;

import org.junit.Test;

/**
 * @author zhangcong
 * @date 2018/10/17
 */
public class MergeToListTest {

    private MergeTwoSortedLists mergeTwoSortedLists = new MergeTwoSortedLists();

    @Test
    public void test() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(4);
        ListNode n4 = new ListNode(1);
        ListNode n5 = new ListNode(3);
        ListNode n6 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;

        n4.next = n5;
        n5.next = n6;

        ListNode result = mergeTwoSortedLists.mergeTwoLists(n1, n4);
        System.out.println(result);
    }

}
