class Solution {
    public int maxOperations(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        for(int i=0; i<n; i++){
            if (map.containsKey(nums[i])){
                int freq = map.get(nums[i]);
                map.put(nums[i] , freq+1);
            }else map.put(nums[i],1);
        }
        int opertaion=0;
        for (int i = 0; i <n ; i++) {
            int remain = k-nums[i];
            if(map.containsKey(remain) && map.containsKey(nums[i])){
                int freq = map.get(nums[i]);
                int freq1 = map.get(remain);
                if(nums[i] == remain){
                    if(freq >= 2){
                        map.put(nums[i], freq-2);
                        opertaion++;
                    }
                }else if(freq > 0 && freq1 > 0){
                    map.put(nums[i], freq-1);
                    map.put(remain, freq1-1);
                    opertaion++;
                }
            
            }
                
        }
    
        return opertaion;
    }
}