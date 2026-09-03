class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return sameTree(p, q);
    }

    private boolean sameTree(TreeNode p, TreeNode q) {

        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        if (p.val != q.val) {
            return false;
        }

        boolean isLeftSame = sameTree(p.left, q.left);
        boolean isRightSame = sameTree(p.right, q.right);

        return isLeftSame && isRightSame;
    }
}
