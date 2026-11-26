class Solution {
    public  void inOrder(TreeNode root,ArrayList<TreeNode> list){
        if(root == null){
            return;
        }
        inOrder(root.left,list);
        list.add(root);
        inOrder(root.right,list);
    }
    public TreeNode createTree(ArrayList<TreeNode> list , int lo, int hi){
        if(lo>hi){
            return null;
        }

        int mid = lo+(hi-lo)/2;
        TreeNode root =new TreeNode(list.get(mid).val);
        root.left = createTree(list,lo,mid-1);
        root.right = createTree(list,mid+1,hi);

        return root;

    }
    public TreeNode balanceBST(TreeNode root) {
        ArrayList<TreeNode> list = new ArrayList<>();
        inOrder(root,list);
        return createTree(list, 0,list.size()-1);


    }
}