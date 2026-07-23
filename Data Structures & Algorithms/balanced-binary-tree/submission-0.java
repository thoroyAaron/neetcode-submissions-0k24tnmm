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
    private boolean balanced = true;
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        depth(root);
        return balanced;
    }

    private int depth(TreeNode root){
        if(root == null) return 0;
        int left_depth = depth(root.left);
        int right_depth = depth(root.right);

        if(Math.abs(left_depth - right_depth) > 1) balanced = false;
        return Math.max(left_depth, right_depth) + 1;
    }
}
