class Solution {
    public class Triplate implements Comparable<Triplate>{
        int node ;
        int parent;
        int dist;
        Triplate(int node, int parent, int dist){
            this.dist =  dist;
            this.node = node;
            this.parent = parent;
        }
        public int compareTo(Triplate t){
            if(t.dist == this.dist) return Integer.compare(this.node, t.node);
            return Integer.compare(this.dist, t.dist);

        }

    }
    public int minCostConnectPoints(int[][] points) {
        int  n = points.length;
        boolean[] vist =  new boolean[n];
        PriorityQueue<Triplate> pq = new PriorityQueue<>();
        pq.add(new Triplate(0,-1,0));
        int sum =0;
        while(pq.size()>0){
            Triplate top = pq.remove();
            int node  = top.node, parent = top.parent , dist = top.dist;
            if(vist[node] ==true) continue;
            sum += dist;
            vist[node] =true;
            for(int i=0; i<n; i++){
                if(vist[i] == true || i == node) continue;
                int x1 = points[node][0], y1 = points[node][1];
                int x2 = points[i][0] ,y2 = points[i][1];
                int mDIs = Math.abs(x1-x2) +Math.abs(y1-y2);
                pq.add(new Triplate(i,node,mDIs));
            }
            
        }
        return sum;
    }
}