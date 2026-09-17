class Solution {
    public boolean findSubarrays(int[] arr) {
        Set<Integer> set = new HashSet<>();
        int n = arr.length;
        int i=0; 
        int sum = 0;
        while(i<n-1){
            sum = arr[i]+arr[i+1];
            if(set.contains(sum)) return true;
            else set.add(sum);
            sum = 0;
            i++;
        }
        
        return false;

    }
}