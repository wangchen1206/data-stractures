/**
 * @Author: cc
 * @Date: 2019/12/12 13:33
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val){
        //如果head开始head.val == val
        while (head != null && head.val == val){
//            ListNode delNode = head;
//            head = head.next;
//            delNode.next = null;
            head = head.next;
        }

        //此时判断，head是否为空，如果为空，则返回null
        if (head == null)
            return null;

        //判断链表开始之后的部分
        ListNode prev = head;
        while (prev.next != null){
            if (prev.next.val == val){
//                ListNode delNode = prev.next;
//                prev.next = delNode.next;
//                delNode.next = null;
                prev.next = prev.next.next;
            }else {
                prev = prev.next;
            }
        }
        return head;
    }
}
