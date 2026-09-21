class Solution {
    public boolean isBipartite(int[][] graph) {
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < graph.length; i++) {
            adj.add(new ArrayList<>());

            for (int node : graph[i]) {
                adj.get(i).add(node);
            }
        }
        int[] color = new int[graph.length];
        Arrays.fill(color, -1);
        for (int i = 0; i < graph.length; i++) {
            if (color[i] == -1) {
                if(check(i,adj,color)==false) return false;
            }
        }
        return true;
    }

    private boolean check(int start, List<List<Integer>> adj, int[] color) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        color[start] = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for(int it : adj.get(node)) {
                if(color[it] == -1) {
                    color[it] = 1-color[node];
                    queue.add(it);
                }
                else if(color[it] == color[node]) return false;
            }
        }
        return true;
    }
}