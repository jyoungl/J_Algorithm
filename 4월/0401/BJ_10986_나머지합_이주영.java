package apr01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_10986_나머지합_이주영 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[] sum = new int[M];
        st = new StringTokenizer(br.readLine());
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            cnt = (cnt + Integer.parseInt(st.nextToken())) % M;
            sum[cnt]++;
        }
        //1 2 3 1 2
        //1 0 0 1 0
        //sum[0]=3, sum[1]=2, sum[2]=0
        //3, 1, 0
        long ans = sum[0];
        for (int i = 0; i < M; i++) {
            ans += (long) sum[i] * (sum[i] - 1) / 2;
        }
        System.out.println(ans);
    }
}
