package xsir;

/**
 * @author zhangcong
 * @date 2019/1/11
 */
public class RotateList {

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        ListNode cur = head;
        ListNode res;
        int len = 0;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        int realK = k % len;
        if (realK == 0) {
            return head;
        }
        ListNode pre = head, rear = head;
        for (int i = 0; i < realK; i++) {
            rear = rear.next;
        }
        while (rear.next != null) {
            pre = pre.next;
            rear = rear.next;
        }
        res = pre.next;
        pre.next = null;
        rear.next = head;
        return res;
    }
    
    public static void  main(String[] args){
        ListNode l1 = new ListNode(1);
//        ListNode l2 = new ListNode(2);
//        ListNode l3 = new ListNode(3);
//        ListNode l4 = new ListNode(4);
//        ListNode l5 = new ListNode(5);
//        l1.next = l2;
//        l2.next = l3;
//        l3.next = l4;
//        l4.next = l5;
        ListNode res = rotateRight(l1, 0);
        System.out.println(res);
    }

}
