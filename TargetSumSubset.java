package _23_DynamicProgramming;

public class TargetSumSubset {
    public static boolean targetsumsubset(int arr[], int sum) {
        int n = arr.length;
        boolean dp[][] = new boolean[n + 1][sum + 1];

        // Initialization
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;  // sum = 0 is always possible (empty subset)
        }

        // Fill DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <sum+1; j++) {
                int v=arr[i-1];
                if(v<=j && dp[i-1][j-v]==true){
                    dp[i][j]=true;
                }
                else if(dp[i-1][j]==true){
                    dp[i][j]=true;
                }

            }
        }

        return dp[n][sum];
    }
    public static void print(boolean dp[][]){
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int arr[] = {4, 2, 7, 1, 3};
        int sum = 10;

        System.out.println(targetsumsubset(arr, sum));
    }
}
