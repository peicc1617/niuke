public class ListNode<T>{
    ListNode next;//指向下一个节点
    T val;

    /**
     * 构造函数
     * @param next
     * @param object
     */
    public ListNode(ListNode next, T val) {
        this.next = next;
        this.val = val;
    }
}
