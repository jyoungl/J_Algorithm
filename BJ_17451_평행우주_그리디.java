import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_17451_평행우주_그리디 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] distance = new long[N];

        for(int i=0;i<N;i++) {
            distance[i] = Integer.parseInt(st.nextToken());
        }

        long answer = distance[N-1];
        for(int i=N-2;i>=0;i--){
            if(answer<=distance[i])
                answer = distance[i];
            else{
                if(answer%distance[i]==0)
                    continue;
                answer = distance[i]*(answer/distance[i]+1);
            }
        }

        System.out.print(answer);
    }
}
