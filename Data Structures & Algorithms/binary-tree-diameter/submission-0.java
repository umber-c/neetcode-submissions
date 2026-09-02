/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int maxDiameter =0;
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return maxDiameter;
    }
    private int depth(TreeNode root){
        if (root == null){
            return 0;
        }
        int right = depth(root.right);
        int left = depth(root.left);
        int currentDepth = left + right;
        maxDiameter = Math.max(currentDepth, maxDiameter);
        return Math.max(left, right) + 1;
    }
}
