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
    public int minimumFlips(TreeNode root, boolean result) {
        int res[] = dfs(root);
        if(result) return res[1];
        else return res[0];
    }
    
    public int[] dfs(TreeNode root) {
        if(root == null) {
            return null;
        }
        
        if(root.left == null && root.right == null) {
            if(root.val == 0) {
                return new int[]{0, 1};
            } else {
                return new int[]{1, 0};
            }
        }
        
        int val = root.val;
        int l[] = dfs(root.left);
        int r[] = dfs(root.right);
        int res[] = new int[2];
        if(val == 2) { //OR
            res[0] = l[0] + r[0];
            res[1] = l[1] + r[1];
            res[1] = Math.min(res[1], l[1] + r[0]);
            res[1] = Math.min(res[1], l[0] + r[1]);
        } else if(val == 3) { //and
            res[0] = l[0] + r[1];
            res[0] = Math.min(res[0], l[1] + r[0]);
            res[0] = Math.min(res[0], l[0] + r[0]);
            res[1] = l[1] + r[1];
            
        } else if(val == 4) { //xor
            res[1] = Math.min(l[0] + r[1], l[1] + r[0]);
            res[0] = Math.min(l[0] + r[0], l[1] + r[1]);
        } else { //not
            if(l != null) {
                res[0] = l[1];
                res[1] = l[0];
            } else {
                res[0] = r[1];
                res[1] = r[0];
            }
        }
        return res;
    }
}