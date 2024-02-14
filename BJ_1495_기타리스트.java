import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_1495_기타리스트 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int N = Integer.parseInt(st.nextToken());
//        int S = Integer.parseInt(st.nextToken());
//        int M = Integer.parseInt(st.nextToken());
//        int[] vol = new int[N];
//        int[] dp = new int[M+1]; //vol[i] = i볼륨으로 가능한 노래의 번호
//
//        st = new StringTokenizer(br.readLine());
//        for(int i=0;i<N;i++){
//            vol[i] = Integer.parseInt(st.nextToken());
//        }
////        Arrays.fill(dp, -1);
//        dp[S] = 1;
//        for(int i=1;i<=N;i++){
//            int now = vol[i-1];
//            List<Integer> list = new ArrayList<>();
//
//            for(int j=0;j<=M;j++){
//                if(dp[j] == i){
//                    int x = j+now;
//                    int y = j-now;
//
//                    if(0<=x && x<=M)
//                        list.add(x);
//                    if(0<=y && y<=M)
//                        list.add(y);
//                }
//            }
//
//            for(int a : list)
//                dp[a] = i+1;
//        }
////        Queue<int[]> que = new LinkedList<>();
////        int plus = S + vol[0];
////        if(plus >=0 && plus <= M) {
////            dp[plus] = 2;
////            que.add(new int[] {plus, 2});
////        }
////        int minus = S - vol[0];
////        if(minus >= 0 && minus <= M){
////            dp[minus] = 2;
////            que.add(new int[] {minus, 2});
////        }
////
////        while(!que.isEmpty()){
////            int[] now = que.poll();
////            if(now[1] == N+1)
////                continue;
////
////            int x = now[0] + vol[now[1]-1];
////            if(x>=0 && x<=M){
////                dp[x] = now[1] + 1;
////                que.add(new int[] {x, dp[x]});
////            }
////            x = now[0] - vol[now[1]-1];
////            if(x>=0 && x<=M){
////                dp[x] = now[1] + 1;
////                que.add(new int[] {x, dp[x]});
////            }
////        }
//
//        int answer = -1;
//        for(int i=0;i<M+1;i++){
//            if(dp[i] == N+1) {
////                System.out.println("dp[" + i +"]: " + dp[i]);
//                answer = Math.max(answer, i);
//            }
//        }
//        if(answer != -1)
//            System.out.println(answer);
//        else
//            System.out.println(-1);
//    }
}
