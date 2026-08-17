class Solution {
    static int maxSum;
    public int lineSum(TreeNode root) {
        if(root == null) return 0;
        int lineSum_left = lineSum(root.left);
        int lineSum_right = lineSum(root.right);
        int pathSum = root.val;
        if(lineSum_left>0) pathSum += lineSum_left;
        if(lineSum_right>0) pathSum += lineSum_right;
        maxSum = Math.max(pathSum,maxSum);
        return root.val +Math.max(0,Math.max(lineSum_left,lineSum_right));
    }
    public int maxPathSum(TreeNode root) {
         maxSum = Integer.MIN_VALUE;
        lineSum(root);
        return maxSum;
    }
}