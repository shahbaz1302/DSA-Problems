class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        int[] indegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            for (int item : adj.get(i)) indegree[item]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++){
            if (indegree[i] == 0) q.offer(i);
        }
        int count=0;
        while (!q.isEmpty()){
            int node = q.poll();
            count++;
            for(int item: adj.get(node)){
                indegree[item]--;
                if(indegree[item]==0) q.offer(item);
            }
        }
        return count==numCourses;
    }
}