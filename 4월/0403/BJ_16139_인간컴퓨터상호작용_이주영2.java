package apr03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_16139_인간컴퓨터상호작용_이주영2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] str = br.readLine().toCharArray();
        int q = Integer.parseInt(br.readLine());
        int[][] arr = new int[str.length+1][26];
        arr[1][str[0] - 'a']++;

        for (int i = 2; i <= str.length; i++) {
            int x = str[i-1] - 'a';
            for (int j = 0; j < 26; j++) {
                int before = arr[i - 1][j];
                arr[i][j] = (x == j ? before+1 : before);
            }
        }

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            char a = st.nextToken().charAt(0);
            int l = Integer.parseInt(st.nextToken())+1;
            int r = Integer.parseInt(st.nextToken())+1;
            int cnt = 0;
            cnt = arr[r][a - 'a'] - arr[l-1][a - 'a'];
            sb.append(cnt+"\n");
        }
        System.out.println(sb);
    }
}
