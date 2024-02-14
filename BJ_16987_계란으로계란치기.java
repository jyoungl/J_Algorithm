import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ_16987_계란으로계란치기 {
    public static class Egg {
        int S;
        int W;

        public Egg(int S, int W){
            this.S = S;
            this.W = W;
        }
    }
    static int N,max=0;
    static LinkedList<Egg> list = new LinkedList<>();
    static int[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        visited = new int[N];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.add(new Egg(x,y));
            visited[i] = x;
        }

        func(0,0);
        System.out.println(max);
    }
    public static void func(int now, int cnt){
        //기저조건
        if(now == N){
            max = Math.max(cnt,max);
            return;
        }

        //손에 든 계란이 깨져있으면
        if(visited[now]<=0 || cnt==N-1){
            func(now+1,cnt);
            return;
        }

        for(int i=0;i<N;i++){
//            System.out.println("now:"+now+" tar:"+i+" cnt:"+cnt);
            //손에 든 계란과 타겟 동일
            if(i == now || visited[i]<=0)
                continue;

            //내구도 = 내구도-무게
            visited[now] -= list.get(i).W;
            visited[i] -= list.get(now).W;
            int x = 0;
            if(visited[now]<=0){
                x++;
            }
            if(visited[i]<=0){
                x++;
            }
            func(now+1, cnt+x);
            visited[now] += list.get(i).W;
            visited[i] += list.get(now).W;
        }
    }
}
