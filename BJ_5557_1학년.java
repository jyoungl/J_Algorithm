import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_5557_1학년 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N+1];
        long[][] dp = new long[N+1][21];

        for(int i=1;i<=N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[1][arr[1]]++;

        for(int i=2;i<N;i++){
            for(int j=0;j<=20;j++){
                int sum1=0, sum2=0;

                if(dp[i-1][j]>=1) {
                    sum1 = j + arr[i];
                    sum2 = j - arr[i];

                    if (sum1 <= 20)
                        dp[i][sum1] += dp[i - 1][j];
                    if (sum2 >= 0)
                        dp[i][sum2] += dp[i - 1][j];
                }
            }
        }
        System.out.println(dp[N-1][arr[N]]);
    }
}
