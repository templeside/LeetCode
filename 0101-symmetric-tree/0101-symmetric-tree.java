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
    /*
    we need to know left.right == right.left, left.left == right.right
    bfs.
    */
    public boolean isSymmetric(TreeNode root) {
        return isSymmetrick(root, root);
    }
    
    public boolean isSymmetrick(TreeNode t1, TreeNode t2){
        if(t1== null && t2 ==null)return true;
        if(t1== null || t2 ==null)return false;
        
        return isSymmetrick(t1.left , t2.right) && isSymmetrick(t1.right, t2.left) && t1.val == t2.val;
    }
}