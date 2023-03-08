package mar08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_3474_교수가된현우_이주영 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int x = Integer.parseInt(br.readLine());
            //소인수분해 시 2,5 개수 중 더 작은 것
            int two = 0, five = 0;

            for (int j = 2; j <= x; j *= 2)
                two += x / j;

            for (int j = 5; j <= x; j *= 5)
                five += x / j;

            sb.append(Math.min(two, five)).append("\n");
        }
        System.out.println(sb);
    }
}
