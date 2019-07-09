import java.util.Arrays;

public class Solution2 {
    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode head;
    public ListNode current;
    public static void main(String args[]){
        Solution2 s2=new Solution2();
        s2.addNode(1);
        s2.addNode(2);
        s2.addNode(3);
        s2.addNode(4);
        s2.addNode(5);
        s2.current.next=s2.head;
       System.out.println(s2.EntryNodeOfLoop(s2.head).val);

    }
    public void addNode(int data){
        if(head==null){
            head=new ListNode(data);
            current=head;
        }else{
            current.next=new ListNode(data);
            current=current.next;
        }
    }

    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        if(pHead==null||pHead.next==null) return null;
        ListNode meetNode;
        meetNode=hasCycle(pHead);//判断是否有环并返回相遇节点
        if(meetNode==null) return null;
        //获取环的长度
        int cycleLength=getCycleLength(meetNode);
        return getCycleStart(pHead,cycleLength);
    }
    //判断是否有环
    public ListNode hasCycle(ListNode pHead){
        ListNode first=pHead;
        ListNode second=pHead;
        while(second!=null){
            first=first.next;
            second=second.next.next;
            if(first==second){
                return first;
            }
        }
        return null;
    }
    public int getCycleLength(ListNode listNode){
        int length=0;
        ListNode current=listNode;
        while(current!=null){
            current=current.next;
            length++;
            if(current==listNode){
                return length;
            }
        }
        return 0;
    }
    public ListNode getCycleStart(ListNode listNode,int length){
        ListNode first=listNode;
        ListNode second=listNode;
        for(int i=0;i<length;i++){
            second=second.next;
        }
        while(first!=null&&second!=null){
            if(first==second){
                return first;
            }
            first=first.next;
            second=second.next;


        }
        return null;
    }
}