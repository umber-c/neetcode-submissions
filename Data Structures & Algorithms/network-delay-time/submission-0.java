
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        Map<Integer, List<int[]>> adj = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            adj.put(i, new ArrayList<>());
        }

        for (int[] time : times) {
            int s = time[0];
            int d = time[1];
            int w = time[2];

            adj.get(s).add(new int[]{d, w});
        }

        Map<Integer, Integer> shortest = new HashMap<>();

        Queue<int[]> minHeap =
            new PriorityQueue<>((a, b) ->
                Integer.compare(a[0], b[0]));

        minHeap.add(new int[]{0, k});

        while (!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();

            int dist = curr[0];
            int node = curr[1];

            if (shortest.containsKey(node)) {
                continue;
            }

            shortest.put(node, dist);

            for (int[] edge : adj.get(node)) {
                int neighbor = edge[0];
                int weight = edge[1];

                if (!shortest.containsKey(neighbor)) {
                    minHeap.add(
                        new int[]{dist + weight, neighbor}
                    );
                }
            }
        }

        if (shortest.size() != n) {
            return -1;
        }

        int maxTime = 0;

        for (int dist : shortest.values()) {
            maxTime = Math.max(maxTime, dist);
        }

        return maxTime;
    }
}
