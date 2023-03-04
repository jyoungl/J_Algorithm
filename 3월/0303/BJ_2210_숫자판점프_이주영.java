package mar04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2210_숫자판점프_이주영 {
    public static class Pos {
        int x;
        int y;
        int cnt;
        String number;

        public Pos(int x, int y, int cnt, String number) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.number = number;
        }
    }
    public static int[] dr = { 1, -1, 0, 0 };
    public static int[] dc = { 0, 0, 1, -1 };
    public static final int N = 5;
    public static HashSet<String> set = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[][] arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                bfs(arr, i, j);
            }
        }
        System.out.println(set.size());
    }
    
    public static void bfs(int[][] arr, int x, int y) {
        Queue<Pos> que = new LinkedList<>();
        que.add(new Pos(x, y, 0, String.valueOf(arr[x][y])));

        while (!que.isEmpty()) {
            //x, y, 카운트, 현재 숫자
            Pos now = que.poll();
            if (now.cnt == 5) {
                set.add(now.number);
                continue;
            }

            if (now.cnt > 5)
                continue;
            
            for (int d = 0; d < 4; d++) {
                int dx = now.x + dr[d];
                int dy = now.y + dc[d];
                
                if(dx<0 ||dx>=N ||dy<0 ||dy>=N)
                    continue;
                que.add(new Pos(dx, dy, now.cnt + 1, now.number+String.valueOf(arr[dx][dy])));
            }
            
        }
    }
}
