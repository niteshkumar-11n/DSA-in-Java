class Solution {
    public int leader(int a , int [] parent){
        if (parent[a] == a) return a;
        return parent[a] = leader(parent[a],parent);

    }
    public void union(int u, int v, int[] parent,int[] size){
        int leader_A = leader(u,parent);
        int leader_B = leader(v,parent);
        if (leader_B != leader_A){
            if (size[leader_A]>size[leader_B]){
                parent[leader_B] = leader_A;
                size[leader_A] += size[leader_B];
            }else {
                parent[leader_A] = leader_B;
                size[leader_B] += size[leader_A];
            }
        }

    }
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n+1];
        int[] size = new int[n+1];
        for(int i=1; i<=n; i++){
            parent[i] =i;
            size[i] = 1;
        }
        int [] ans = {-1,-1};
        for (int [] arr: edges) {
            int u = arr[0] ,v = arr[1];
            if (leader(u,parent) == leader(v,parent)) {
                ans[0]  =u;
                ans[1] =v;
                break;
            } else union(u,v,parent ,size);

        }
        return  ans;
    }
}