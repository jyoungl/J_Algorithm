import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        HashSet<String> set = new HashSet<>();
        int end = 0;
        char alpha = words[0].charAt(0);
        for(int i=0;i<words.length;i++){
            String word = words[i];
            if(set.contains(word) || word.charAt(0) != alpha){
                end = i;
                break;
            }
            set.add(word);
            alpha = word.charAt(word.length()-1);
        }
        
        if(end != 0){
            answer[0] = end%n+1;
            answer[1] = end/n+1;
        }
        else{
            answer[0] = answer[1] = 0;
        }
        // // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다. 
        // System.out.println("Hello Java");
        return answer;
    }
}
