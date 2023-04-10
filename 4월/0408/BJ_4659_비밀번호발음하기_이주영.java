package apr08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_4659_비밀번호발음하기_이주영 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String str = br.readLine();
            if (str.equals("end"))
                break;

            boolean aeiou = false;
            char before = ' ';
            int cnt = 0; //모음 연속 카운트
            int cnt2 = 0; // 자음 연속 카운트
            int ans = 1; //1: accept, 2:not accept
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);

                if (ch == 'a' || ch == 'e' || ch == 'o' || ch == 'i' || ch == 'u') {
                    aeiou = true;
                    cnt++;
                    cnt2 = 0;
                } else {
                    cnt2++;
                    cnt = 0;
                }

                if (cnt == 3 || cnt2 == 3) {
                    ans = 2;
                    break;
                }

                if (before == ch) {
                    if (ch == 'e' || ch == 'o')
                        continue;

                    ans = 2;
                    break;
                }
                before = ch;
            }

            if (!aeiou)
                ans = 2;
            
            if (ans == 1)
                sb.append("<" + str + "> is acceptable.\n");
            else if (ans == 2)
                sb.append("<" + str + "> is not acceptable.\n");
        }
        System.out.println(sb);
    }
}
