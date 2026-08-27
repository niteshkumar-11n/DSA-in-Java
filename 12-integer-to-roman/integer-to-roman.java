class Solution {
    public String intToRoman(int num) {
        int [] val = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] ch = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        String ans = "";
            for(int i=0; i<val.length; i++){
                if(num == 0) break;
                int time = num/val[i];
                while(time !=0){
                    ans = ans+ch[i];
                    time--;
                }
                num  = num%val[i];

            }
            return ans;
    }
}