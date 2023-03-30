package mar30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_17484_진우의달여행_이주영2 {
    public static int N, M;
    public static int[][] arr;
    public static int[] dc = {-1,0,1};
    public static int answer = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < M; i++) {
            func(0, i, 3, arr[0][i]);
        }
        System.out.println(answer);
    }

    public static void func(int height, int row, int dir, int ans) {
        if (height == N - 1) {
            answer = Math.min(answer, ans);
            return;
        }

        for (int i = 0; i < 3; i++) {
            if(i == dir)
                continue;
            int nx = height + 1;
            int ny = row + dc[i];

            if(ny<0 || ny>=M)
                continue;
            func(height + 1, ny, i, ans + arr[nx][ny]);
        }
    }
}
