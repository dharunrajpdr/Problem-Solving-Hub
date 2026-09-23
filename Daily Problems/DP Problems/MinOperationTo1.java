class Solution {
    int minOperations(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            dp[i] = i - 1; 
            for (int x = 1; x < i; x++) {
                if (i % x == 0) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - x]);
                }
            }
        }
        return dp[n];
    }
}
