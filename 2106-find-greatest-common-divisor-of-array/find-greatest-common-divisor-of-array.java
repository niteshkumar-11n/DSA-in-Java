class Solution {
    public int findGCD(int[] arr) {
        int a = arr[0];
        int b= arr[0];
        for(int i=1; i<arr.length; i++){
            a = Math.min(arr[i],a);
            b = Math.max(arr[i],b);
        }
        while(b !=0){
            int temp =b;
            b = a%b;
            a = temp;
        }
        return a;
    }
}