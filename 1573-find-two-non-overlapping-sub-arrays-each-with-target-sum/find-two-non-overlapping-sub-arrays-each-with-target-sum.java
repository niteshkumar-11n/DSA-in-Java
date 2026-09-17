class Solution {
     public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int currSum =0;
        int [] minLenTillIdx = new int[n];
        Arrays.fill(minLenTillIdx,Integer.MAX_VALUE);
        int j=0,i=0;
        int result = Integer.MAX_VALUE;
        int bestMin = Integer.MAX_VALUE;
        while (j<n){

            currSum +=arr[j];
            while (i<j && currSum> target) currSum -= arr[i++];
            if(currSum == target){
                int len  =j-i+1;
                if(i>0 && minLenTillIdx[i-1] != Integer.MAX_VALUE){
                    result = Math.min(result, len +minLenTillIdx[i-1]);
                }
                bestMin = Math.min(bestMin,len);
            }
            minLenTillIdx[j]  = bestMin;
            j++;
        }
        System.out.println(result);
        if(result == Integer.MAX_VALUE) return  -1;
        else return result;
    }
}