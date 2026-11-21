class Solution {
    private int timer=0;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for(List<Integer> conn : connections){
            int u=conn.get(0);
            int v=conn.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int[] visited = new int[n];
        int[] tin=new int[n];
        int[] low=new int[n];
        List<List<Integer>> bridges = new ArrayList<>();
        dfs(0,-1,visited,adj,tin,low,bridges);
        return bridges;
    }

    private void dfs(int node, int parent, int[] visited,List<List<Integer>> adj, int[] tin, int[] low, List<List<Integer>> bridges) {
        visited[node]=1;
        tin[node]=low[node]=timer;
        timer++;
        for(Integer it:adj.get(node)){
            if(it==parent) continue;
            if(visited[it]==0){
                dfs(it,node,visited,adj,tin,low,bridges);
                low[node]=Math.min(low[node],low[it]);
                if(low[it]>tin[node]){
                    bridges.add(Arrays.asList(it,node));
                }
            }
            else{
                low[node]=Math.min(low[node],low[it]);
            }
        }
    }
}