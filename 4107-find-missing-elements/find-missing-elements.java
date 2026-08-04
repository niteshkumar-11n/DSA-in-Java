class Solution {
    public List<Integer> findMissingElements(int[] arr) {
        Set<Integer> set = new HashSet<>();
        List<Integer> ans = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            set.add(arr[i]);
            min = Math.min(min,arr[i]);
            max = Math.max(max,arr[i]);
        }
        for(int i=min; i<=max; i++){
            if(!set.contains(i)) ans.add(i);
        }
        return ans;
    }
}