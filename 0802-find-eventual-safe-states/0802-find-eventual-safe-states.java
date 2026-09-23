class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;
        int[] visited=new int[n];
        int[] pathVisited=new int[n];
        int[] check=new int[n];
        for(int i=0;i<n;i++){
            if(visited[i]==0){
                dfs(i,graph,visited,pathVisited,check);
            }
        }
        List<Integer> safeNodes=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(check[i]==1) safeNodes.add(i);
        }
        return safeNodes;
    }

    public boolean dfs(int node,int[][] graph,int[] visited,int[] pathVisited,int[] check){
        visited[node]=1;
        pathVisited[node]=1;
        for(int it:graph[node]){
            if(visited[it]==0){
                if(dfs(it,graph,visited,pathVisited,check)) return true;
            }
            else if(pathVisited[it]==1) return true;
        }
        check[node]=1;
        pathVisited[node]=0;
        return false;
    }
}