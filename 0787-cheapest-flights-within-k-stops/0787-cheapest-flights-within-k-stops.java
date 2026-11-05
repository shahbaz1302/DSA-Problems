class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for (int[] flight : flights) {
            int from = flight[0];
            int to = flight[1];
            int cost = flight[2];
            adj.get(from).add(new int[] { to, cost });
        }
        Queue<Triplet> q = new LinkedList<>();
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;
        q.offer(new Triplet(0, src, 0));
        while (!q.isEmpty()) {
            Triplet t = q.poll();
            int stops = t.stops;
            int node = t.node;
            int dist = t.dist;
            if (stops > k)
                continue;
            for (int[] neighbor : adj.get(node)) {
                int nextNode = neighbor[0];
                int cost = neighbor[1];
                if (dist + cost < distance[nextNode] && stops <= k) {
                    distance[nextNode] = dist + cost;
                    q.offer(new Triplet(stops + 1, nextNode, dist + cost));
                }
            }
        }
        if (distance[dst] == Integer.MAX_VALUE)
            return -1;
        return distance[dst];
    }
}

class Triplet {
    int stops;
    int node;
    int dist;

    Triplet(int stops, int node, int dist) {
        this.stops = stops;
        this.node = node;
        this.dist = dist;
    }
}