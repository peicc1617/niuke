package list.删除链表重复结点;

public class Test {
    public static void main(String[] args) {
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(1);
        ListNode node3=new ListNode(10);
        node1.next=node2;
        node2.next=node3;
        Solution so=new Solution();
        ListNode newList=so.deleteDuplicates(node1);
        System.out.print(newList.val);
        ListNode current=newList.next;
        while(current!=null){
            System.out.print("->"+current.val);
            current=current.next;
        }
    }
}
