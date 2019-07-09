package list;

public class ListNode<T>{
    ListNode next;//指向下一个节点
    T object;

    /**
     * 构造函数
     * @param next
     * @param object
     */
    public ListNode(ListNode next, T object) {
        this.next = next;
        this.object = object;
    }
}
