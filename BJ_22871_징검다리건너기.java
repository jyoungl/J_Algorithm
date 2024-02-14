import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_22871_징검다리건너기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Long[] arr = new Long[N+1];

        for(int i=1;i<=N;i++){
            arr[i] = Long.parseLong(st.nextToken());
        }

        long[] dp = new long[N+1];
        dp[N] = Long.MIN_VALUE;

        for(int i=N-1;i>=1;i--){
            dp[i] = Long.MAX_VALUE;
            for(int j=1;j<=N;j++){
                if(j<=i) continue;
                dp[i] = Math.min(dp[i], Math.max(((i-j)*(1+Math.abs(arr[i]-arr[j]))), dp[j]));
            }
        }

        System.out.println(dp[1]);
    }
}