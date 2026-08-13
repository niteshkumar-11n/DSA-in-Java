class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int [] ans = new int[m+n];
        int i=0,j=0,k=0;
        while(i<m && j<n){
            if(nums1[i]>= nums2[j]){
                ans[k++] = nums2[j++];
            } else{
                ans[k++] = nums1[i++];
            }
        }
       
            while(j <n){
                ans[k++] = nums2[j++];
            }
        
            while(i <m){
                ans[k++] = nums1[i++];
            }
        for(int t=0;  t<m+n; t++){
            nums1[t] = ans[t];
        }

    }
}