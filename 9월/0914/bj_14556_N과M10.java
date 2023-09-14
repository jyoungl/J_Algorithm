import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BJ_15664_N과M10 {
    public static int N,M;
    public static int[] arr, ans;
    public static HashSet<String> set = new HashSet<>();
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        ans = new int[M];
        st = new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        for(int i=0;i<N;i++){
            ans[0] = arr[i];
            func(i,0);
        }
        System.out.print(sb);
    }
    public static void func(int x, int cnt){
        if(cnt == M-1){
            String str = "";
            for(int i=0;i<M;i++){
                str += String.valueOf(ans[i]);
                str += " ";
            }
            if(!set.contains(str)){
                set.add(str);
                sb.append(str).append("\n");
            }
            return;
        }
        for(int i=x+1;i<N;i++){
            ans[cnt+1] = arr[i];
            func(i, cnt+1);
        }
    }
}
