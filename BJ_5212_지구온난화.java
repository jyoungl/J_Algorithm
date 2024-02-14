import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_5212_지구온난화 {
    static int N,M;
    static char[][] arr,carr;
    static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new char[N][M];
        carr = new char[N][M];
        for(int i=0;i<N;i++){
            arr[i] = br.readLine().toCharArray();
            for(int j=0;j<M;j++){
                carr[i][j] = arr[i][j];
            }
        }

        print_answer(change());
    }
    public static void print_answer(int[] ans){
        for(int i=ans[2];i<=ans[0];i++){
            for(int j=ans[3];j<=ans[1];j++)
                System.out.print(carr[i][j]);
            System.out.println();
        }
    }
    public static int[] change(){
        int[] range = {0,0,11,11};
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(arr[i][j] == 'X'){
                    int cnt = 0;
                    for(int d=0;d<4;d++){
                        int dx = i+dir[d][0];
                        int dy = j+dir[d][1];
                        if(dx<0||dy<0||dx>=N||dy>=M||arr[dx][dy]=='.')
                            cnt++;
                    }
                    if(cnt>=3)
                        carr[i][j] = '.';
                    else{
                        range[0] = Math.max(range[0], i);
                        range[1] = Math.max(range[1], j);
                        range[2] = Math.min(range[2], i);
                        range[3] = Math.min(range[3], j);
                    }

                }
            }
        }

        return range;
    }
}
