class Solution {
    public class Pair {
        int node;
        int  cost;

        Pair(int node , int cost) {
            this.node = node;
            this.cost = cost;
        }
    }
    public class Triplate{
        int node ;
        int cost;
        int stops;
        Triplate(int node, int cost, int stops){
            this.stops =  stops;
            this.node = node;
            this.cost = cost;
        }
        

    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)  adj.add(new ArrayList<Pair>());
        for (int i = 0; i <flights.length; i++){
            int from = flights[i][0], to = flights[i][1] , cost = flights[i][2];
            adj.get(from).add(new Pair(to,cost));
        }
        int [] ans = new int[n];
        Arrays.fill(ans, Integer.MAX_VALUE);
        ans[src] = 0;
        Queue<Triplate> pq = new LinkedList<>();
        pq.add(new Triplate(src,0,0));
        while(pq.size()>0){
            Triplate top = pq.remove();
            int node = top.node;
            int cost = top.cost;
            int stops = top.stops;
            
            if(stops == k+1) continue;
            for (Pair p : adj.get(node)){
                int total_cost = cost +p.cost;
                if(ans[p.node ]>total_cost) {
                    ans[p.node ] = total_cost;
                    pq.add(new Triplate(p.node,total_cost,stops+1));
                }
            }
        }
        if(ans[dst] == Integer.MAX_VALUE) return -1;
        return ans[dst];
    }
}