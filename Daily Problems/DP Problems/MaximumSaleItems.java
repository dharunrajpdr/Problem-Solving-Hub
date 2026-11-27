class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;

        int minPrice = Integer.MAX_VALUE;

        // Step 1: Find the minimum item price
        for (int i = 0; i < n; i++) {
            minPrice = Math.min(minPrice, items[i][1]);
        }

        // Step 2: Calculate the benefit of each item
        int[] weight = new int[n];

        for (int i = 0; i < n; i++) {
            weight[i] = 1;

            for (int j = 0; j < n; j++) {
                if (i != j && items[j][0] % items[i][0] == 0) {
                    weight[i]++;
                }
            }
        }

        // Step 3: 0/1 Knapsack DP
        int[] dp = new int[budget + 1];

        for (int i = 0; i < n; i++) {
            int price = items[i][1];

            for (int j = budget; j >= price; j--) {
                dp[j] = Math.max(dp[j],
                                 dp[j - price] + weight[i]);
            }
        }

        // Step 4: Buy additional copies using remaining budget
        int ans = 0;

        for (int i = 0; i <= budget; i++) {
            int remainingBudget = budget - i;

            int extraItems = remainingBudget / minPrice;

            ans = Math.max(ans, dp[i] + extraItems);
        }

        return ans;
    }
}
