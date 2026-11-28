class Solution {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) {
            return true;
        }

        if (root == null) {
            return false;
        }

        if (root.val == subRoot.val) {
            boolean matches = sameTree(root, subRoot);

            if (matches) {
                return true;
            }
        }

        boolean rootleft = isSubtree(root.left, subRoot);
        boolean rootright = isSubtree(root.right, subRoot);

        return rootleft || rootright;
    }

    private boolean sameTree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        } else if (root == null || subRoot == null) {
            return false;
        }

        if (root.val != subRoot.val) {
            return false;
        }

        boolean rootright = sameTree(root.right, subRoot.right);
        boolean rootleft = sameTree(root.left, subRoot.left);

        return rootright && rootleft;
    }
}