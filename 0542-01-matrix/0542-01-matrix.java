class Node {
    int row;
    int col;
    int dist;

    Node(int row, int col, int dist) {
        this.row = row;
        this.col = col;
        this.dist = dist;
    }
}

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] visited = new int[n][m];
        int[][] distance = new int[n][m];
        Queue<Node> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(mat[i][j] == 0){
                    queue.add(new Node(i, j, 0));
                    visited[i][j] = 1;
                }
                else visited[i][j] = 0;
            }
        }
        int[] delRow={-1,0,+1,0};
        int[] delCol={0,+1,0,-1};
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int row = node.row;
            int col = node.col;
            int dist = node.dist;
            distance[row][col] = dist;
            for (int i = 0; i < 4; i++) {
                int newRow = row + delRow[i];
                int newCol = col + delCol[i];
                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && visited[newRow][newCol] == 0) {
                    visited[newRow][newCol] = 1;
                    queue.add(new Node(newRow, newCol, dist + 1));
                }
            }
        }
        return distance;
    }
}