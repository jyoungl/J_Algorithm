import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_14940_쉬운최단거리 {
    static int N,M;
    static int[][] arr, goal;
    static int[][] dir = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        goal = new int[N][M];
        visited = new boolean[N][M];

        int tarX=0, tarY=0;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 2){
                    tarX = i;
                    tarY = j;
                }
            }
        }

        bfs(tarX, tarY);

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(!visited[i][j] && arr[i][j] != 0)
                    goal[i][j] = -1;
                sb.append(goal[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
    public static void bfs(int x, int y){
        Queue<int[]> que = new LinkedList<>();
        visited[x][y] = true;
        que.add(new int[] {x,y,0});

        while(!que.isEmpty()){
            int[] now = que.poll();
            goal[now[0]][now[1]] = now[2];

            for(int d=0;d<4;d++){
                int dx = now[0] + dir[d][0];
                int dy = now[1] + dir[d][1];

                if(dx<0||dy<0||dx>=N||dy>=M||visited[dx][dy]||arr[dx][dy]==0)
                    continue;

                visited[dx][dy] = true;
                que.add(new int[] {dx,dy,now[2]+1});
            }
        }

    }
}