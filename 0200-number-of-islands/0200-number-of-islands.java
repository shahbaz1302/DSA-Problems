class Pair {
    int row;
    int col;

    public Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    count++;
                    bfs(i, j, visited, grid);
                }
            }
        }
        return count;
    }

    public void bfs(int row, int col, boolean[][] visited, char[][] grid) {
        visited[row][col] = true;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(row, col));
        int n = grid.length;
        int m = grid[0].length;
        int[] delRow = { -1, 0, 1, 0 };
        int[] delCol = { 0, 1, 0, -1 };
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            int i = pair.row;
            int j = pair.col;
            for (int k = 0; k < 4; k++) {
                int neighbourRow = i + delRow[k];
                int neighbourCol = j + delCol[k];
                if (neighbourRow >= 0 && neighbourRow < n && neighbourCol >= 0 && neighbourCol < m &&
                        grid[neighbourRow][neighbourCol] == '1' && !visited[neighbourRow][neighbourCol]) {
                    visited[neighbourRow][neighbourCol] = true;
                    queue.add(new Pair(neighbourRow, neighbourCol));
                }
            }
        }
    }
}