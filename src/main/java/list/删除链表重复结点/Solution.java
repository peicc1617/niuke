package list.删除链表重复结点;

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        //只包含一个元素或为空，返回原值
        if(head==null||head.next==null){
            return head;
        }
        //构造一个新链表
        ListNode newHead=new ListNode(Integer.MIN_VALUE);
        ListNode current=newHead;
        while(head!=null){
            boolean temp=isExist(newHead,head);
            if(!temp){
                current.next=new ListNode(head.val);
                current=current.next;
            }
            head=head.next;
        }
        return newHead.next;
    }
    //判断当前列表是否存在指定元素
    public boolean isExist(ListNode head,ListNode node){
        if(head==null||node==null){
            return false;
        }
        while(head!=null){
            if(head.val==node.val){
                return true;
            }
            head=head.next;
        }
        return false;
    }
}
