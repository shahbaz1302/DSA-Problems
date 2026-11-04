class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;
        if(grid[0][0]!=0 || grid[n-1][n-1]!=0) return -1;
        Queue<Triplet> q = new LinkedList<>();
        int[][] distance=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++) distance[i][j]=Integer.MAX_VALUE;
        }
        distance[0][0]=0;
        q.offer(new Triplet(0,0,0));
        int[] delRow={-1,-1,0,+1,+1,+1,0,-1};
        int[] delCol={0,+1,+1,+1,0,-1,-1,-1};
        while(!q.isEmpty()){
            Triplet t=q.poll();
            int dist=t.dist;
            int row=t.row;
            int col=t.col;
            if(row==n-1 && col==n-1) return dist+1;
            for(int i=0;i<8;i++){
                int nextRow=row+delRow[i];
                int nextCol=col+delCol[i];
                if(nextRow>=0 && nextRow<n && nextCol>=0 && nextCol<n && grid[nextRow][nextCol]==0
                        && dist+1<distance[nextRow][nextCol]){
                    distance[nextRow][nextCol]=dist+1;
                    q.offer(new Triplet(1+dist,nextRow,nextCol));
                }
            }
        }
        return -1;
    }
}

class Triplet {
    int dist;
    int row;
    int col;

    Triplet(int dist, int row, int col) {
        this.dist = dist;
        this.row = row;
        this.col = col;
    }
}