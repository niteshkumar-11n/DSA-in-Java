
class Solution {
    class Pair{
        TreeNode node;
        int level;
        Pair(TreeNode node,int level){
            this.node = node;
            this.level = level;
        }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        Queue<Pair> q = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        if(root == null ) return ans;
        int prevLevel = 0;
        if(root !=null) q.add(new Pair(root,0));
        while(q.size() !=0){
            Pair  temp = q.remove();
            TreeNode front = temp.node;
            int lvl = temp.level;

            if (lvl != prevLevel) {
                ans.add(arr);
                arr = new ArrayList<>();
                prevLevel = lvl;
            }
            
            arr.add(front.val);
            
            if(front.left != null) q.add(new Pair(front.left,lvl+1));
            if(front.right != null) q.add(new Pair(front.right,lvl+1));
        }
        ans.add(arr);
        return ans;

    }
}