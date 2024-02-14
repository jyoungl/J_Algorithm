import java.util.Scanner;

public class BJ_9625_BABBA {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int K = in.nextInt();
        int[][] dp = new int[K+1][2];
        dp[0][0] = 1;

        for(int i=1;i<=K;i++){
            dp[i][0] = dp[i-1][1];
            dp[i][1] = dp[i-1][0] + dp[i-1][1];
        }

        System.out.println(dp[K][0] + " " + dp[K][1]);
    }
}
