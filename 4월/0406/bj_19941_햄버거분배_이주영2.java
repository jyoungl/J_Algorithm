package apr06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_19941_햄버거분배_이주영2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[] arr = br.readLine().toCharArray();
        boolean[] visited = new boolean[N];
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 'H')
                continue;

            int s = Math.max(i - M, 0);
            int e = Math.min(i + M, N - 1);
            for (int j = s; j <= e; j++) {
                if (arr[j] == 'H' && !visited[j]) {
                    visited[j] = true;
                    ans++;
                    break;
                }
            }
        }
        System.out.println(ans);
    }
}
