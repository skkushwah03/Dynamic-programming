package _23_DynamicProgramming;
import java.util.Arrays;

public class Catlannumber {
    
    // Recursive solution
    public static int catlanrec(int n){
        if(n == 0 || n == 1){
            return 1;
        }
        int ans = 0;
        for(int i = 0; i <= n-1; i++){
            ans += catlanrec(i) * catlanrec(n-i-1);
        }
        return ans;
    }

    // Memoization (Top-down DP)
    public static int catalanMem(int n, int dp[]){
        if(n == 0 || n == 1){
            return 1;
        }
        if(dp[n] != -1){
            return dp[n];
        }
        int ans = 0;
        for(int i = 0; i < n; i++){
            ans += catalanMem(i, dp) * catalanMem(n-i-1, dp);
        }
        return dp[n] = ans;
    }

    // Tabulation (Bottom-up DP)
    public static int catalantab(int n){
        int dp[] = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        
        for(int i = 2; i <= n; i++){
            for(int j = 0; j < i; j++){
                dp[i] += dp[j] * dp[i-j-1];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 4;

        // Recursive
        System.out.println("Recursive: " + catlanrec(n));
        
        // Memoization
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);
        System.out.println("Memoization: " + catalanMem(n, dp));
        
        // Tabulation
        System.out.println("Tabulation: " + catalantab(n));
    }
}
