import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_11497_통나무건너뛰기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        //테케 반복횟수
        for(int t=0;t<T;t++){
            int N = Integer.parseInt(br.readLine());
//            int[] tree = new int[N];
            st = new StringTokenizer(br.readLine());
            PriorityQueue<Integer> que = new PriorityQueue<>(Collections.reverseOrder());

            for(int i=0;i<N;i++){
//                tree[i] = Integer.parseInt(st.nextToken());
                que.add(Integer.parseInt(st.nextToken()));
            }
            //2 4 5 7 9 1
            //1 4 7 9 5 2
//            Arrays.sort(tree);
            int[] answer = new int[N];
            int left = N/2-1;
            int right = N/2+1;
            answer[N/2] = que.poll();

            while(!que.isEmpty()){
                if(right<N) //짝수인 경우를 대비해 써줘야함
                    answer[right++] = que.poll();
                if(!que.isEmpty())
                    answer[left--] = que.poll();
            }



//            int len = answer.length;
//            int now = N-1;
//            answer[len/2] = tree[now--]; //가장 큰 수 중간에다
//
//            if(N%2==1){
//                for(int i=1;i<=len/2;i++){
//                    answer[len/2-i] = tree[now--];
//                    answer[len/2+i] = tree[now--];
//                }
//            }
//            else{
//                for(int i=1;i<len/2;i++){
//                    answer[len/2-i] = tree[now--];
//                    answer[len/2+i] = tree[now--];
//                }
//                answer[0] = tree[0];
//            }

            int max = Math.abs(answer[0]-answer[N-1]);
            for(int i=1;i<N;i++)
                max = Math.max(max, Math.abs(answer[i]-answer[i-1]));

            sb.append(max+"\n");
        }
        System.out.println(sb);
    }
}
