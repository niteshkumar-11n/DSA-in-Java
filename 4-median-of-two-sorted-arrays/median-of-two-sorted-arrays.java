class Solution {
    public double findMedianSortedArrays(int[] arr1, int[] arr2) {
        int m = arr1.length;
        int n = arr2.length;
        int[] arr3 = new int[m+n];
        int i=0,j=0,k=0;
        while(i <m && j<n){
            if(arr1[i] <= arr2[j]){
                arr3[k] = arr1[i];
                i++;
            } else{
                arr3[k] = arr2[j];
                j++;
            }
            k++;
        }
        if(i==m){
            while(j<n){
                arr3[k] = arr2[j];
                j++;
                k++;
            }
        }
        if(j==n){
            while(i<m){
                arr3[k] = arr1[i];
                i++;
                k++;
            }
        }
    int len = arr3.length;
    if(len%2 !=0) return arr3[len/2];
    else{
        double median = (arr3[len/2-1]+arr3[len/2])/2.0;
        return median;
    }


    }
}