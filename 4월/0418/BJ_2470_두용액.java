package apr18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2470_두용액 {
    public static int N;
    public static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);
        reg_func();
        
    }

    public static void reg_func() {
        int best = Integer.MAX_VALUE;
        int ans1 = 0;
        int ans2 = 0;
        for (int L = 0; L < N; L++) {
            int res = binary_search(L + 1, N-1, -arr[L]);

            if (L+1<=res-1 && res-1<=N-1 && Math.abs(arr[res - 1] + arr[L]) < best) {
                best = Math.abs(arr[res - 1] + arr[L]);
                ans1 = arr[L];
                ans2 = arr[res - 1];
            }

            if (L+1<=res && res<=N-1 && Math.abs(arr[res] + arr[L]) < best) {
                best = Math.abs(arr[res] + arr[L]);
                ans1 = arr[L];
                ans2 = arr[res];
            }
        }

        System.out.println(ans1 + " " + ans2);
    }
    //-arr[left]보다 큰 수들 중 가장 왼쪽 값 출력
    public static int binary_search(int left, int right, int x) {
        int res = right + 1;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] >= x) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }
    
}
