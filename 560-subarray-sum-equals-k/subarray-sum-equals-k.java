class Solution {
    public int subarraySum(int[] arr, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i=1; i<arr.length; i++){
            arr[i] +=arr[i-1];
        }
        int count =0;
        map.put(0,1);
        for (int i=0; i<arr.length; i++){
            int rem =arr[i]-k;
            
            if(map.containsKey(rem)){
                count +=map.get(rem);
            }
           if (map.containsKey(arr[i]) )  map.put(arr[i],map.get(arr[i])+1);
           else map.put(arr[i],1);
        }
        return count;
        
    }
}