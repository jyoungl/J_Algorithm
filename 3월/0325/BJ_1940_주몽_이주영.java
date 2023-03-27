package mar21;

import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import javax.lang.model.util.ElementScanner6;

public class BJ_1940_주몽_이주영 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);
        //1 2 3 4 5 7

        int l = 0, r = N - 1;
        int ans = 0;

        while (l < r) {
            int now = arr[l] + arr[r];

            if (now == M) {
                ans++;
                l += 1;
                r -= 1;
            } else if (now < M)
                l += 1;
            else
                r -= 1;
        }
        System.out.println(ans);
    }
}
