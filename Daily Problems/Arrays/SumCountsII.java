class Solution {
    int n;
    static final int MOD = 1_000_000_007;

    long[] sum, sq, lazy;

    public int sumCounts(int[] nums) {
        n = nums.length;

        sum = new long[4 * n];
        sq = new long[4 * n];
        lazy = new long[4 * n];

        int[] last = new int[100001];
        long ans = 0;

        for (int i = 0; i < n; i++) {
            int left = last[nums[i]];
            int right = i;

            update(left, right, 1, 0, n - 1, 1);

            ans = (ans + sq[1]) % MOD;

            last[nums[i]] = i + 1;
        }

        return (int) ans;
    }

    private void update(int ql, int qr, int val,
                        int start, int end, int node) {
        if (ql > end || qr < start) {
            return;
        }

        if (ql <= start && end <= qr) {
            apply(node, start, end, val);
            return;
        }

        push(node, start, end);

        int mid = start + (end - start) / 2;

        update(ql, qr, val, start, mid, node * 2);
        update(ql, qr, val, mid + 1, end, node * 2 + 1);

        sum[node] = (sum[node * 2] + sum[node * 2 + 1]) % MOD;
        sq[node] = (sq[node * 2] + sq[node * 2 + 1]) % MOD;
    }

    private void apply(int node, int start, int end, int val) {
        long len = end - start + 1L;

        sq[node] = (sq[node]
                + 2L * val % MOD * sum[node] % MOD
                + len * val % MOD * val % MOD) % MOD;

        sum[node] = (sum[node] + len * val) % MOD;

        lazy[node] = (lazy[node] + val) % MOD;
    }

    private void push(int node, int start, int end) {
        if (lazy[node] == 0 || start == end) {
            return;
        }

        int mid = start + (end - start) / 2;

        apply(node * 2, start, mid, (int) lazy[node]);
        apply(node * 2 + 1, mid + 1, end, (int) lazy[node]);

        lazy[node] = 0;
    }
}
