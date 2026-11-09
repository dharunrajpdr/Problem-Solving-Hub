class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        // Available servers
        TreeSet<Integer> available = new TreeSet<>();
        for (int i = 0; i < k; i++) {
            available.add(i);
        }
        // Busy servers: [finishTime, serverIndex]
        PriorityQueue<int[]> busy = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );
        // Number of requests handled by each server
        int[] count = new int[k];
        for (int i = 0; i < arrival.length; i++) {
            // Release servers whose requests have finished
            while (!busy.isEmpty() && busy.peek()[0] <= arrival[i]) {
                int[] server = busy.poll();
                available.add(server[1]);
            }
            // If all servers are busy, drop the request
            if (available.isEmpty()) {
                continue;
            }
            // Preferred server
            int target = i % k;
            // Find the next available server
            Integer server = available.ceiling(target);
            // Wrap around to the smallest available server
            if (server == null) {
                server = available.first();
            }
            // Assign request to the selected server
            available.remove(server);
            count[server]++;
            // Calculate request completion time
            busy.offer(new int[]{
                arrival[i] + load[i], server
            });
        }
        // Find maximum number of requests handled
        int max = 0;
        for (int c : count) {
            max = Math.max(max, c);
        }
        // Collect all busiest servers
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (count[i] == max) {
                result.add(i);
            }
        }
        return result;
    }
}
