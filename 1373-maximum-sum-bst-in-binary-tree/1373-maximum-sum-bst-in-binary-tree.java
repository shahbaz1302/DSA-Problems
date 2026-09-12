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
class NodeValue {
    int maxNode,minNode,maxSum;
    boolean isBST;

    public NodeValue(int minNode, int maxNode, int maxSum,boolean isBST) {
        this.maxNode = maxNode;
        this.minNode = minNode;
        this.maxSum = maxSum;
        this.isBST=isBST;
    }
}

class Solution {

    private int globalSum=0;

    public int maxSumBST(TreeNode root) {
        globalSum=0;
        maxSumBSTHelper(root);
        return globalSum;
    }

    private NodeValue maxSumBSTHelper(TreeNode root) {
        if (root == null) return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0,true);
        NodeValue left = maxSumBSTHelper(root.left);
        NodeValue right = maxSumBSTHelper(root.right);
        if(left.isBST && right.isBST && left.maxNode<root.val && root.val < right.minNode){
            int currentSum= left.maxSum+right.maxSum+root.val;
            globalSum=Math.max(globalSum,currentSum);
            return new NodeValue(Math.min(root.val, left.minNode), Math.max(root.val, right.maxNode),
                    currentSum,true);
        }
        return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE, 0,false);
    }
}