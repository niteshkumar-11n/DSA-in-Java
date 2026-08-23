class Solution {
    public boolean  game(int i,int j,String arr) {
        int countLeft = 0;
        int sumLeft = 0;
        int countRight = 0;
        int sumRight = 0;
        for( i=0; i<=j/2; i++){
            char ch = arr.charAt(i);
            if(ch =='?') countLeft++;
            else sumLeft += ch-'0';
        }
        for( i=j/2+1; i<=j; i++){
            char ch = arr.charAt(i);
            if(ch =='?') countRight++;
            else sumRight += ch-'0';
        }
        
        int totalLeft = 2*sumLeft+9*countLeft;
        int totalRight = 2*sumRight+9*countRight;
        if((countLeft + countRight)%2 !=0) return true; // alice always win
        else if(totalLeft == totalRight) return false;  // bob win
        else return true;

    }
    public boolean sumGame(String arr) {
        int n = arr.length();
        return game(0,n-1,arr);
    }
}