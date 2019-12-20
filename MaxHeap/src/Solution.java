import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

/**
 * leetCode 第347题，前k个高频元素
 * https://leetcode-cn.com/problems/top-k-frequent-elements/
 *
 * @Author: cc
 * @Date: 2019/12/20 10:13
 */
class Solution {

    private class Freq implements Comparable<Freq>{
        public int e,freq;

        public Freq(int e, int freq) {
            this.e = e;
            this.freq = freq;
        }

        @Override
        public int compareTo(Freq another) {
            if (this.freq < another.freq)
                return 1;
            else if (this.freq>another.freq)
                return -1;
            else
                return 0;
        }
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for (int num:nums){
            if (map.containsKey(num))
                map.put(num,map.get(num)+1);
            else
                map.put(num,1);
        }

        PriorityQueue<Freq> priorityQueue = new PriorityQueue<>();
        for (int key:map.keySet()){
            if (priorityQueue.getSize()<k)
                priorityQueue.enqueue(new Freq(key,map.get(key)));
            else if (map.get(key)>priorityQueue.getFront().freq){
                priorityQueue.dequeue();
                priorityQueue.enqueue(new Freq(key,map.get(key)));
            }
        }
        LinkedList<Integer> linkedList = new LinkedList<>();
        while (!priorityQueue.isEmpty())
            linkedList.add(priorityQueue.dequeue().e);
        return linkedList;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,1,2,2,3};
        List<Integer> integers = new Solution().topKFrequent(arr, 2);
        System.out.println(integers);
    }
}
