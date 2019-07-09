package niukejianshu.List;

import java.util.LinkedList;

public class LinkList {
    public ListNode head;
    public ListNode current;
    //反转链表
    public ListNode reverseList(ListNode head){
        if(head==null||head.next==null){
            return head;
        }
        ListNode current=head;
        ListNode next=null;//保存当前节点的下一个节点
        ListNode reverseHead=null;//反转链表的表头
        while(current!=null){
            next=current.next;//保存当前节点的下一个节点
            current.next=reverseHead;//将当前结点的下一个结点指向新链表的头结点
            reverseHead=current;
            current=next;
        }
        return reverseHead;
    }
    //向链表中添加数据
    public  void add(int data){
        //判断链表是否为空
        if(head==null){
            ListNode node=new ListNode(data);
            head=node;
            current=head;
        }else{
            current.next=new ListNode(data);
            current=current.next;
        }
    }
    //测试方法
    public static void main(String[] args) {
        LinkList linklist=new LinkList();
        //向链表中添加数据
        for(int i=1;i<5;i++){
            linklist.add(i);
        }
        linklist.reverseList(linklist.head);
    }
}
