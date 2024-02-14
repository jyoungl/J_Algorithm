import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_14728_벼락치기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N =Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N+1][2]; //공부시간, 배점
        for(int i=1;i<=N;i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        int[][] dp = new int[N+1][T+1]; //과목 수 N, 시간T 이내일 때 최대 점수
        for(int t=1;t<=T;t++){
            for(int i=1;i<=N;i++){ //과목 개수
                dp[i][t] = dp[i-1][t];
                if(t - arr[i][0] >=0){
                    dp[i][t] = Math.max(dp[i-1][t], arr[i][1]+dp[i-1][t-arr[i][0]]);
                }
            }
        }
         System.out.println(dp[N][T]);
    }
}
