package list;

public class Main {
    public static void main(String[] args) {
        ListNode<Integer> node7=new ListNode<Integer>(null,7);
        ListNode<Integer> node6=new ListNode<Integer>(node7,6);
        ListNode<Integer> node5=new ListNode<Integer>(node6,5);
        ListNode<Integer> node4=new ListNode<Integer>(node5,4);
        ListNode<Integer> node3=new ListNode<Integer>(node4,3);
        ListNode<Integer> node2=new ListNode<Integer>(node3,2);
        ListNode<Integer> node1=new ListNode<Integer>(node2,1);
        ListNode temp=node1;
        //获取前一位置结点
        ListNode pre=getNodeByIndex(node1,2);
        //获取后一位置结点
        ListNode next=getNodeByIndex(node1,7);
        ListNode result=subList(temp,3,6);
        ListNode midHead=ReverseList.reverseByRecursive(result);
        printList(midHead);
        System.out.println("\n");
        ListNode subTail=getNodeByIndex(midHead,4);
        pre.next=midHead;
        subTail.next=next;
        printList(node1);
        System.out.println(getNodeByIndex(node1,3).object);
    }
    //打印链表
    public static  void printList(ListNode listNode){
        if(listNode==null){
            return;
        }
        System.out.print(listNode.object.toString());
        while(listNode.next!=null){
            listNode=listNode.next;
            System.out.print("-->"+listNode.object.toString());
        }
    }
    //获取子链表
    public static ListNode subList(ListNode head,int begin,int end){
        ListNode subListHead=null;
        ListNode subListTail=null;
        if(head==null||head.next==null){
            return head;
        }
        subListHead=head;
        for(int i=0;i<begin-1;i++){
            subListHead=subListHead.next;
        }
        subListTail=head;
        for(int j=0;j<end-1;j++){
            subListTail=subListTail.next;
        }
        subListTail.next=null;
        return subListHead;
    }
    //获取指定位置的结点
    public static ListNode getNodeByIndex(ListNode head,int index){
        ListNode result;
        if(head==null){
            return null;
        }
        result=head;
        for(int i=0;i<index-1;i++){
            result=result.next;
        }
        return result;
    }
}
