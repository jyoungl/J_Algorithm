import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class BJ_2302_극장좌석 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<Integer> set = new HashSet<>();
        int N = Integer.parseInt(br.readLine());
        int fix = Integer.parseInt(br.readLine());
        for(int i=0;i<fix;i++) {
            int x = Integer.parseInt(br.readLine());
            set.add(x);
            set.add(x+1);
        }
        int[][] dp = new int[N+1][2];
        dp[1][0] = 1;
        dp[1][1] = 0;

        for(int i=2;i<=N;i++){
            dp[i][0] = dp[i-1][0] + dp[i-1][1];
            if(set.contains(i)){
                dp[i][1] = 0;
            }
            else
                dp[i][1] = dp[i-1][0];
        }
        System.out.println(dp[N][0] + dp[N][1]);
    }
}
