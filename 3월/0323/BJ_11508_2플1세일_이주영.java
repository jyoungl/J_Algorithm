package mar23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BJ_11508_2플1세일_이주영 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> price = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            price.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(price, Collections.reverseOrder());
        int ans = 0;
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            if (cnt == 2) {
                cnt = 0;
                continue;
            }
            ans += price.get(i);
            cnt++;
        }
        System.out.println(ans);
        //3 3 2, 2 = 8
        //10 9 6, 4 4 3, 2 = 19+8+2
    }
}
