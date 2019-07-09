package list;

public class Util {
    public static ListNode getNodeByIndex(ListNode head,int index){
        ListNode result=head;
        for(int i=0;i<index-1;i++){
            result=head.next;
        }
        return result;
    }
}
