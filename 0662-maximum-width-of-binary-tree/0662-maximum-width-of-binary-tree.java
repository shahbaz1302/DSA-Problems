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
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        int ans = 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));
        while (!queue.isEmpty()) {
            int size = queue.size();
            int min_id = queue.peek().num;
            int first = 0, last = 0;
            for (int i = 0; i < size; i++) {
                int cur_id = queue.peek().num - min_id;
                TreeNode node = queue.poll().node;
                if (i == 0)
                    first = cur_id;
                if (i == size - 1)
                    last = cur_id;
                if (node.left != null)
                    queue.add(new Pair(node.left, cur_id * 2 + 1));
                if (node.right != null)
                    queue.add(new Pair(node.right, cur_id * 2 + 2));
            }
            ans = Math.max(ans, last - first + 1);
        }
        return ans;
    }
}

class Pair {
    TreeNode node;
    int num;

    public Pair(TreeNode node, int num) {
        this.node = node;
        this.num = num;
    }
}