import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_15666_N과M12 {
    public static int[] visited;
    public static int N,M;
    public static int[] arr;
    public static HashSet<String> set = new HashSet<>();
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        visited = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        for(int i=0;i<N;i++){
            visited[i] = 1;
            func(arr[i], i, 0);
            visited[i] = 0;
        }

        System.out.print(sb);
    }
    public static void func(int x, int idx, int cnt){
        if(cnt == M-1){
            String str = "";
            for(int i=0;i<N;i++){
                if(visited[i]>0) {
                    for(int j=0;j<visited[i];j++) {
                        str += String.valueOf(arr[i]);
                        str += " ";
                    }
                }
            }
            if(!set.contains(str)) {
                set.add(str);
                sb.append(str).append("\n");
            }
            return;
        }
        for(int i=idx;i<N;i++){
            visited[i]++;
            func(arr[i], i, cnt+1);
            visited[i]--;
        }
    }

}
