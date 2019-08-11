package xsir;

public class ConvertSortedListToBinarySearchTree {

    public static TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode cur = head;
        while (cur.next != null) cur = cur.next;
        return build(head, cur);
    }

    private static TreeNode build(ListNode start, ListNode end) {
        if (start == null || end == null) {
            return null;
        }
        if (start.val == end.val) {
            return new TreeNode(start.val);
        }
        ListNode pre = null;
        ListNode slow = start;
        ListNode fast = start;
        while (fast.val != end.val && fast.next.val != end.val) {
            pre = slow;
            slow = slow.next;
            fast = fast.next;
            fast = fast.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = build(start, pre);
        root.right = build(slow.next, end);
        return root;
    }

    public static void main(String[] args) {

    }

}
