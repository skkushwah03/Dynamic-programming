package _23_DynamicProgramming;

public class LCS_recursion {
    public static int lcs(String str1, String str2, int n, int m) {
        // Base case
        if (n == 0 || m == 0) {
            return 0;
        }

        // If characters match → include + move both pointers
        if (str1.charAt(n - 1) == str2.charAt(m - 1)) {
            return 1 + lcs(str1, str2, n - 1, m - 1);
        } else {
            // If characters don't match → try both options
            return Math.max(lcs(str1, str2, n - 1, m), lcs(str1, str2, n, m - 1));
        }
    }

    //memorization
    public static int lcs2(String str1,String str2,int n,int m,int dp[][]){
        if (n == 0 || m == 0) {
            return 0;
        }

        if (dp[n][m] != -1) { // already computed
            return dp[n][m];
        }

        if (str1.charAt(n - 1) == str2.charAt(m - 1)) {
            dp[n][m] = 1 + lcs2(str1, str2, n - 1, m - 1, dp);
        } else {
            dp[n][m] = Math.max(lcs2(str1, str2, n - 1, m, dp), lcs2(str1, str2, n, m - 1, dp));
        }

        return dp[n][m];
    }
   
   public static int tabulization(String str1,String str2){
        int n = str1.length();
        int m = str2.length();
        int dp[][] = new int[n + 1][m + 1];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<n+1;j++){
                if (i==0||j==0) {
                    dp[i][j]=0;
                }
            }
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(str1.charAt(i - 1) == str2.charAt(j - 1)){
                dp[i][j] = 1 + dp[i - 1][j - 1];  // characters match
            } else {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);  // characters don't match
            }
            }
        }
        return dp[n][m];

   }
    public static void main(String[] args) {
        String str1 = "abcdge";
        String str2 = "abedg";

        System.out.println("LCS length = " + lcs(str1, str2, str1.length(), str2.length())); 
        // ✅ Output = 4 ("abdg")

        int n=str1.length();
        int m=str2.length();
        int dp[][] = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = -1;
            }
        }

        System.out.println("LCS length (Memoization) = " + lcs2(str1, str2, n, m, dp));
        System.out.println(tabulization(str1, str2));
    }
}
