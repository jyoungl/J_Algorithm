import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        boolean[] Avisited = new boolean[A.length];
        boolean[] Bvisited = new boolean[B.length];
        Arrays.sort(A);
        Arrays.sort(B);
        int idx = B.length-1;
        
        for(int i=A.length-1;i>=0;i--){
            if(B[idx]>A[i]){
                Bvisited[idx--] = true;
                answer++;
            }
        }
        
        
        

        
        return answer;
    }

}
