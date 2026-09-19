class Solution {
    public int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());

        for (int stone : stones){
            heap.offer(stone);
        }

        while(heap.size() > 1){
            int y = heap.poll();
            int x = heap.poll();

            if (y > x) {
                heap.offer(y-x);
            }
        }

        if (heap.isEmpty()) {
            return 0;
        }
        return heap.peek();

       
        
    }
}
