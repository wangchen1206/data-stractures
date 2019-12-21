class NumArray {

    private SegmentTree<Integer> segmentTree;

    public NumArray(int[] nums) {
        if (nums.length > 0) {
            Integer[] data = new Integer[nums.length];
            for (int i = 0; i < nums.length; i++) {
                data[i] = nums[i];
            }
            this.segmentTree = new SegmentTree<>(data, (a, b) -> a + b);
        }
    }

    public int sumRange(int i, int j) {
        if (this.segmentTree == null)
            throw new IllegalArgumentException("SegmentTree is null.");
        return this.segmentTree.query(i,j);
    }
}