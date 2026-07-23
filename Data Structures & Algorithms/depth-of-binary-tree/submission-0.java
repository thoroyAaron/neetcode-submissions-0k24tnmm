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
    private int depth = 0;
    public int maxDepth(TreeNode root) {
        getMaxDepth(root, 0);
        return depth;
    }

    private void getMaxDepth(TreeNode root, int prevDepth){
        if(root == null) return ;
        depth = depth > prevDepth + 1 ? depth:prevDepth + 1;
        getMaxDepth(root.left, prevDepth + 1);
        getMaxDepth(root.right, prevDepth + 1);
    }
}
