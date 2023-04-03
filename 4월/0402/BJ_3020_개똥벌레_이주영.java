package apr01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_3020_개똥벌레_이주영 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int[] arr = new int[H + 1];
        int[] arr2 = new int[H + 1];

        for (int i = 0; i < N / 2; i++) {
            arr[Integer.parseInt(br.readLine())]++;
            arr2[Integer.parseInt(br.readLine())]++;
        }
        
        for (int i = H - 1; i > 0; i--) {
            arr[i] += arr[i + 1];
            arr2[i] += arr2[i + 1];
        }

        int[] ans = new int[H + 1];
        int min = Integer.MAX_VALUE;

        for (int i = 1; i <= H; i++) {
            ans[i] = arr[i] + arr2[H - i + 1];
            min = Math.min(min, ans[i]);
        }

        int cnt = 0;
        for (int i = 1; i <= H; i++) {
            if (ans[i] == min)
                cnt++;
        }
        System.out.println(min + " " + cnt);
    }
}
