package apr18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2343_기타레슨 {
    public static int N, M;
    public static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        func();
    }
    //블루레이 크기 이분탐색 통해 정함
    public static void func() {
        int l = arr[0];
        int r = 1000000000;
        int ans = 0;

        for (int i = 0; i < N; i++)
            l = Math.max(l, arr[i]);

        while (l <= r) {
            int mid = (l + r) / 2;
            if (positive(mid)) {
                ans = mid;
                r = mid - 1;
            } else
                l = mid + 1;
        }
        System.out.println(ans);
    }
    //크기 s로 블루레이 M개가 될 수 있나
    public static boolean positive(int s) {
        int cnt = 1;
        int now = s;
        for (int i = 0; i < N; i++) {
            if (now - arr[i] >= 0) {
                now -= arr[i];
            } else {
                cnt++;
                now = s - arr[i];
            }
        }
        
        return cnt <= M;
    }
}
