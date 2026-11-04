class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n=heights.length;
        int m=heights[0].length;
        PriorityQueue<Triplet> pq=new PriorityQueue<>((x,y)->x.dist-y.dist);
        int[][] distance=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++) distance[i][j]=Integer.MAX_VALUE;
        }
        distance[0][0]=0;
        pq.offer(new Triplet(0,0,0));
        int[] delRow={-1,0,+1,0};
        int[] delCol={0,+1,0,-1};
        while(!pq.isEmpty()){
            Triplet t=pq.poll();
            int diff=t.dist;
            int row=t.row;
            int col=t.col;
            if(row==n-1 && col==m-1) return diff;
            for(int i=0;i<4;i++){
                int newRow=row+delRow[i];
                int newCol=col+delCol[i];
                if(newRow>=0 && newRow<n && newCol>=0 && newCol<m){
                    int newEffort=Math.max(Math.abs(heights[row][col]-heights[newRow][newCol]),diff);
                    if(newEffort<distance[newRow][newCol]){
                        distance[newRow][newCol]=newEffort;
                        pq.offer(new Triplet(newEffort,newRow, newCol));
                    }
                }
            }
        }
        return 0;
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