class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        List<int[]>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            adj[u].add(new int[] { v, w });
        }
        int[][] dist = new int[n][k + 1];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        // {cost, node, consecutiveCount}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        dist[0][1] = 0;
        pq.offer(new int[] { 0, 0, 1 });

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int cost = curr[0];
            int u = curr[1];
            int count = curr[2];
            if (cost != dist[u][count]) {
                continue;
            }
            if (u == n - 1) {
                return cost;
            }
            for (int[] next : adj[u]) {
                int v = next[0];
                int w = next[1];
                int newCount;
                if (labels.charAt(u) == labels.charAt(v)) {
                    newCount = count + 1;
                } else {
                    newCount = 1;
                }
                if (newCount > k) {
                    continue;
                }
                int newCost = cost + w;
                if (newCost < dist[v][newCount]) {
                    dist[v][newCount] = newCost;
                    pq.offer(new int[] { newCost, v, newCount  });
                }
            }
        }
        return -1;
    }
}
