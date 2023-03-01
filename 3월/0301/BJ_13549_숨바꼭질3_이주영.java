package mar01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_13549_숨바꼭질3_이주영 {
    public static class Pos {
        int position;
        int count;

        public Pos(int position, int count) {
            this.position = position;
            this.count = count;
        }
    }

    public static boolean[] visited = new boolean[100001];
    public static int min = Integer.MAX_VALUE;
    public static final int max = 100000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        if (N == K) {
            System.out.println(0);
            return;
        }
        bfs(N,K);
    }

    public static void bfs(int N, int K) {
        Queue<Pos> que = new LinkedList<>();
        visited[N] = true;
        que.add(new Pos(N, 0));
 
        while (!que.isEmpty()) {
            Pos p = que.poll();
            int x = p.position;
            int y = p.count;
            visited[x] = true;
            // if (x < 0 || x > 100000)
            //     continue;

            if (x == K) {
                min = Math.min(min, y);
            }

            if (x * 2 <= max && !visited[x*2])
                que.add(new Pos(x * 2, y));
            if (x + 1 <= max && !visited[x+1])
                que.add(new Pos(x + 1, y + 1));
            if (x - 1 >= 0 && !visited[x-1])
                que.add(new Pos(x - 1, y + 1));
        }
        System.out.println(min);
    }
}
