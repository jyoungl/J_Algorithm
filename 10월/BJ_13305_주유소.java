import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BJ_13305_주유소 {
    public static class Oil {
        int price; // 가격
        int index; // 순서

        public Oil(int index, int price){
            this.price = price;
            this.index = index;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] road = new int[N-1];
        ArrayList<Oil> list = new ArrayList<>();
        boolean[] visited = new boolean[N-1];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N-1;i++){
            road[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            list.add(new Oil(i, Integer.parseInt(st.nextToken())));
        }

        list.sort(new Comparator<Oil>(){
            @Override
            public int compare(Oil o1, Oil o2){
                return o1.price - o2.price;
            }
        });

        long answer = 0;
        for(int i=0;i<list.size();i++){
            Oil now = list.get(i);
            //맨 마지막 마을이면 기름 살 필요 x
            if(now.index >= N-1)
                continue;
            
            for(int j=now.index;j<N-1;j++) {
                if(visited[j])
                    break;
                answer += (road[j] * (long)now.price);
                visited[j] = true;
            }
        }
        System.out.println(answer);
    }
}
