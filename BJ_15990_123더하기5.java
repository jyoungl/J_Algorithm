import java.util.Scanner;

public class BJ_15990_123더하기5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T= in.nextInt();
        int[] tcase = new int[T];
        int max = 0;
        for(int i=0;i<T;i++){
            tcase[i] = in.nextInt();
            max = Math.max(max, tcase[i]);
        }

        long[][] dp = new long[max+1][4];
        dp[1][1] = dp[2][2] = dp[3][1] = dp[3][2] = dp[3][3] = 1;
        for(int i=4;i<=max;i++){
            dp[i][1] = (dp[i-1][2] + dp[i-1][3])%1000000009;
            dp[i][2] = (dp[i-2][1] + dp[i-2][3])%1000000009;
            dp[i][3] = (dp[i-3][1] + dp[i-3][2])%1000000009;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<T;i++){
            sb.append((dp[tcase[i]][1] +dp[tcase[i]][2] + dp[tcase[i]][3])%1000000009).append("\n");
        }
        System.out.println(sb);
    }
}
