import java.io.*;
import java.util.*;

class Solution {
    public static int[] dr = {1,-1,0,0};
    public static int[] dc = {0,0,1,-1};
    public int solution(int[][] maps) {
        int answer = 0;
        
        answer = bfs(maps);
        if(answer == Integer.MAX_VALUE)
            answer = -1;
        
        return answer;
    }
    public int bfs(int[][] maps){
       boolean[][] visited = new boolean[maps.length][maps[0].length];
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[] {0,0,1});
        visited[0][0] = true;
        int min = Integer.MAX_VALUE;
        while(!que.isEmpty()){
            int[] now = que.poll();
            
            if(now[0] == maps.length-1 && now[1] == maps[0].length-1){
                min = Math.min(min, now[2]);
                continue;
            }
            
            for(int d=0;d<4;d++){
                int dx = now[0] + dr[d];
                int dy = now[1] + dc[d];
                if(dx<0 ||dy<0 || dx>=maps.length || dy>=maps[0].length || maps[dx][dy] == 0)
                    continue;
                // System.out.println(dx + " " + dy + " " + now[2]);
                if(maps[dx][dy] == 1){
                    if(!visited[dx][dy]){
                        que.add(new int[]{dx,dy,now[2]+1});
                        visited[dx][dy] = true;
                    }
                    // System.out.println("que: " + dx + " " + dy + " " + now[2]+1);
                }
            }
        }
        return min;
    }
}
