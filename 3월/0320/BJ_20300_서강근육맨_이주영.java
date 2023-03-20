package mar20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_20300_서강근육맨_이주영 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        long[] arr = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);
        long ans = 0;

        if (N % 2 != 0) {
            ans = arr[N - 1];
            N -= 1;
        }
        
        for (int i = 0; i < N / 2; i++) {
            ans = Math.max(ans, arr[i] + arr[N - 1 - i]);
        }
        System.out.println(ans);
        //1 2 3 10 20 21 22 23
        //1 5 4 9 8 10
        //1 4 5 8 9 10
    }    
}
