/**
 * @Author: cc
 * @Date: 2019/12/12 13:51
 */
public class Solution2 {
    public ListNode removeElements(ListNode head, int val){
        //使用虚拟头节点，可以让链表中的每个节点都有前一个节点（prev）.
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode prev = dummyHead;
        while (prev.next != null){
            if (prev.next.val == val){
                prev.next = prev.next.next;
            }else {
                prev = prev.next;
            }
        }
        return dummyHead.next;
    }
}
