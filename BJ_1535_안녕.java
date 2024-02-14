import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1535_안녕 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[][] emotion = new int[N+1][2]; //체력, 기쁨
        for(int i=1;i<=N;i++){
            emotion[i][0] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++)
            emotion[i][1] = Integer.parseInt(st.nextToken());

        int[][] dp = new int[N+1][101]; //사람수, 체력
//        int max = Integer.MIN_VALUE;
        for(int hp = 1;hp<=100;hp++){
            for(int i=1;i<=N;i++){
                //못 만났을 때 현상유지값
                dp[i][hp] = dp[i-1][hp];
                if(hp - emotion[i][0] > 0) {//현재 만나는 사람에게 인사할 때 잃은 체력 > 0
                    dp[i][hp] = Math.max(dp[i - 1][hp], emotion[i][1] + dp[i - 1][hp - emotion[i][0]]);
//                    max = Math.max(max, dp[i][hp]);
                }
            }
        }

//        System.out.println(max);
        System.out.println(dp[N][100]);
    }
}
