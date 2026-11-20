
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++)
            adj.add(new ArrayList<>());

        for (int[] p : prerequisites) {
            adj.get(p[1]).add(p[0]);
            indegree[p[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < numCourses; i++)
            if (indegree[i] == 0)
                q.offer(i);

        int[] ans = new int[numCourses];
        int index = 0;

        while (!q.isEmpty()) {
            int node = q.poll();
            ans[index++] = node;

            for (int next : adj.get(node)) {
                indegree[next]--;
                if (indegree[next] == 0)
                    q.offer(next);
            }
        }

        return index == numCourses ? ans : new int[0];
    }
}
