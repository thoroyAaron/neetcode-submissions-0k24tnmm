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
    public TreeNode invertTree(TreeNode root) {
        trevalse(root);
        return root;
    }

    private void trevalse(TreeNode tn){
        if(tn == null) return;
        TreeNode temp = tn.left;
        tn.left = tn.right;
        tn.right = temp;
        trevalse(tn.left);
        trevalse(tn.right);
    }
}
