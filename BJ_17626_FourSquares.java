import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_17626_FourSquares {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];
        dp[1] = 1;

        for(int i=2;i<=N;i++){
            int min = Integer.MAX_VALUE;

            for(int j=1;j*j<=i;j++){
                if(j*j == i) {
                    min = 1;
                    break;
                }
                min = Math.min(min, dp[j*j]+dp[i-(j*j)]);
            }
            dp[i] = min;
        }

        System.out.println(dp[N]);
    }
}
