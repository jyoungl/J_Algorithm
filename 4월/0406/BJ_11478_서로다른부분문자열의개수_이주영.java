package apr06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class BJ_11478_서로다른부분문자열의개수_이주영 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < S.length(); i++) {
            for (int j = i; j < S.length(); j++) {
                String str = S.substring(i, j + 1);
                set.add(str);
            }
        }
        System.out.println(set.size());
    }
}
