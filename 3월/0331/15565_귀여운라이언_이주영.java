package mar31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_15565_귀여운라이언_이주영 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        
        int cnt = 0, ans = Integer.MAX_VALUE;
        ArrayList<Integer> one = new ArrayList<>();
        //0, 4, 6,9
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i] == 1)
                one.add(i);
        }

        if (one.size() < K) {
            System.out.println("-1");
            return;
        }
        if (one.size() == 1) {
            System.out.println("1");
            return;
        }

        int lp = one.get(0);
        int rp = lp;
        int x = 1;

        while (lp <= rp) {
            if (rp >= N || x>=one.size())
                break;
            int now = arr[rp];

            if (now == 1) {
                cnt++;
                rp++;
            } else if (now == 2) {
                rp++;
            }

            if (cnt == K) {
                rp--;
                ans = Math.min(ans, rp - lp + 1);
                lp = one.get(x++);
                rp++;
                cnt--;
                continue;
            }
        }
        
        if(ans == Integer.MAX_VALUE)
            System.out.println("-1");
        else
            System.out.println(ans);
    }
}
