package apr07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;

public class BJ_20291_파일정리_이주영 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String s = br.readLine().split("\\.")[1];
        

            if (map.containsKey(s)) {
                int x = map.get(s);
                map.put(s, x + 1);
            } else
                map.put(s, 1);
        }
        
        PriorityQueue<String> que = new PriorityQueue<>();
        for (String s : map.keySet()) {
            que.add(s);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < map.size(); i++) {
            String s = que.poll();
            sb.append(s + " " + map.get(s)).append("\n");
        }
        System.out.println(sb);
    }
}
