package xsir;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        pathSum(result, new ArrayList<Integer>(), root, sum);
        return result;
    }

    private void pathSum(List<List<Integer>> result, List<Integer> midRes, TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        midRes.add(root.val);
        if (root.left == null && root.right == null) {
            if (sum == root.val) {
                result.add(new ArrayList<>(midRes));
            }
            return;
        }
        pathSum(result, new ArrayList<>(midRes), root.left, sum - root.val);
        pathSum(result, new ArrayList<>(midRes), root.right, sum - root.val);
    }
}
