class Solution {
    public int maxSubarrayLength(int[] arr, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int count =0;
        int j=0;
        int i=0;
        for(i=0; i<arr.length; i++){
            if(map.containsKey(arr[i])){
                int freq = map.get(arr[i])+1;
                map.put(arr[i],freq);
            }
            else map.put(arr[i],1);
            while(map.get(arr[i])>k){  // sliding window
                map.put(arr[j],map.get(arr[j])-1);
                j++;
            }
            count= Math.max(count,i-j+1); 
        }
       
        return count;
    }
}