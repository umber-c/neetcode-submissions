class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num: nums){
            if (map.containsKey(num)){
                int oldCount = map.get(num);
                map.put(num, oldCount + 1);
            }
            else {
                map.put(num, 1);
            }
        }

        PriorityQueue<Integer> maxheap = new PriorityQueue<>
        ((a,b) -> map.get(b) - map.get(a));

        for (int key : map.keySet()) {
            maxheap.add(key);
        }

        int[] result = new int[k];

        for (int i = 0; i < k; i++){
            result[i] = maxheap.poll();
        }

        return result;




        
    }
}
