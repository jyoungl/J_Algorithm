package apr12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_16948_데스나이트_이주영 {
    public static int N;
    public static int min = Integer.MAX_VALUE;
    public static int[] dr = {-2, -2, 0, 0, 2, 2};
    public static int[] dc = {-1, 1, -2, 2, -1, 1};
    public static class Pos {
        int x;
        int y;
        int cnt;

        public Pos(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r1 = Integer.parseInt(st.nextToken());
        int c1 = Integer.parseInt(st.nextToken());
        int r2 = Integer.parseInt(st.nextToken());
        int c2 = Integer.parseInt(st.nextToken());
        bfs(r1, c1, r2, c2);
        
        if(min == Integer.MAX_VALUE)
            System.out.println("-1");
        else
            System.out.println(min);
    }

    public static void bfs(int x1, int y1, int x2, int y2) {
        Queue<Pos> que = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];
        visited[x1][y1] = true;
        que.add(new Pos(x1, y1, 0));

        while (!que.isEmpty()) {
            Pos now = que.poll();

            if (now.x == x2 && now.y == y2) {
                min = Math.min(min, now.cnt);
                continue;
            }

            for (int d = 0; d < 6; d++) {
                int x = now.x + dr[d];
                int y = now.y + dc[d];

                if(x<0 || y<0 || x>=N || y>=N || visited[x][y])
                    continue;

                visited[x][y] = true;
                que.add(new Pos(x, y, now.cnt + 1));
            }
        }
    }
}
