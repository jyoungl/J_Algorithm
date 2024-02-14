import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_16234_인구이동 {
    static int R,L,N;
    static int[][] arr, ans;
    static boolean[][] visited;
    static boolean b = true;
    static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        ans = new int[N][N];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++)
                arr[i][j] = ans[i][j] = Integer.parseInt(st.nextToken());
        }
        int answer = 0;

        //인구이동이 없을때까지 반복
        while(b){
            visited = new boolean[N][N];
            b = false;
            answer++;
//            System.out.print(b);
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(!visited[i][j])
                        //arr[i][j] 대한 연합 찾기
                        bfs(i,j);
                }
            }
//            System.out.println(b);
            //arr <- ans값으로 교체
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++)
                    arr[i][j] = ans[i][j];
            }
        }

        System.out.println(answer-1);
    }
    public static void bfs(int x, int y){
        Queue<int[]> union = new LinkedList<>();
        Queue<int[]> que = new LinkedList<>();
        visited[x][y] = true;
        que.add(new int[] {x,y});
        union.add(new int[] {x,y});
        int sum = 0;
        while(!que.isEmpty()){
            int[] now = que.poll();
            sum += arr[now[0]][now[1]];
//            System.out.println(now[0]+" "+now[1]);
            for(int d=0;d<4;d++){
                int dx = now[0]+dir[d][0];
                int dy = now[1]+dir[d][1];

                if(dx<0||dy<0||dx>=N||dy>=N||visited[dx][dy])
                    continue;

                if(Math.abs(arr[dx][dy]-arr[now[0]][now[1]])>=L && Math.abs(arr[dx][dy]-arr[now[0]][now[1]])<=R){
                    visited[dx][dy] = true;
                    union.add(new int[] {dx,dy});
                    que.add(new int[] {dx,dy});
                }
            }
        }
        sum /= union.size();
        if(union.size() >= 2)
            b = true;

        while(!union.isEmpty()){
            int[] now = union.poll();
            ans[now[0]][now[1]] = sum;
        }
    }
}
