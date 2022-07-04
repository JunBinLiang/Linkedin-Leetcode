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

//inorder 
class BSTIterator {
    //stack inorder O(h)
     Stack<TreeNode> sta = new Stack<>();
    public BSTIterator(TreeNode root) {
        sta.add(root);
        while(sta.peek().left != null) {
            TreeNode left = sta.peek().left;
            sta.peek().left = null;
            sta.push(left);
        }
    }
    
    public int next() {
        TreeNode top = sta.pop();
        if(top.right != null) {
            sta.push(top.right);
            while(sta.peek().left != null) {
                TreeNode left = sta.peek().left;
                sta.peek().left = null;
                sta.push(left);
            }
            
        }
        return top.val;
    }
    
    public boolean hasNext() {
        return sta.size() > 0;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */