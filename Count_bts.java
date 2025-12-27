package _23_DynamicProgramming;

public class Count_bts {
    
    public static int countbst(int n){
        int dp[] = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2; i <= n; i++){
            for(int j = 0; j < i; j++){
                int left=dp[j];
                int right=dp[i-j-1];
                dp[i] += dp[j] * dp[i-j-1];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println("Number of BSTs with " + n + " nodes: " + countbst(n));
    }
}
