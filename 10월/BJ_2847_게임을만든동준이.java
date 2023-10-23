import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2847_게임을만든동준이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int answer = 0;
        for(int i=N-2;i>=0;i--){
            int x = 0;
            if(arr[i+1] <= arr[i]){
                x = arr[i] - arr[i+1] + 1;
            }
            answer += x;
            arr[i] -= x;
        }
        System.out.println(answer);
    }
}
