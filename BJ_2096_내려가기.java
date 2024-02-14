import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2096_내려가기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long[][] max_dp = new long[N][3];
        long[][] min_dp = new long[N][3];
        int[][] arr = new int[N][3];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<3;j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }

        max_dp[0][0] = min_dp[0][0] = arr[0][0];
        max_dp[0][1] = min_dp[0][1] = arr[0][1];
        max_dp[0][2] = min_dp[0][2] = arr[0][2];

        for(int i=1;i<N;i++){
            max_dp[i][0] = arr[i][0] + Math.max(max_dp[i-1][0], max_dp[i-1][1]);
            max_dp[i][1] = arr[i][1] + Math.max(max_dp[i-1][0], Math.max(max_dp[i-1][1], max_dp[i-1][2]));
            max_dp[i][2] = arr[i][2] + Math.max(max_dp[i-1][1], max_dp[i-1][2]);

            min_dp[i][0] = arr[i][0] + Math.min(min_dp[i-1][0], min_dp[i-1][1]);
            min_dp[i][1] = arr[i][1] + Math.min(min_dp[i-1][0], Math.min(min_dp[i-1][1], min_dp[i-1][2]));
            min_dp[i][2] = arr[i][2] + Math.min(min_dp[i-1][1], min_dp[i-1][2]);
        }

        long max_answer = Math.max(max_dp[N-1][2], Math.max(max_dp[N-1][1], max_dp[N-1][0]));
        long min_answer = Math.min(min_dp[N-1][2], Math.min(min_dp[N-1][1], min_dp[N-1][0]));
        System.out.println(max_answer + " " + min_answer);
    }
}
