package apr01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2167_2차원배열의합_이주영 {
    public static int N, M;
    public static int[][] arr;
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
        int K = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int[] param = new int[4];
            for (int j = 0; j < 4; j++) {
                param[j] = Integer.parseInt(st.nextToken());
            }
            sb.append(func(param)+"\n");
        }
        System.out.println(sb);
    }

    public static int func(int[] param) {
        int x1 = param[0]-1;
        int x2 = param[2]-1;
        int y1 = param[1]-1;
        int y2 = param[3]-1;
        int sum = 0;
        for (int i = x1; i <= x2; i++) {
            for(int j=y1;j<=y2;j++)
                sum += arr[i][j];
        }

        return sum;
    }
}
