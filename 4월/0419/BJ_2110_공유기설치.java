package apr18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2110_공유기설치 {
    public static int N, M;
    public static int[] house;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        house = new int[N];

        for (int i = 0; i < N; i++)
            house[i] = Integer.parseInt(br.readLine());

        pos();
    }
    //공유기 사이 거리 정하기
    public static void pos() {
        Arrays.sort(house);
        int L = 0;
        int R = 1000000000;
        int max = 0;
        while (L <= R) {
            int mid = (L + R) / 2;
            if (positive(mid)) {
                max = mid;
                L = mid + 1;
            } else
                R = mid - 1;
        }
        
        System.out.println(max);
    }
    
    public static boolean positive(int x) {
        int cnt = 1;
        int last = house[0];

        for (int i = 0; i < N; i++) {
            if (house[i] - last >= x) {
                cnt++;
                last = house[i];
            }
        }
        
        return cnt >= M;
    }
}
