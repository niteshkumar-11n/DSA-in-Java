class Solution {
    public boolean containsNearbyDuplicate(int[] arr, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        boolean flag = false;
        for (int i=0; i<arr.length; i++){
            if(map.containsKey(arr[i])){
                int j = map.get(arr[i]);
                if(Math.abs(j-i)<=k) {
                    flag = true;
                    //map.remove(arr[i]);
                }
            }
            map.put(arr[i],i);
            
        }
        if(flag== true)  return  true;
        else  return  false;
    }
}