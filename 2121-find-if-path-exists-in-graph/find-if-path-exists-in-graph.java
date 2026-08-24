class Solution {
    public boolean validPath(int n, int[][]  edges, int start, int destination) {
        boolean [] vist = new boolean[n];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){ //make a adj list for every node
            adj.add(new ArrayList<>());
        }
        for(int i=0; i< edges.length; i++){  //insert the connected node into the adj list
            int  a= edges[i][0];
            int  b= edges[i][1];
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        bfs(start, adj, vist);
        if(vist[destination] )  return true;
        else return false;
    }
    
    public void bfs(int source,List<List<Integer>> adj,boolean []vist){
        int n = adj.size();
        vist[source] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        while(q.size() >0){
            int front = q.remove();
            for(int ele: adj.get(front)){
                if(vist[ele] == false){
                    vist[ele] = true;
                    q.add(ele);
                }
            }
        }
    }
}