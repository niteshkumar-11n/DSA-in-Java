class Solution {
    public boolean canAliceWin(int n) {
        if(n<10) return false;
        int remaining = n;
        int remove = 10;
        boolean aliceTurn  = true;
        while(remaining>= remove){
            remaining = remaining-remove;
            remove -=1;
            aliceTurn = !aliceTurn;

        }
        return !aliceTurn;
        
    }
}