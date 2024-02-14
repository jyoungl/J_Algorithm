import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_21278_호석이두마리치킨 {
    static int N, M;
    static int[][] distance;
    static int[] vill, answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        distance = new int[N][N];
        vill = new int[2];
        answer = new int[3];
        answer[2] = Integer.MAX_VALUE;

        for(int i=0;i<N;i++) {
            for (int j = 0; j < N; j++) {
                if (i == j)
                    distance[i][j] = 0;
                else
                    distance[i][j] = 1000000;
            }
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            distance[x][y] = distance[y][x] = 2;
        }

        fload_ws();
        combination(0,0);

        System.out.println(answer[0]+" "+ answer[1]+" "+answer[2]);
    }
    public static void combination(int start, int cnt){
        if(cnt == 2){
            int ans = 0;
            for(int i=0;i<N;i++){
                if(vill[0] == i || vill[1] == i)
                    continue;
                else
                    ans += Math.min(distance[vill[0]][i], distance[vill[1]][i]);
            }
            if(ans<answer[2]){
                answer[2] = ans;
                answer[0] = vill[0]+1;
                answer[1] = vill[1]+1;
            }

            return;
        }

        for(int i=start;i<N;i++){
            vill[cnt] = i;
            combination(i+1,cnt+1);
        }
    }

    public static void fload_ws(){
        for(int k=0;k<N;k++){
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
                }
            }
        }
    }
}
