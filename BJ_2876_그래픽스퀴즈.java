import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2876_그래픽스퀴즈 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] table = new int[N+1][2];
        int[][] dp = new int[6][N+1]; //grade, table

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            table[i+1][0] = x;
            table[i+1][1] = y;
        }

        dp[table[1][0]][1] = 1;
        dp[table[1][1]][1] = 1;
        int max = 1;
        int answer = Math.min(table[1][0], table[1][1]);
        for(int i=2;i<=N;i++){
            for(int j=1;j<=5;j++){
                if(table[i][0] == j || table[i][1] == j){
                    dp[j][i] = dp[j][i-1]+1;
                    if(max < dp[j][i]){
                        max = dp[j][i];
                        answer = j;
                    }
                    else if(max == dp[j][i])
                        answer = Math.min(answer, j);

                }
                else
                    dp[j][i] = 0;
            }
        }

        System.out.println(max + " " + answer);
    }
}
