/**
 * @Author: cc
 * @Date: 2019/12/12 17:04
 */
public class DebugSolution4 {

    /**
     * 使用递归解决
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val, int depth) {
        String depthString = generateDepthString(depth);

        System.out.print(depthString);
        System.out.println("Call: remove " + val + " in " + head);

        //求解最基本问题
        if (head == null){
            System.out.print(depthString);
            System.out.println("Return: "+head);
            return head;
        }

        //把原问题转化为更小的问题
        ListNode res = removeElements(head.next, val, depth + 1);
        System.out.print(depthString);
        System.out.println("After remove "+ val+": "+res);

        ListNode ret;
        if(head.val == val){
            ret = res;
        }else {
            head.next = res;
            ret = head;
        }

        System.out.print(depthString);
        System.out.println("Return: "+ret);

        return ret;
    }

    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("--");
        }
        return res.toString();
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 6, 3, 4, 5, 6};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode listNode = new DebugSolution4().removeElements(head, 6, 0);
        System.out.println(listNode);
    }
}
