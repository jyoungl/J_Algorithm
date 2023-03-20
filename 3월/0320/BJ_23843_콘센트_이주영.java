package mar20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_23843_콘센트_이주영 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        //1 1 4 4 8 8 16
        PriorityQueue<Integer> que = new PriorityQueue<>(Collections.reverseOrder());
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++)
            que.add(Integer.parseInt(st.nextToken()));
        //16 
        //8 4 1
        //8 4 1
        PriorityQueue<Integer> que2 = new PriorityQueue<>();
        
        while (!que.isEmpty()) {
            int x = que.poll();

            if (que2.size() == M) {
                int t = que2.poll();
                que2.add(t + x);
            } else {
                que2.add(x);
            }

        }

        int ans = 0;
        while (!que2.isEmpty())
            ans = que2.poll();
        System.out.println(ans);
    }   
}
