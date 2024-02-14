import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InvalidObjectException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_3190_뱀 {
    static int[][] arr;
    static int N,K;
    static int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
    static Queue<int[]> snake = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        StringTokenizer st;
        arr = new int[N][N];
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0;i<K;i++){
            st = new StringTokenizer(br.readLine());
            arr[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1] = 1;
        }

        int L = Integer.parseInt(br.readLine());
        for(int i=0;i<L;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            String c = st.nextToken();
            //C왼쪽 -1, D오른쪽 1
            if(c.equals("D"))
                map.put(x, 1);
            else
                map.put(x, -1);
        }

        int time = 0, x=0, y=0;
        int d = 0;
        snake.add(new int[] {x,y});
        int answer = 0;

        while(time<=10000){
            time++;

            x += dir[d][0];
            y += dir[d][1];

            if(finish(x,y)){ //게임 안끝남
                snake.add(new int[] {x,y});
                if(arr[x][y] == 1){ //이 칸에 사과 존재
                    arr[x][y] = 0; //사과먹음
                }
                else{
                    snake.poll(); //꼬리 이동
                }
            }
            else{ //게임끝
                answer = time;
                break;
            }

            //X초가 끝난 뒤
            if(map.containsKey(time)){
                d += map.get(time);
                if(d<0) d = 3;
                else if(d>3) d = 0;
            }
        }

        System.out.println(answer);
    }

    public static boolean finish(int x, int y){
        if(x<0||y<0||x>=N||y>=N)
            return false;
        int size = snake.size();
        for(int i=0;i<size;i++){
            int[] sn = snake.poll();
            if(sn[0]==x && sn[1]==y)
                return false;
            snake.add(sn);
        }
//        if(snake.contains(arr))
//            return false;

        return true;
    }
}
