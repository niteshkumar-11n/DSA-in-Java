class Pair {
        int sum;
        int count;

        Pair(int sum, int count) {
            this.sum = sum;
            this.count = count;
        }
    }

class Solution {
    static int result =0;
    
    public Pair Avg(TreeNode root) {
        if (root == null) {
            return new Pair(0, 0);
        }

        Pair p1 = Avg(root.left);
        Pair p2 = Avg(root.right);

        int total_sum = p1.sum + p2.sum + root.val;
        int total_count = p1.count + p2.count + 1;

        int total_Avg = total_sum / total_count;

        if (total_Avg == root.val)
            result++;
        return new Pair(total_sum, total_count);
    }
    public int averageOfSubtree(TreeNode root) {
        result =0;
        Avg(root);
        return result;

    }
}