package mar04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {

	static int N, M, max = 0;
	static boolean[] visited;
    static int[] ans;
	static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N + 1];
        ans = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x].add(y);
        }

        for (int i = 1; i <= N; i++) {
            visited = new boolean[N+1];
            dfs(i);
        }

        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            max = Math.max(max, ans[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (max == ans[i]) {
                sb.append(i + " ");
            }
        }
        System.out.println(sb);

    }
    
	public static void dfs(int now) {
		visited[now] = true; // 방문표시

		for (int i : graph[now]) {
			if (visited[i] == false) {
				ans[i]++;
				dfs(i);
			}
		}
	}
}
