package _23_DynamicProgramming;

public class RodCutting {
    public static int RodCutting(int length[], int price[], int totalrod) {
        int n = length.length;
        int dp[][] = new int[n + 1][totalrod + 1];

        // Base case initialization (0 length or 0 rod size = 0 profit)
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= totalrod; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }

        // DP filling
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= totalrod; j++) {
                if (length[i - 1] <= j) {
                    // include (stay at i, since we can reuse) OR exclude
                    dp[i][j] = Math.max(price[i - 1] + dp[i][j - length[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][totalrod];
    }

    public static void main(String[] args) {
        int length[] = {1, 2, 3, 4, 5, 6, 7, 8};
        int price[] = {1, 5, 8, 9, 10, 17, 17, 20};
        int totalrod = 8;

        System.out.println(RodCutting(length, price, totalrod)); // ✅ Output = 22
    }
}
