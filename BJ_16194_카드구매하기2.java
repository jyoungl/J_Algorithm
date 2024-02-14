import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_16194_카드구매하기2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] card = new int[N+1];
        for(int i=1;i<=N;i++)
            card[i] = Integer.parseInt(st.nextToken());

        int[] dp = new int[1001];
        dp[1] = card[1];
        dp[2] = Math.min(card[2], dp[1]+dp[1]);

        for(int i=3;i<=N;i++){
            dp[i] = card[i];
            for(int j=i-1;j>i/2;j--){
                dp[i] = Math.min(dp[i], dp[j]+dp[i-j]);
            }
            if(i%2==0)
                dp[i] = Math.min(dp[i], dp[i/2]+dp[i/2]);
        }

        System.out.println(dp[N]);
    }
}
