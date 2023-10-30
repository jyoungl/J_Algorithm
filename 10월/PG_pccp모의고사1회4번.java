import java.util.*;
import java.io.*;

class Solution {
    public class Program {
        int score;
        int start;
        int time;
        
        public Program(int score, int start, int time){
            this.score = score;
            this.start = start;
            this.time = time;
        }
    }
    
    public long[] solution(int[][] program) {
        long[] answer = new long[11];
        //호출순서대로 정렬, 같으면 점수순으로 정렬
        PriorityQueue<Program> que = new PriorityQueue<>((p1,p2) -> {
            return p1.start - p2.start;
        });
        
        for(int i=0;i<program.length;i++){
            que.add(new Program(program[i][0], program[i][1], program[i][2]));    
        }
        
        Program now = que.poll();
        int end = now.start + now.time;
        //rest는 점수순으로 정렬
        PriorityQueue<Program> rest = new PriorityQueue<>((p1,p2) -> {
            if(p1.score == p2.score)
                return p1.start - p2.start;
            return p1.score - p2.score;
        });
        
        while(!que.isEmpty() || !rest.isEmpty()){
            int len = que.size();
            for(int i=0;i<len;i++){
                if(que.peek().start <= end)
                    rest.add(que.poll());
            }
            
            if(rest.isEmpty() && !que.isEmpty()){
                end = que.peek().start;
                rest.add(que.poll());
            }
            
            now = rest.poll();
            answer[now.score] += (end - now.start);
            end += now.time; //끝나는 시간
            
        }
        answer[0] = end;
        return answer;
    }
}
