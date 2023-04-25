package apr25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_17390_이건꼭풀어야해 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int[] sum = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        //1 2 3 4 5
        //1 3 6 10 15
        Arrays.sort(arr);
        sum[0] = arr[0];
        for (int i = 1; i < N; i++)
            sum[i] = arr[i] + sum[i - 1];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            
            sb.append((sum[R - 1] - sum[L - 1] + arr[L - 1]) + "\n");
        }
        System.out.println(sb);
    }
}
