class Solution {
    public int solution(String name) {
        char[] c_name = name.toCharArray();
        int stack = c_name.length - 1;
        int answer = 0;
        
        for(int i=0;i<name.length();i++){
            answer += updown(c_name[i]);
            
            if(i+1 < c_name.length && c_name[i+1] == 'A'){ //다음칸이 A이면 A가 끝나는 지점 찾기
                int endA = i+1;
                while(endA < name.length() && c_name[endA] == 'A')
                    endA++;
                
                stack = Math.min(stack, i*2 + (c_name.length - endA)); //오른쪽으로 갔다가 다시 왼쪽으로 이동한 경우
                stack = Math.min(stack, (c_name.length - endA)*2 + i); //왼쪽으로 갔다가 다시 오른쪽으로 이동한 경우
            }
        }
        
        return answer + stack;
    }
    
    public static int updown(char target){
        return Math.min(target - 'A', 'Z'-target+1);
    }
}
