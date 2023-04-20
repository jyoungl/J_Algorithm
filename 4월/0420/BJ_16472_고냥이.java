package apr20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_16472_고냥이 {
    public static int N, kind;
    public static int[] alpha;
    public static String str;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        str = br.readLine();
        alpha = new int[26];
        kind = 0;

        func();
    }

    public static void func() {
        int max = 0;

        for (int R = 0, L = 0; R < str.length(); R++) {
            //현재 인덱스에서 계산
            add(R);
            //N초과되면 L 옮겨서 빼야함
            while (kind > N) {
                discount(L++);
            }
            //최대길이 갱신
            max = Math.max(max, R - L + 1);
        }
        System.out.println(max);
    }

    public static void add(int x) {
        alpha[str.charAt(x) - 'a']++;
        if (alpha[str.charAt(x) - 'a'] == 1)
            kind++;
    }

    public static void discount(int x) {
        alpha[str.charAt(x) - 'a']--;
        if(alpha[str.charAt(x)-'a'] == 0)
            kind--;
    }
}
