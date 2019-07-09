package list;
//链表反转
public class ReverseList {
    //递归，
    public  static ListNode reverseByRecursive(ListNode head){
        ListNode newHead=null;
        if(head==null||head.next==null){
            return head;
        }
        ListNode next=head.next;
        newHead=reverseByRecursive(head.next);
        next.next=head;
        head.next=null;
//        System.out.println(newHead.object);
        return newHead;
    }
    //遍历法
    public  static ListNode reverseByTraverse(ListNode node){
        ListNode pre=null,next=null;//pre保存前一节点，next为下一节点
        while(node!=null){
            next=node.next;
            node.next=pre;
            pre=node;
            node=next;
        }
        return pre;
    }
}
