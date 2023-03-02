package mar02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1806_부분합_이주영 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] arr = new int[N+1];
        st = new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        int l=0,r = 0;
        int ans = Integer.MAX_VALUE;
        while(r<=N){
            if(sum>=S){ //S보다 커졌으면
                sum -= arr[l++]; //최소 길이가 되기 위해 왼쪽부터 줄여감
                int x = r - l + 1;//길이
                ans = Math.min(ans, x);
            }
            else if(sum<S){ //오른쪽으로 넓혀가서 더함
                sum += arr[r++];
            }
        }
        if(ans == Integer.MAX_VALUE)
            System.out.println(0);
        else
        System.out.println(ans);
    }
}
