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
    private int maxDiameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        diameterHelper(root);
        return maxDiameter - 1;
    }
    private int diameterHelper(TreeNode root){
        if(root == null) return 0;
        int leftDepth = diameterHelper(root.left);
        int rightDepth = diameterHelper(root.right);
        int nowDepth = leftDepth + rightDepth + 1;
        if(nowDepth > maxDiameter) maxDiameter = nowDepth;
        return Math.max(leftDepth + 1, rightDepth + 1);
    }
}
