import java.util.*;
import java.io.*;

class Solution {
     public int solution(int[][] routes) {
        int answer = 1;
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

        int end = list.get(0)[1];
        for(int i=1;i<list.size();i++){
            if(list.get(i)[0] <= end)
                continue;
            else {
                end = list.get(i)[1];
                answer++;
            }
        }

        return answer;
    }
}
