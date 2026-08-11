class Solution {
    public int missingInteger(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for(int ele: arr){
            set.add(ele);
        }
        int i=1;
        int sum =arr[0];
        while(i<arr.length){
            
            if(arr[i-1]+1 != arr[i]) break;
            sum += arr[i];
            i++;
        } 
        
        while(set.contains(sum)){
            sum ++;
        }
        return sum;
        
        // return sum;
    }
}