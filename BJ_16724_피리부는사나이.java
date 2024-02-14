import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_16724_피리부는사나이 {
    public static int N,M, res=0;
    public static char[][] map;
    public static boolean[][] visited;
    public static int[][] check;
    public static int[] dr = {-1,1,0,0};
    public static int[] dc = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[1001][1001];
        visited = new boolean[1001][1001];
        check = new int[1001][1001];

        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine());
            char[] ch = st.nextToken().toCharArray();
            for(int j=1;j<=M;j++){
                map[i][j] = ch[j-1];
                check[i][j] = -1;
            }
        }

        for(int i=1;i<=N;i++){
            for(int j=1;j<=M;j++){
                if(!visited[i][j]){
                    dfs(i,j);
                }
            }
        }
        System.out.println(res);
    }
    public static int dfs(int x, int y){
        if(check[x][y] != -1)
            return check[x][y];

        if(x<1 || x>N || y<1 || y>M || visited[x][y])
            return res++;

        visited[x][y] = true;

        int d = direction(map[x][y]);
        int dx = x + dr[d];
        int dy = y + dc[d];
        check[x][y] = dfs(dx, dy);

        return check[x][y];
    }

    public static int direction(char c){
        switch (c){
            case 'U':
                return 0;
            case 'D':
                return 1;
            case 'L':
                return 2;
            case 'R':
                return 3;
            default:
                return 4;
        }
    }
}
