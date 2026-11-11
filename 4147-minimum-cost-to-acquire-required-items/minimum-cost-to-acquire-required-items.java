class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long type1 = (long)cost1*need1;
        long type2 =(long) cost2*need2;
        long total_cost =0;
        if((cost1+cost2) <= costBoth) return  type1+type2;
        else{
            int item = Math.min(need1,need2);
             total_cost =(long) item*costBoth;
            if(need1-item >0) total_cost += (long)Math.min(cost1,costBoth)*(need1-item);
            else if (need2-item >0) total_cost +=(long) Math.min(cost2,costBoth)*(need2-item);
            else return total_cost;
        }
       return total_cost;
    }
}