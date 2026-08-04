class Solution {
    public List<Integer> findMissingElements(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        List<Integer> ans = new ArrayList<>();
        int min =arr[0];
        int max =arr[n-1];
        int a = min;
        int i=0;
        while(a<=max){
            if(a== arr[i]) {
                a++;
                i++;
            }
            else{
                ans.add(a);
                a++;
            } 
        }
        return ans;

    }
}