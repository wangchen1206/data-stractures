/**
 * Remove Linked List Elements
 * https://leetcode-cn.com/problems/remove-linked-list-elements/
 *
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

    public static void main(String[] args) {
        int[] nums = {1,2,6,3,4,5,6};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode listNode = new Solution2().removeElements(head, 6);
        System.out.println(listNode);
    }
}
