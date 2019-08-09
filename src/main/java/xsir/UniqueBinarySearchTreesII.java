package xsir;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreesII {
    public static List<TreeNode> generateTrees(int n) {
        List<TreeNode> last = new ArrayList<>();
        List<TreeNode> cur;
        if (n <= 0) {
            return last;
        }
        last.add(new TreeNode(1));
        if (n == 1) {
            return last;
        }
        for (int i = 2; i <= n; i++) {
            cur = new ArrayList<>();
            for (TreeNode node : last) {
                TreeNode iNode = new TreeNode(i);
                iNode.left = node;
                cur.add(copy(iNode));
                TreeNode pre = null, next = node;
                while (next != null) {
                    if (pre != null) {
                        pre.right = next;
                    }
                    iNode.left = next.right;
                    next.right = iNode;
                    cur.add(copy(node));
                    pre = next;
                    next = iNode.left;
                }
            }
            last = cur;
        }
        return last;
    }

    private static TreeNode copy(TreeNode src) {
        if (src == null) {
            return null;
        }
        TreeNode dest = new TreeNode(src.val);
        if (src.left != null) {
            dest.left = copy(src.left);
        }
        if (src.right != null) {
            dest.right = copy(src.right);
        }
        return dest;
    }

    public static void main(String[] args) {
        List<TreeNode> nodes = generateTrees(3);
        System.out.println(nodes.size());
    }

}
