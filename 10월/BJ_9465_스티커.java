import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_9465_스티커 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        for(int i=1;i<=T;i++){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int[][] dp= new int[3][100001];
            int[][] arr = new int[3][100001];

            for(int j=1;j<=2;j++){
                st = new StringTokenizer(br.readLine());
                for(int z=1;z<=N;z++)
                    arr[j][z] = Integer.parseInt(st.nextToken());
            }

            dp[1][1] = arr[1][1];
            dp[2][1] = arr[2][1];
            dp[1][2] = dp[2][1] + arr[1][2];
            dp[2][2] = dp[1][1] + arr[2][2];

            for(int j=3;j<=N;j++){
                dp[1][j] = arr[1][j] + Math.max(dp[2][j-1], dp[2][j-2]);
                dp[2][j] = arr[2][j] + Math.max(dp[1][j-1], dp[1][j-2]);
            }

            sb.append(Math.max(dp[1][N], dp[2][N])).append("\n");
        }
        System.out.println(sb);
    }
}
