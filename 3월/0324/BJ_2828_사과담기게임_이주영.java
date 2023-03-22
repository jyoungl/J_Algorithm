package mar22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2828_사과담기게임_이주영 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int cnt = Integer.parseInt(br.readLine());
        int ans = 0;
        int backet1 = 1;
        int backet2 = M;
        for (int i = 0; i < cnt; i++) {
            int apple = Integer.parseInt(br.readLine());

            if (backet1 == apple || backet2 == apple || (backet1<=apple&&backet2>=apple)) {
                continue;
            }

            else {
                if (Math.abs(backet1 - apple) > Math.abs(backet2 - apple)) {
                    ans += Math.abs(apple - backet2);
                    backet2 = apple;
                    backet1 = backet2 - (M - 1);
                } else {
                    ans += Math.abs(backet1 - apple);
                    backet1 = apple;
                    backet2 = backet1 + (M - 1);
                }
                //1 5 1 3 4
                //2칸 2칸 0칸 1칸
                //b1 1 b2 3
            }
            //System.out.println("b1: "+backet1 + "b2: "+backet2);
        }
        System.out.println(ans);
    }
}
