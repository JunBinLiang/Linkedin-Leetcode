/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    StringBuilder str = new StringBuilder();
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) {
            return "";
        }
        dfs(root);
        return str.toString();
    }
    
    public void dfs(TreeNode root) {
        if(root == null) {
            str.append("# ");
            return;
        }
        str.append("" + root.val);
        str.append(" ");
        dfs(root.left);
        dfs(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() == 0) {
            return null;
        }
        
        String a[] = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(a[0]));
        
        
        
        Stack<Pair> sta = new Stack<>();
        sta.push(new Pair(root, 0));
        
        for(int i = 1; i < a.length; i++) {
            while(sta.peek().cnt == 2) sta.pop();
            Pair pair = sta.peek();
            
            if(a[i].equals("#")) {
                pair.cnt++;
                if(pair.cnt == 2) {
                    sta.pop();
                }
                
            } else {
                int val = Integer.parseInt(a[i]);
                TreeNode node = new TreeNode(val);
                if(pair.cnt == 0) {
                    pair.node.left = node;
                    pair.cnt++;
                } else {
                    pair.node.right = node;
                    pair.cnt++;
                }
                sta.push(new Pair(node, 0));
            }
        }
        
        return root;
    }
    
     class Pair {
        TreeNode node;
        int cnt = 0;
        public Pair(TreeNode node, int cnt) {
            this.node = node;
            this.cnt = cnt;
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;