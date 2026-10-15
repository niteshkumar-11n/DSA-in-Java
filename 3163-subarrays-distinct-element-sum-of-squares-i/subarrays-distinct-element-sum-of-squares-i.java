class Solution {
    public int sumCounts(List<Integer> nums) {
        int n = nums.size();
        int sum =0;
        HashSet<Integer> set  = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.clear();
            for (int j=i; j<n; j++){
                set.add(nums.get(j));
                sum += (set.size()*set.size());
            }

        }
        return sum;
    }
}