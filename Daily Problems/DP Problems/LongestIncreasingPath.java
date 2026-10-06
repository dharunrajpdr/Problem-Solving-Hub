class Solution {

    int[][] dp;
    int n, m;

    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};

    public int longIncPath(int[][] matrix, int n, int m) {

        this.n = n;
        this.m = m;

        dp = new int[n][m];

        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans = Math.max(ans, dfs(i, j, matrix));
            }
        }

        return ans;
    }

    private int dfs(int r, int c, int[][] matrix) {

        // Already calculated
        if (dp[r][c] != 0) {
            return dp[r][c];
        }

        // Current cell itself
        int max = 1;

        // Check 4 directions
        for (int k = 0; k < 4; k++) {

            int nr = r + dr[k];
            int nc = c + dc[k];

            // Check boundary
            if (nr >= 0 && nr < n && nc >= 0 && nc < m) {

                // Move only to a greater value
                if (matrix[nr][nc] > matrix[r][c]) {

                    max = Math.max(
                        max,
                        1 + dfs(nr, nc, matrix)
                    );
                }
            }
        }

        dp[r][c] = max;

        return max;
    }
}
