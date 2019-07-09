public class Merge {
    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode merge(ListNode list1,ListNode list2){
        ListNode head=null;
        ListNode current=null;
        if(list1==null){
            return list2;
        }
        if(list2==null){
            return list1;
        }
        while(list1!=null&&list2!=null){
            if(list1.val<=list2.val){
                if(head==null){
                   head=current=list1;
                   list1=list1.next;
                }else{
                    current.next=list1;
                    current=current.next;
                }
            }
        }
        return head;
    }
}
