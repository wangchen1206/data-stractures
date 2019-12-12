/**
 * Remove Linked List Elements
 * https://leetcode-cn.com/problems/remove-linked-list-elements/
 *
 * @Author: cc
 * @Date: 2019/12/12 15:16
 */
public class Solution3 {

    /**
     * 使用递归解决
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        //求解最基本问题
        if (head == null)
            return null;

        //把原问题转化为更小的问题
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 6, 3, 4, 5, 6};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode listNode = new Solution3().removeElements(head, 6);
        System.out.println(listNode);
    }
}
