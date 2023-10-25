import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] ability, int number) {
        int answer = 0;
        PriorityQueue<Integer> que = new PriorityQueue<>();
        for(int i=0;i<ability.length;i++)
            que.add(ability[i]);
        
        for(int i=0;i<number;i++){
            int sum = que.poll() + que.poll();
            que.add(sum);
            que.add(sum);
        }
        
        while(!que.isEmpty()){
            answer += que.poll();
        }
        return answer;
    }
}
