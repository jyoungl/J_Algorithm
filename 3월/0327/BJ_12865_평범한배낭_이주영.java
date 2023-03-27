package mar27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BJ_12865_평범한배낭_이주영 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N+1][2]; //무게, 가치
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        //무게 k 제한일 때, 넣을 수 있는 최대가치 저장
        int[][] dp = new int[N + 1][K + 1];
        for (int k = 1; k <= K; k++) { //무게
            for (int i = 1; i <= N; i++) { // 물건
                dp[i][k] = dp[i - 1][k];
                if (k - arr[i][0] >= 0) {
                    dp[i][k] = Math.max(dp[i - 1][k], arr[i][1] + dp[i - 1][k - arr[i][0]]);
                }
            }
        }

        System.out.println(dp[N][K]);
    }
}
