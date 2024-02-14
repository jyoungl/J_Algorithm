import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_15903_카드합체놀이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        PriorityQueue<Long> que = new PriorityQueue<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++)
            que.add(Long.parseLong(st.nextToken()));

        for(int i=0;i<m;i++){
            long min1 = que.poll();
            long min2 = que.poll();

            que.add(min1+min2);
            que.add(min1+min2);
        }
        long answer = 0;
        while(!que.isEmpty()){
            answer += que.poll();
        }
        System.out.println(answer);
    }
}
