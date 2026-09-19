class Pair{
    int first;
    int second;
    Pair(int f,int s){
        first=f;
        second=s;
    }
}

class Solution {
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] visited = new int[n][m];
        Queue<Pair> q = new LinkedList<>();
        int[] delRow={-1,0,+1,0};
        int[] delCol={0,+1,0,-1};
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(i==0 || i==n-1 || j==0 || j==m-1) {
                    if(grid[i][j]==1) {
                        visited[i][j]=1;
                        q.add(new Pair(i,j));
                    }
                }
            }
        }
        while(!q.isEmpty()) {
            Pair p = q.poll();
            int row=p.first;
            int col=p.second;
            for(int i=0;i<4;i++) {
                int nextRow=row+delRow[i];
                int nextCol=col+delCol[i];
                if(nextRow>=0 && nextRow<n && nextCol>=0 && nextCol<m && visited[nextRow][nextCol]==0 && grid[nextRow][nextCol]==1) {
                    visited[nextRow][nextCol]=1;
                    q.add(new Pair(nextRow,nextCol));
                }
            }
        }
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(visited[i][j]==0 && grid[i][j]==1) count++;
            }
        }
        return count;
    }
}