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

//rows : height
//column: 2 ^ height - 1
class Solution {
    int height = 0;
    String a[][];
    public List<List<String>> printTree(TreeNode root) {
        dfs(root, 1);
        int n = height, m = (1 << height) - 1;
        a = new String[n][m];
        dfs1(root, 0, (m - 1) / 2);
        return convert();
    }
    
    public List<List<String>> convert() {
        int n = a.length, m = a[0].length;
        List<List<String>> res = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            List<String> list = new ArrayList<>();
            for(int j = 0; j < m; j++) list.add((a[i][j] == null)? "" : a[i][j]);
            res.add(list);
        }
        return res;
    }
    
    public void dfs(TreeNode root, int h) {
        if(root == null) return;
        dfs(root.left, h + 1);
        dfs(root.right, h + 1);
        height = Math.max(height, h);
    }
    
    
    public void dfs1(TreeNode root, int r, int c) {
        if(root == null) return;
       // System.out.println(r + " " + c);
        a[r][c] = "" + root.val;
        int left = c - (1 << (height - (r + 1) - 1)); 
        int right = c + (1 << (height - (r + 1) - 1));
        dfs1(root.left, r + 1, left);
        dfs1(root.right, r + 1, right);
    }
}

//1 -  2 ^ (2 - 0 - 1)

//3 - 2 ^ (3 - 0 - 1)