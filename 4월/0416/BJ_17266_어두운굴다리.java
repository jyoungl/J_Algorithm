package apr16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_17266_어두운굴다리 {
    public static int[] jun;
    public static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        jun = new int[M];

        for (int i = 0; i < M; i++)
            jun[i] = Integer.parseInt(st.nextToken());

        int left = 1;
        int right = N;
        int min = N;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (possible(mid)) {
                right = mid - 1;
                min = mid;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(min);
    }

    public static boolean possible(int x) {
        int prev = 0;

        for (int i = 0; i < jun.length; i++) {
            if (jun[i] - x <= prev)
                prev = jun[i] + x;
            else
                return false;
        }
        
        return N - prev <= 0;
    }    
}
