import java.util.*;
import java.io.*;

class Solution {
    public String solution(String input_string) {
        String answer = "";
        HashSet<Character> set = new HashSet<>();
        char[] ch = input_string.toCharArray();
        boolean[] visited = new boolean[57];
        char now = ch[0];
        visited[now-'a'] = true;
        
        for(int i=1;i<ch.length;i++){
            if(now == ch[i])
                continue;
            
            now = ch[i];
            if(!visited[ch[i]-'a']){
                visited[ch[i]-'a'] = true;
            }
            else{
                set.add(ch[i]);
            }
        }
        
        ArrayList<Character> list = new ArrayList<>(set);        
        Collections.sort(list);
        for(int i=0;i<list.size();i++)
            answer += list.get(i);
        
        if(list.size() == 0)
            answer = "N";
        
        return answer;
    }
}
