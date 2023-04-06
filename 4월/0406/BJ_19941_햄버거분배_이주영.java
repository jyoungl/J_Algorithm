package apr06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_19941_햄버거분배_이주영 {
    public static boolean[] visited;
    public static char[] arr;
    public static int N,M;
    public static int max = Integer.MIN_VALUE;
    public static ArrayList<Integer> person;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = br.readLine().toCharArray();
        visited = new boolean[N];
        person = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if (arr[i] == 'P')
                person.add(i);
        }
        
        func(0, 0);
        System.out.println(max);
    }
    
    public static void func(int cnt, int now) {
        if (cnt == person.size()) {
            max = Math.max(max, now);
            return;
        }

        int p = person.get(cnt);
        boolean b = false;
        for (int i = p - M; i <= p + M; i++) {
            if (i < 0 || i >= N || arr[i] == 'P' || visited[i])
                continue;

            visited[i] = true;
            b = true;
            func(cnt + 1, now + 1);
            visited[i] = false;   
        }
        
        if (!b) {
            func(cnt + 1, now);
        }
    }
}
