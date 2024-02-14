import java.util.Scanner;

public class BJ_2225_합분해 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        long [][] dp = new long[M+1][N+1];

        for(int i=0;i<=N;i++)
            dp[1][i] = 1;

        for(int i=2;i<M;i++){
            for(int j=0;j<=N;j++){
                for(int z=0;z<=j;z++) {
                    dp[i][j] = (dp[i][j]+dp[i - 1][z])%1000000000;
                }
            }
        }

        for(int i=0;i<=N;i++)
            dp[M][N] = (dp[M][N]+dp[M-1][i])%1000000000;

        System.out.println(dp[M][N]);
    }
}
