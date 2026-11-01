class Solution {
    public long dividePlayers(int[] skill) {
        int n = skill.length;
        if(n%2 !=0) return -1;
        Arrays.sort(skill);
        long ans=0, same=0;
        int i=0, j = n-1;
        same  = skill[i]+skill[j];
        while(i<=j){
            if(skill[i]+skill[j] != same) return -1;
            else{
                ans +=(skill[i]*skill[j]);
            }
            i++;
            j--;
        }
        return ans;

    }
}