class Solution {
    TreeMap<Integer, Integer> left = new TreeMap<>();
    TreeMap<Integer, Integer> right = new TreeMap<>();
    int leftSize = 0, rightSize = 0;
    long leftSum = 0, rightSum = 0;
    void add(TreeMap<Integer, Integer> map, int val) {
        map.put(val, map.getOrDefault(val, 0) + 1);
    }
    void remove(TreeMap<Integer, Integer> map, int val) {
        int count = map.get(val);
        if (count == 1) {
            map.remove(val);
        } else {
            map.put(val, count - 1);
        }
    }

    void insert(int val) {
        if (left.isEmpty() || val <= left.lastKey()) {
            add(left, val);
            leftSize++;
            leftSum += val;
        } else {
            add(right, val);
            rightSize++;
            rightSum += val;
        }
        balance();
    }

    void erase(int val) {
        if (left.containsKey(val)) {
            remove(left, val);
            leftSize--;
            leftSum -= val;
        } else {
            remove(right, val);
            rightSize--;
            rightSum -= val;
        }
        balance();
    }

    void balance() {
        while (leftSize > rightSize + 1) {
            int val = left.lastKey();
            remove(left, val);
            leftSize--;
            leftSum -= val;
            add(right, val);
            rightSize++;
            rightSum += val;
        }

        while (leftSize < rightSize) {
            int val = right.firstKey();
            remove(right, val);
            rightSize--;
            rightSum -= val;
            add(left, val);
            leftSize++;
            leftSum += val;
        }
    }
    long getCost() {
        long median = left.lastKey();
        long leftCost = median * leftSize - leftSum;
        long rightCost = rightSum - median * rightSize;
        return leftCost + rightCost;
    }

    public long minOperations(int[] nums, int x, int k) {
        int n = nums.length;
        // Step 1: Calculate cost of every window of size x
        long[] cost = new long[n - x + 1];
        for (int i = 0; i < n; i++) {
            insert(nums[i]);
            if (i >= x) {
                erase(nums[i - x]);
            }
            if (i >= x - 1) {
                cost[i - x + 1] = getCost();
            }
        }
        // Step 2: DP
        long INF = Long.MAX_VALUE / 2;
        long[] prev = new long[n + 1];
        long[] curr = new long[n + 1];
        Arrays.fill(prev, INF);
        // Selecting zero subarrays requires zero operations
        Arrays.fill(prev, 0);
        for (int j = 1; j <= k; j++) {
            Arrays.fill(curr, INF);
            for (int i = 1; i <= n; i++) {
                // Choice 1: Skip current element
                curr[i] = curr[i - 1];
                // Choice 2: Select a window ending at i - 1
                if (i >= x && prev[i - x] != INF) {
                    curr[i] = Math.min(
                        curr[i],
                        prev[i - x] + cost[i - x]
                    );
                }
            }
            prev = curr;
            curr = new long[n + 1];
        }
        return prev[n];
    }
}
