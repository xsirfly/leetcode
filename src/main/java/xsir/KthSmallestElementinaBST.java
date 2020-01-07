package xsir;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestElementinaBST {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> res = new ArrayList<>();
        preTravel(root, k, res);
        return res.get(res.size() - 1);
    }

    public void preTravel(TreeNode root, int k, List<Integer> res) {
        if (res.size() == k) {
            return;
        }
        if (root.left != null) {
            preTravel(root.left, k, res);
            if (res.size() == k) {
                return;
            }
        }
        res.add(root.val);
        if (root.right != null) {
            preTravel(root.right, k, res);
        }
    }

}
