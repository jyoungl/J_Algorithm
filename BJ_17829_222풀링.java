import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_17829_222풀링 {
    static int N;
    static int[][] origin;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        origin = new int[N][N];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                origin[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(divide(0,0,N));
    }

    public static int divide(int x, int y, int size){
        //기저조건
        if(size == 2){
            int[] arr = new int[4];
            int idx = 0;
            for(int i=x;i<x+2;i++){
                for(int j=y;j<y+2;j++){
                    arr[idx++] = origin[i][j];
                }
            }

            Arrays.sort(arr);
            return arr[2];
        }

        int[] arr = new int[4];
        size /= 2;
        arr[0] = divide(x,y,size);
        arr[1] = divide(x,y+size,size);
        arr[2] = divide(x+size, y, size);
        arr[3] = divide(x+size, y+size, size);

        Arrays.sort(arr);
        return arr[2];
    }
}
