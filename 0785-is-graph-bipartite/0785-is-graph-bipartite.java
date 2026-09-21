class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);
        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                if(check(i,graph,color)==false) return false;
            }
        }
        return true;
    }

    private boolean check(int start, int[][] graph, int[] color) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        color[start] = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for(int it : graph[node]) {
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