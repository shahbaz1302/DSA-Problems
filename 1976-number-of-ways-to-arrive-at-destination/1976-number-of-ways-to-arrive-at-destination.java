class Solution {
    public int countPaths(int n, int[][] roads) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int w = road[2];
            adj.get(u).add(new int[] { v, w });
            adj.get(v).add(new int[] { u, w });
        }
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
        long[] distance = new long[n];
        int[] ways = new int[n];
        Arrays.fill(distance, Long.MAX_VALUE);
        Arrays.fill(ways, 0);
        distance[0] = 0;
        ways[0] = 1;
        int mod = (int) (1e9 + 7);
        pq.offer(new long[] { 0, 0 });
        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            long dist = cur[0];
            int node = (int)cur[1];
            for (int[] neighbor : adj.get(node)) {
                int nextNode = neighbor[0];
                long weight = neighbor[1];
                if (dist + weight < distance[nextNode]) {
                    distance[nextNode] = dist + weight;
                    pq.offer(new long[] { dist + weight, nextNode });
                    ways[nextNode] = ways[node];
                } else if (dist + weight == distance[nextNode]) {
                    ways[nextNode] = (ways[nextNode] + ways[node]) % mod;
                }
            }
        }
        return ways[n - 1] % mod;
    }
}