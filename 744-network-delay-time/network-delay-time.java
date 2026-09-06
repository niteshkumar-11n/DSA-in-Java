class Solution {
    public class Pair implements Comparable<Pair> {
        int node;
        int time;

        Pair(int node , int time) {
            this.node = node;
            this.time = time;
        }
    public int compareTo(Pair p) {
            if(this.time == p.time) return this.node - p.node;
            return Integer.compare(this.time,p.time);
        }
    }
    public int networkDelayTime(int[][] times, int n, int src) {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i <=n; i++)  adj.add(new ArrayList<Pair>());
        for(int i = 0; i <times.length; i++ ){
            int u = times[i][0],v = times[i][1], time = times[i][2];
            adj.get(u).add(new Pair(v,time));
        }
        int [] ans = new int[n+1];
        Arrays.fill(ans,Integer.MAX_VALUE);
        ans[src]  =0;
        PriorityQueue<Pair> pq = new PriorityQueue<>();  // min heap
        pq.add(new Pair(src,0));
        while(pq.size()>0){
            Pair top = pq.remove();
            int node = top.node;
            int time = top.time;
            if (top.time>ans[node]) continue;
            for (Pair p : adj.get(node)){
                int total_time = top.time+ p.time;
                if ( ans[p.node]>total_time ) {
                    ans[p.node] = total_time;
                    pq.add(new Pair(p.node,total_time));
                }
            }
        }
        int max_ans = -1;
        for (int i = 1; i <ans.length ; i++) {
            max_ans = Math.max(max_ans,ans[i]);
        }
        if(max_ans ==Integer.MAX_VALUE) return -1;
        return  max_ans;
    }
}