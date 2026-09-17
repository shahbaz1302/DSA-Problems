class Triplet{
    int row;
    int col;
    int time;
    Triplet(int row,int col,int time){
        this.row=row;
        this.col=col;
        this.time=time;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        Queue<Triplet> q=new LinkedList<>();
        int[][] visited=new int[n][m];
        int cntFresh=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.offer(new Triplet(i,j,0));
                    visited[i][j]=2;
                }
                else visited[i][j]=0;
                if(grid[i][j]==1) cntFresh++;
            }
        }
        int time=0;
        int[] delRow={-1,0,+1,0};
        int[] delCol={0,+1,0,-1};
        int cnt=0;
        while(!q.isEmpty()){
            int r=q.peek().row;
            int c=q.peek().col;
            int t=q.peek().time;
            time=Math.max(time,t);
            q.poll();
            for(int i=0;i<4;i++){
                int newR=r+delRow[i];
                int newC=c+delCol[i];
                if(newR>=0 && newR<n && newC>=0 && newC<m && visited[newR][newC]==0 && grid[newR][newC]==1){
                    q.offer(new Triplet(newR,newC,t+1));
                    visited[newR][newC]=2;
                    cnt++;
                }
            }
        }
        if(cnt!=cntFresh) return -1;
        return time;
    }
}