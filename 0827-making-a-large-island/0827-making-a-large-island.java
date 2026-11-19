class Solution {
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        DisjointSet ds = new DisjointSet(n * n);
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 0)
                    continue;
                int[] dr = { -1, 0, +1, 0 };
                int[] dc = { 0, +1, 0, -1 };
                for (int k = 0; k < 4; k++) {
                    int newRow = row + dr[k];
                    int newCol = col + dc[k];
                    if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n && grid[newRow][newCol] == 1) {
                        int nodeNo = row * n + col;
                        int adjNodeNo = newRow * n + newCol;
                        ds.unionBySize(nodeNo, adjNodeNo);
                    }
                }
            }
        }
        int max = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 1)
                    continue;
                int[] dr = { -1, 0, +1, 0 };
                int[] dc = { 0, +1, 0, -1 };
                HashSet<Integer> set = new HashSet<>();
                for (int k = 0; k < 4; k++) {
                    int newRow = row + dr[k];
                    int newCol = col + dc[k];
                    if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n) {
                        if (grid[newRow][newCol] == 1)
                            set.add(ds.findUltimateParent(newRow * n + newCol));
                    }
                }
                int totalSize = 0;
                for (Integer parents : set) {
                    totalSize += ds.size.get(parents);
                }
                max = Math.max(max, totalSize + 1);
            }
        }
        for (int cellNo = 0; cellNo < n * n; cellNo++) {
            max = Math.max(max, ds.size.get(ds.findUltimateParent(cellNo)));
        }
        return max;
    }
}

class DisjointSet{
        List<Integer> parent=new ArrayList<>();
        List<Integer> size=new ArrayList<>();

        public DisjointSet(int n){
            for(int i=0;i<=n;i++){
                parent.add(i);
                size.add(1);
            }
        }

        public int findUltimateParent(int node){
            if(node==parent.get(node)) return node;
            int upar=findUltimateParent(parent.get(node));
            parent.set(node,upar);
            return parent.get(node);
        }

        public void unionBySize(int u,int v){
            int ulp_u=findUltimateParent(u);
            int ulp_v=findUltimateParent(v);
            if(ulp_u==ulp_v) return;
            if(size.get(ulp_u)<size.get(ulp_v)){
                parent.set(ulp_u,ulp_v);
                size.set(ulp_v,size.get(ulp_v)+size.get(ulp_u));
            }
            else{
                parent.set(ulp_v,ulp_u);
                size.set(ulp_u,size.get(ulp_u)+size.get(ulp_v));
            }
        }
    }