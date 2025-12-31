package _23_DynamicProgramming;
import java.util.Arrays;
import java.lang.reflect.Array;

public class Matrixchainmultipication {

    // Recursive solution
    public static int mcm(int arr[], int i, int j){
        // Base case: single matrix
        if(i == j){
            return 0;
        }

        int ans = Integer.MAX_VALUE;

        // Place parenthesis at different positions between i and j
        for(int k = i; k <= j-1; k++){
            int cost1 = mcm(arr, i, k);       // left side
            int cost2 = mcm(arr, k+1, j);     // right side
            int cost3 = arr[i-1] * arr[k] * arr[j]; // cost of multiplying results

            int finalCost = cost1 + cost2 + cost3;

            ans = Math.min(ans, finalCost);
        }
        return ans;
    }

     public static int mcmMem(int arr[], int i, int j, int dp[][]){
        if(i == j){
            return 0;
        }

        if(dp[i][j] != -1){   // already computed
            return dp[i][j];
        }

        int ans = Integer.MAX_VALUE;

        for(int k = i; k <= j-1; k++){
            int cost1 = mcmMem(arr, i, k, dp);
            int cost2 = mcmMem(arr, k+1, j, dp);
            int cost3 = arr[i-1] * arr[k] * arr[j];

            int finalCost = cost1 + cost2 + cost3;

            ans = Math.min(ans, finalCost);
        }

        return dp[i][j] = ans;
    }

    public static int mcmtab(int arr[]) {
    int n = arr.length;
    int dp[][] = new int[n][n];

    // dp[i][i] = 0 (cost of single matrix)
    for (int i = 1; i < n; i++) {
        dp[i][i] = 0;
    }

    // len = chain length
    for (int len = 2; len < n; len++) {
        for (int i = 1; i <= n - len; i++) {
            int j = i + len - 1;
            dp[i][j] = Integer.MAX_VALUE;

            for (int k = i; k <= j - 1; k++) {
                int cost = dp[i][k] + dp[k + 1][j] + arr[i - 1] * arr[k] * arr[j];
                dp[i][j] = Math.min(dp[i][j], cost);
            }
        }
    }

    return dp[1][n - 1];
}

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 3};
        int n = arr.length;
        int dp[][]=new int[n][n];
        System.out.println("Minimum cost of Matrix Chain Multiplication: " + mcm(arr, 1, n-1));
        for(int i=0; i<n; i++){
               Arrays.fill(dp[i],-1);
        }
        System.out.println(mcmMem(arr, 1, n-1, dp));

        System.out.println(mcmtab(arr));

    }
}
