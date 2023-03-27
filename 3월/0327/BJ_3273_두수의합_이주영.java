package mar27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_3273_두수의합_이주영 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int x = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        int lp = 0;
        int rp = N - 1;
        int ans = 0;
        while (lp < rp) {
            int sum = arr[lp] + arr[rp];
            if (sum == x) {
                ans++;
                lp++;
                rp--;
            } else if (sum < x) {
                lp++;
            } else {
                rp--;
            }
        }
        System.out.println(ans);
    }
}
