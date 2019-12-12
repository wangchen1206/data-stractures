/**
 * 使用递归
 *
 * @Author: cc
 * @Date: 2019/12/12 14:54
 */
public class Sum {

    public static int sum(int[] nums) {
        return sum(nums, 0);
    }

    /**
     * 计算nums[left,n)这个区间内所有数字的和
     * 使用递归
     *
     * @param nums
     * @param left
     * @return
     */
    private static int sum(int[] nums, int left) {
        if (left == nums.length)
            return 0;
        return nums[left] + sum(nums, left + 1);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(sum(nums));
    }
}
