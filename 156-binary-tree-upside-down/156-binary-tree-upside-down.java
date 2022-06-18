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

//start : 11 : 56
//end : 12 : 08

class Solution {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root == null) {
            return null;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;
        root.right = null;
        return dfs(left, root, right);   
    }
    
    public TreeNode dfs(TreeNode root, TreeNode last, TreeNode right) {
        if(root != null) {
            TreeNode lleft = root.left;
            TreeNode lright = root.right;
            root.right = last;
            root.left = right;
            return dfs(lleft, root, lright);
            
        } else {
            return last;
        }
        
 

    }
}