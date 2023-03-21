package mar21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2467_용액_이주영 {
    static long[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int lp = 0, rp = N - 1;
        long x = 0, y = 0;
        long min = Integer.MAX_VALUE;

        while (lp < rp) {
            long now = arr[lp] + arr[rp];

            if (Math.abs(now) < min) {
                min = Math.abs(now);
                x = arr[lp];
                y = arr[rp];
            }

            if (now > 0) {
                rp -= 1;
            } else if (now < 0)
                lp += 1;
            else {
                x = arr[lp];
                y = arr[rp];
                break;
            }
        }
        
        System.out.println(x + " " + y);
    }
}
