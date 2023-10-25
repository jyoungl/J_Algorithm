import java.io.*;
import java.util.*;

class Solution {
    public static int[] dr = {1,-1,0,0};
    public static int[] dc = {0,0,1,-1};
    public boolean[][] visited;
    public int solution(int n, int m, int[][] hole) {
        int answer = 0;
        visited = new boolean[m][n];
        int[][] arr = new int[m][n];
        for(int i=0;i<hole.length;i++){
            arr[hole[i][1]-1][hole[i][0]-1] = 1; //지뢰 표시
        }
        answer = bfs(arr,n,m);
        return answer;
    }
    public int bfs(int[][] arr, int n, int m){
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[] {0, 0, 0, 0}); //x,y,신발사용여부,이동횟수
        visited[0][0] = true;
        
        while(!que.isEmpty()){
            int[] now = que.poll();
            
            if(now[0] == m-1 && now[1] == n-1){
                if(now[2] == 0)
                    return now[3]-1;
                else
                    return now[3];
            }
            
            for(int d=0;d<4;d++){
                int nx = now[0] + dr[d];
                int ny = now[1] + dc[d];
                int shoe = now[2];
                
                if(nx<0 || ny<0 ||nx>=m || ny>=n || visited[nx][ny])
                    continue;
                
                //현재 칸에 함정 있음
                if(arr[nx][ny] == 1){
                    if(shoe == 1)
                        continue;
                    else{
                        nx += dr[d];
                        ny += dc[d];
                        shoe = 1;
                        if(nx<0 || ny<0 ||nx>=m || ny>=n || visited[nx][ny] || arr[nx][ny] == 1)
                            continue;
                    }
                }
                // System.out.println("point: "+ nx + " " + ny + " " + shoe);
                visited[nx][ny] = true;
                que.add(new int[] {nx, ny, shoe, now[3]+1});
            }
        }
        return -1;
    }
}
