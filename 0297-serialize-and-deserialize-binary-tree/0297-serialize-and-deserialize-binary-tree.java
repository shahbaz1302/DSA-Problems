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

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder ans = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null){
                ans.append("# ");
                continue;
            }
            ans.append(node.val+" ");
            queue.add(node.left);
            queue.add(node.right);
        }
        return ans.toString();
    }

    public TreeNode deserialize(String data) {
        if(data=="") return null;
        Queue<TreeNode> queue = new LinkedList<>();
        String[] str = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(str[0]));
        queue.add(root);
        for (int i = 1; i < str.length; i++) {
            TreeNode parent = queue.poll();
            if (!str[i].equals("#")) {
                TreeNode left = new TreeNode(Integer.parseInt(str[i]));
                parent.left = left;
                queue.add(left);
            }
            if (!str[++i].equals("#")) {
                TreeNode right = new TreeNode(Integer.parseInt(str[i]));
                parent.right = right;
                queue.add(right);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));