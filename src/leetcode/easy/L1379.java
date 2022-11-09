package leetcode.easy;

import leetcode.testclass.TreeNode;

public class L1379 {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original == target)
            return cloned;
        if (original.getLeft() != null) {
            TreeNode leftResult = getTargetCopy(original.getLeft(), cloned.getLeft(), target);
            if (leftResult != null)
                return leftResult;
        }
        if (original.getRight() != null) {
            TreeNode rightResult = getTargetCopy(original.getRight(), cloned.getRight(), target);
            if (rightResult != null)
                return rightResult;
        }
        return null;
    }
}
