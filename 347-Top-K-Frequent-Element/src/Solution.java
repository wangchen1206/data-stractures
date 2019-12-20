import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;


class Solution {


    public List<Integer> topKFrequent(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            if (map.containsKey(num))
                map.put(num, map.get(num) + 1);
            else
                map.put(num, 1);
        }
        //用lambda实现优先队列的比较器
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(
                (a,b)->map.get(a) - map.get(b)
        );
        for (int key : map.keySet()) {
            if (priorityQueue.size() < k)
                priorityQueue.add(key);
            else if (map.get(key) > map.get(priorityQueue.peek())) {
                priorityQueue.remove();
                priorityQueue.add(key);
            }
        }
        LinkedList<Integer> linkedList = new LinkedList<>();
        while (!priorityQueue.isEmpty())
            linkedList.add(priorityQueue.remove());
        return linkedList;
    }
}