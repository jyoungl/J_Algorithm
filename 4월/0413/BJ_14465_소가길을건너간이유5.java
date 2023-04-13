package apr13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14465_소가길을건너간이유5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        boolean[] arr = new boolean[N + 1];

        for (int i = 0; i < B; i++) {
            int x = Integer.parseInt(br.readLine());
            arr[x] = true;
        }

        int cnt = 0;
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= K; i++) {
            if (arr[i])
                cnt++;
        }
        ans = cnt;
        int j = 1;
        for (int i = K + 1; i <= N; i++) {
            if (arr[j])
                cnt--;
            if (arr[i])
                cnt++;
            j++;
            ans = Math.min(ans, cnt);
        }
        System.out.println(ans);
    }
}
