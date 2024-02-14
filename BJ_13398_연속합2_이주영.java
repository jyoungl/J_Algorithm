import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BJ_13398_연속합2_이주영 {
    public static void main(String[] args) throws IOException {
        int[][] routes = {{20,-15}, {-14,-5}, {-18,-13}, {-5,-3}};
        System.out.println(solution(routes));
    }

    public static int solution(int[][] routes) {
        int answer = 0;
        ArrayList<int[]> list = new ArrayList<>();

        for(int i=0;i<routes.length;i++){
            list.add(new int[] {routes[i][0], routes[i][1]});
        }

        list.sort(new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[1] - o2[1];
            }
        });

        int end = list.get(0)[0];
        answer++;
        for(int i=1;i<list.size();i++){
            if(list.get(i)[1] < end){
                answer++;
                end = list.get(i)[0];
            }
            else
                continue;
        }

        return answer;
    }
}
