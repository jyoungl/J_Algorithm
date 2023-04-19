package apr18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2805_나무자르기 {
    public static int N,M;
    public static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        height();
    }
    //높이 최대값 설정하기
    public static void height() {
        int L = 0;
        int R = 1000000000;
        int ans = 0;

        while (L <= R) {
            int mid = (L + R) / 2;

            if (slice(mid)) {
                ans = mid;
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        System.out.println(ans);
    }
    //높이만큼 잘랐을 때 몇 미터 나오는지
    public static boolean slice(int x) {
        long sum = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i] > x)
                sum += arr[i] - x;
        }
        
        return sum >= M;
    }
}
