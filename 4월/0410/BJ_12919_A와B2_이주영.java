package apr10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_12919_A와B2_이주영 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String T = br.readLine();
        Queue<String> que = new LinkedList<>();
        StringBuffer sb;
        que.add(T);

        while (!que.isEmpty()) {
            String str = que.poll();
            sb = new StringBuffer(str);
            int len = str.length();
            //기저조건
            if (len < S.length()) {
                System.out.println("0");
                return;
            }
            if (str.equals(S)) {
                System.out.println("1");
                return;
            }
            //A -> AB -> BA -> BAA-> BAAA -> BAAAB -> BAAABA -> BABAAAB

            // BAAABA -> BAAAB -> BAAA -> AAA, BAA -> AA, AA -> A
            //        -> ABAAA -> ABAA -> ABA -> AB -> 불가능
            //조건 수행
            if (str.charAt(0) == 'B') {
                String now = sb.reverse().toString();
                now = now.substring(0, len - 1);
                que.add(now);
            }
            if (str.charAt(len - 1) == 'A') {
                que.add(str.substring(0, len - 1));
            }
        }
        System.out.println("0");
    }
}
