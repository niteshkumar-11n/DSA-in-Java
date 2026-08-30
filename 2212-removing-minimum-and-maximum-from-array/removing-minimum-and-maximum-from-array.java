class Solution {
    public int minimumDeletions(int[] arr) {
        int min = Integer.MAX_VALUE;
        int min_id =-1;
        int max = Integer.MIN_VALUE;
        int max_id =0;
        if(arr.length ==1) return 1;
        for(int i=0; i<arr.length; i++){
            if(arr[i]<min){
                min = arr[i];
                min_id = i;
            }
            if(arr[i]>max){
                max = arr[i];
                max_id = i;
            }
            
        }
       
        int n = arr.length;
        int left = Math.max(min_id, max_id) + 1;
        int right = n - Math.min(min_id, max_id);
        int both = (Math.min(min_id, max_id) + 1)+ (n - Math.max(min_id, max_id));
        int deleted = Math.min(left, Math.min(right, both));
        return deleted;
    }
}