/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode,TreeNode> parent_track = new HashMap<>();
        markParents(root,parent_track,root);
        Map<TreeNode,Boolean> visited = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(target);
        visited.put(target,true);
        int cur_level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            if(cur_level==k) break;
            cur_level++;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if(node.left!=null && visited.get(node.left)==null){
                    queue.offer(node.left);
                    visited.put(node.left,true);
                }
                if(node.right!=null && visited.get(node.right)==null){
                    queue.offer(node.right);
                    visited.put(node.right,true);
                }
                if(parent_track.get(node)!=null && visited.get(parent_track.get(node))==null){
                    queue.offer(parent_track.get(node));
                    visited.put(parent_track.get(node),true);
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            ans.add(node.val);
        }
        return ans;
    }

    public void markParents(TreeNode root, Map<TreeNode, TreeNode> parent,TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if(cur.left!=null) {
                parent.put(cur.left,cur);
                queue.offer(cur.left);
            }
            if(cur.right!=null) {
                parent.put(cur.right,cur);
                queue.offer(cur.right);
            }
        }
    }
}