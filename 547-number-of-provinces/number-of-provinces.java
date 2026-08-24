class Solution {
    public int findCircleNum(int[][] adj) {
        int n = adj.length;
        int count =0;
        boolean [] vist = new boolean[n];
        for(int i=0; i<n; i++){
            if(!vist[i]) {
                bfs(i, adj, vist);
                count++;
            }
        }
        return count;
    }
    public void bfs(int i,int[][] adj,boolean []vist){
        int n = adj.length;
        vist[i] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        while(q.size() >0){
            int front = q.remove();
            for(int j=0; j<n; j++){
                if(adj[front][j] ==1 && vist[j] == false){
                    vist[j] = true;
                    q.add(j);
                }
            }
        }
    }

}