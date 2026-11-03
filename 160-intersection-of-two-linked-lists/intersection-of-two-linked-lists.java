public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
       ListNode tempA = headA; 
       ListNode tempB = headB;
       int lengthA=0;
       int lengthB=0;
       ///count length of the first list 
       while(tempA != null){
        lengthA++;
        tempA = tempA.next;
       } 
        while(tempB != null){
            lengthB++;
            tempB = tempB.next;
       } 
       tempA= headA;
       tempB=headB;
       if(lengthA>=lengthB){
           
            int  diff = lengthA-lengthB;
            for(int i=0; i<diff; i++){
                tempA = tempA.next;
            }
            
       }
       else{ 
            int diff = lengthB-lengthA;
            for(int i=0; i<diff; i++){
                tempB = tempB.next;
            }
       
       }
       while(tempA !=tempB){
        tempA = tempA.next;
        tempB = tempB.next;
       }
       return tempA;
    }
}