class Solution {
    public int findCircleNum(int[][] isConnected) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < isConnected.length; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected.length; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        int[] visited = new int[isConnected.length];
        int count = 0;
        for (int i = 0; i < isConnected.length; i++) {
            if (visited[i] == 0) {
                count++;
                dfs(i, adj, visited);
            }
        }
        return count;
    }

    public void dfs(int i, List<List<Integer>> adj, int[] visited) {
        visited[i] = 1;
        for (Integer it : adj.get(i)) {
            if (visited[it] == 0) dfs(it, adj, visited);
        }
    }
}