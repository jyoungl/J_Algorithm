import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ_24479_깊이우선탐색1 {
    public static StringBuilder sb = new StringBuilder();
    public static int[] visited;
    public static int N,M,R,order;
    public static ArrayList<Integer>[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        visited = new int[N+1];
        arr = new ArrayList[N+1];
        for(int i=0;i<=N;i++)
            arr[i] = new ArrayList<Integer>();

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x].add(y);
            arr[y].add(x);
        }

        for(int i=1;i<=N;i++)
            Collections.sort(arr[i]);

        order = 1;
        visited[R] = order++;
        dfs(R);

        for(int i=1;i<=N;i++){
            sb.append(visited[i]).append("\n");
        }
        System.out.println(sb);

    }
    public static void dfs(int start){
        for(int i : arr[start]){
            if(visited[i] != 0)
                continue;

            visited[i] = order++;
            dfs(i);
        }
    }
}
