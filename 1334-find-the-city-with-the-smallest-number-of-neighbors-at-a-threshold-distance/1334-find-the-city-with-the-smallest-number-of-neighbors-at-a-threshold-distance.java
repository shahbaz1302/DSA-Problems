class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] distance=new int[n][n];
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                distance[i][j]=Integer.MAX_VALUE;
            }
        }
        for(int[] edge:edges) {
            int u=edge[0];
            int v=edge[1];
            int weight=edge[2];
            distance[u][v]=weight;
            distance[v][u]=weight;
        }
        for(int i=0;i<n;i++) distance[i][i]=0;
        for(int k=0;k<n;k++) {
            for(int i=0;i<n;i++) {
                for(int j=0;j<n;j++) {
                    if(distance[i][k]==Integer.MAX_VALUE || distance[k][j]==Integer.MAX_VALUE) continue;
                    distance[i][j]=Math.min(distance[i][j],distance[i][k]+distance[k][j]);
                }
            }
        }
        int cntCity=n;
        int city=-1;
        for(int i=0;i<n;i++) {
            int count=0;
            for(int j=0;j<n;j++) {
                if(distance[i][j]<=distanceThreshold) count++;
            }
            if(count<=cntCity){
                cntCity=count;
                city=i;
            }
        }
        return city;
    }
}