class Solution {
    public ListNode reverseList(ListNode head){
        ListNode pre  = null;
        ListNode curr = head;
        ListNode Next = null;
        while(curr !=null){
            Next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = Next;
        }
        return pre;
    }
    public int LengthList(ListNode head){
        ListNode temp = head;
        int len=0;
        while(temp != null){
            len++;
            temp = temp.next;
        }
        return len;
    } 
    public ListNode rotateRight(ListNode head, int k) {
       
        int len = LengthList(head);
        ListNode temp = head;
        if(head==null || head.next== null || k==0 || k==len) return head;
        k = len - (k%len);
        if(k==0||k==len) return head;
        for(int i=1; i<k; i++){
            temp = temp.next;
        }
        ListNode newhead = temp.next;
        temp.next = null;
        ListNode temp2 = newhead;
        
        while(temp2.next!= null) temp2 = temp2.next;
        temp2.next = head;
        return  newhead;

    }
}