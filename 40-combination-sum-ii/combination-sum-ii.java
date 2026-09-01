class Solution {
    public void backtrack(List<List<Integer>> result, List<Integer> comb , int []arr,int start, int k, int sum){
        if (sum == k){
            result.add(new ArrayList<>(comb));
            return;
        }
        if(sum>k ) return;
        for (int i=start; i<arr.length;i++){
            if (i > start && arr[i] == arr[i - 1]) continue;
            //if (comb.contains(arr[i])) continue;
            comb.add(arr[i]);
            backtrack(result,comb,arr,i+1,k, sum +arr[i] );
            comb.remove(comb.size()-1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] arr, int target) {
        List<List<Integer>> result  = new ArrayList<>();
        Arrays.sort(arr);
        backtrack(result,new ArrayList<>(), arr,0, target,0);
        return  result;
    }
}