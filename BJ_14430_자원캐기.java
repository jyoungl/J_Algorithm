import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14430_자원캐기 {
    static int[][] dir = {{1,0}, {0,1}};
    static int N,M,max;
    static int[][] arr;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //dp[i][j] [i][j]에서 가질 수 있는 최대 자원
        int[][] dp = new int[N][M];
        dp[0][0] = arr[0][0];

        //맨 위의 행 값 추가
        for(int i=1;i<M;i++)
            dp[0][i] = dp[0][i-1]+arr[0][i];
        //맨 왼쪽 열 값 추가
        for(int i=1;i<N;i++)
            dp[i][0] = dp[i-1][0]+arr[i][0];
        //나머지 칸 값 추가
        for(int i=1;i<N;i++){
            for(int j=1;j<M;j++){
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1])+arr[i][j];
            }
        }

        System.out.println(dp[N-1][M-1]);
//        dfs(0,0,0);
//
//        if(arr[0][0] == 1)
//            max++;
//        System.out.println(max);
    }
//    public static void dfs(int x, int y, int cnt){
////        visited[x][y] = true;
//        max = Math.max(max, cnt);
//
////        System.out.println("x:"+x+" "+"y:"+y+" cnt: "+cnt);
//        for(int d=0;d<2;d++){
//            int dx = x+dir[d][0];
//            int dy = y+dir[d][1];
//
//            if(dx<0||dy<0||dx>=N||dy>=M)
//                continue;
//
//            if(arr[x][y] == 1) {
//                dfs(dx, dy, cnt + 1);
//            }
//            else
//                dfs(dx,dy,cnt);
//
////            visited[x][y] = false;
//        }
//    }
}
