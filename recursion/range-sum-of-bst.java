//https://leetcode.com/problems/range-sum-of-bst/
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
    int result = 0;
    public int rangeSumBST(TreeNode root, int L, int R) {
        dfs(root, L, R);
        return result;
    }
    
    public void dfs(TreeNode node, int L, int R) {
        if(node == null) {
            return;
        }
        if(node.val > L) {
            dfs(node.left, L, R);
        }
        if(node.val < R) {
            dfs(node.right, L, R);
        }
        if(node.val >= L && node.val <= R) {
            result += node.val;
        }
    }
    
}