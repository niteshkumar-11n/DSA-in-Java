class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int i = 0;
        int count=0;

        while(i<arr1.length){
            boolean flag = true;
            for(int j=0; j<arr2.length; j++){
                if(Math.abs(arr1[i]-arr2[j])<=d) {
                    flag = false;
                    break;
                }
            }

            if(flag) count++;
            i++;
        }
        return count;
    }
}