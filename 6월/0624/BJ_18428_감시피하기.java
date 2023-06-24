import java.io.*;
import java.util.*;

public class Main {
    public static class Pot {
        int x;
        int y;

        public Pot(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static int N;
    public static char[][] arr;
    public static ArrayList<Pot> list = new ArrayList<>();
    public static int[] dx = {1,-1,0,0};
    public static int[] dy = {0,0,1,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new char[N][N];
        
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                arr[i][j] = st.nextToken().charAt(0);
                //여기서 학생 위치를 찾고 나중에 선생님들 감시범위를 싹 찾은 다음에 그 안에 학생 위치가 있는지?로 풀었어
                if(arr[i][j] == 'S'){
                    list.add(new Pot(i,j));
                } 
            }
        }

        //세 개 조합 구함
        dfs(0);
        //시스템 중단 없이 여기까지 왔으면 불가능한거라 no출력해줘
        //끝 ~~~~
        System.out.println("NO");
    }
    //조합 구하는 함수 //여기서 장애물 위치 선정하고
    public static void dfs(int cnt){
        if(cnt == 3){
            //다 안들키는지 확인
            result();
            return;
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(arr[i][j] == 'X'){
                    arr[i][j] = '0';
                    dfs(cnt+1);
                    arr[i][j] = 'X';
                }
            }
        }
    }
    //구한 조합으로 감시 피할 수 있는지 확인
    //여기서 해당 장애물의 경우일 때 선생님들 감시범위를 찾았어
    public static void result(){
        Queue<Pot> que = new LinkedList<>();
        char[][] copy = new char[N][N];
        boolean[][] visited = new boolean[N][N];

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                copy[i][j] = arr[i][j];
            }
        }

        //선생님 위치 찾음
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(copy[i][j] == 'T'){
                    que.add(new Pot(i,j));
                    visited[i][j] = true;
                }
            }
        }
        //bfs 돌려서 0 이 아니면 일단 장애물 안만난 거니까 무조건 감시범위 내로 만들고 (학생 위치 아까 뺐음)
        while(!que.isEmpty()){
            Pot now = que.poll();
            int x = now.x;
            int y = now.y;

            for(int d=0;d<4;d++){
                int nx = x + dx[d];
                int ny = y + dy[d];

                while(0<=nx && 0<=ny && nx<N && ny<N){
                    if(copy[nx][ny] != '0'){
                        visited[nx][ny] = true;
                        nx += dx[d];
                        ny += dy[d];
                    }
                    else
                        break;
                }
            }
        }
        //bfs 끝나면 이 범위 안에 학생들이 있는지 확인해
        if(check(visited)){
            //없으면 바로 yes 출력해주고 끝내
            System.out.println("YES");
            System.exit(0);
        }
    }
    //학생들이 있으면 false고 없으면 true해서
    public static boolean check(boolean[][] visited){
        for(Pot pot : list){
            if(visited[pot.x][pot.y] == true){
                return false;
            }
        }

        return true;
    }
}
