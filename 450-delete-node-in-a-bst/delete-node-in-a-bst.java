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
    public TreeNode parent(TreeNode root,TreeNode pred){
        if(root.left == pred || root.right == pred) return root;
        TreeNode temp = root.left;
        while (temp.right != pred) temp = temp.right;;
        return temp;
        
    }
    public TreeNode inorder_pred(TreeNode root){
        TreeNode temp = root.left;
        while(temp.right != null){
            temp = temp.right;
        }
        return  temp;
        
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        if(root.val == key){
            //case 1: 0 child
            if (root.left == null && root.right ==null) return null;
            //case 2: 1 child
            if(root.left == null || root.right ==null){
                if(root.right ==null) return root.left;
                else return root.right;
            }
            
            //case3: 2 child node
            else{
                TreeNode pred =  inorder_pred(root);
                TreeNode Parent_pred = parent(root,pred);
                if(root ==Parent_pred){
                    pred.right = root.right;
                    return pred;
                }
                Parent_pred.right = pred.left;
                pred.left = root.left; pred.right = root.right;
                return pred;
            }

        }else if (root.val>key)  root.left = deleteNode(root.left,key);
         else  root.right = deleteNode(root.right,key);   // root.val<key
            
         return root;
    }
}