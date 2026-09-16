class Solution {
    public int numberOfSets(int n, int k) {

        int MOD = 1000000007;

        int[][] dp = new int[k + 1][n + 1];

        // 0 segments can be made in 1 way
        for (int i = 0; i <= n; i++) {
            dp[0][i] = 1;
        }

        for (int segments = 1; segments <= k; segments++) {

            int[] prevRowSum = new int[n + 1];

            // Suffix sum of dp[segments - 1]
            for (int x = n - 1; x >= 0; x--) {
                prevRowSum[x] =
                    (prevRowSum[x + 1] + dp[segments - 1][x]) % MOD;
            }

            for (int i = n - 1; i >= 0; i--) {

                // Take a segment starting from i
                int take = prevRowSum[i + 1];

                // Skip point i
                int skip = dp[segments][i + 1];

                dp[segments][i] = (take + skip) % MOD;
            }
        }

        return dp[k][0];
    }
}