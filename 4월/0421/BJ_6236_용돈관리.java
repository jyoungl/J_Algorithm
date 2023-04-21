import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        int max = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }

        func(max);
    }
    //이분탐색으로 K 결정
    public static void func(int max) {
        int L = max;
        int R = 1000000000;
        int min = 1000000000;
        while (L <= R) {
            int mid = (L + R) / 2;
            if (possible(mid)) {
                min = mid;
                R = mid-1;
            } else {
                L = mid+1;
            }
        }
        System.out.println(min);
    }
    //k원으로 M번 가능한지
    public static boolean possible(int k) {
        int cnt = 1;
        int now = k;

        for (int i = 0; i < N; i++) {
            if (now - arr[i] >= 0) {
                now -= arr[i];
            } else {
                cnt++;
                now = k - arr[i];
            }
        }
        
        return cnt <= M;
    }
}
