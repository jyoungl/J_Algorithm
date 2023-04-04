package apr04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1027_고층건물_이주영 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // (1,5) (2,5) (3,5) (4,5)
        // 0 
        int[] ans = new int[N];
        for (int i = 0; i < N - 1; i++) {
            ans[i] += 1;
            ans[i + 1] += 1;
            double l = arr[i + 1] - arr[i];

            for (int j = i + 1; j < N; j++) {
                double nl = (double) (arr[j] - arr[i]) / (j - i);
                if (nl > l) {
                    l = nl;
                    ans[i]++;
                    ans[j]++;
                }
            }
        }
        Arrays.sort(ans);
        System.out.println(ans[N-1]);
    }
}
