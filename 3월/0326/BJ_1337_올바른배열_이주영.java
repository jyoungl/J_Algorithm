package mar26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;

public class BJ_1337_올바른배열_이주영 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        int ans = 0;
        for (int i = 0; i < N; i++) {
            int cnt = 0;

            for (int j = i + 1; j < i + 5 && j < N; j++) {
                if (arr[j] < arr[i] + 5) {
                    cnt++;
                }
            }
            ans = Math.max(ans, cnt);
        }
        System.out.println(4-ans);
    } 
}
