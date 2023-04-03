package apr03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BJ_16139_인간컴퓨터상호작용_이주영 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] str = br.readLine().toCharArray();
        int q = Integer.parseInt(br.readLine());
        StringTokenizer st;
        HashMap<Character, ArrayList<Integer>> map = new HashMap<>();

        for (int i = 0; i < str.length; i++) {
            ArrayList<Integer> now = new ArrayList<>();
            if (map.containsKey(str[i])) {
                now = map.get(str[i]);
                now.add(i);
                map.put(str[i], now);
            } else {
                now.add(i);
                map.put(str[i], now);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            char a = st.nextToken().charAt(0);
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int cnt = 0;

            if (map.containsKey(a)) {
                ArrayList<Integer> list = map.get(a);
                for (int j = 0; j < list.size(); j++) {
                    int x = list.get(j);
                    if (x >= l && x <= r)
                        cnt++;
                }
                sb.append(cnt + "\n");
            } else {
                sb.append("0\n");
            }

        }
        System.out.println(sb);
    }  
}
