   class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        TreeSet<Integer> available = new TreeSet<>();
        for(int i = 0; i < k; i++) {
            available.add(i);
        }
        PriorityQueue<int[]> busy = new PriorityQueue<>(new Comparator<int[]>() {
            
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });
        int[] count = new int[k];
        for(int i = 0; i < arrival.length; i++) {
            while(!busy.isEmpty() && busy.peek()[0] <= arrival[i]) {
                int[] temp = busy.remove();
                available.add(temp[1]);
            }
            if(available.isEmpty()) {
                continue;
            }
            int target = i % k;
            Integer server = available.ceiling(target);
            if(server == null) {
                server = available.first();
            }
            available.remove(server);
            count[server]++;
            busy.add(new int[]{arrival[i] + load[i], server});
        }
        int max = 0;
        for(int i = 0; i < k; i++) {
            max = Math.max(max, count[i]);
        }
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < k; i++) {
            if(count[i] == max) {
                result.add(i);
            }
        }
        return result;
    }


}