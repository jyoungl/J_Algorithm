class Solution
{
    public int solution(String s)
    {
        int answer = 0;
        boolean[][] palin = new boolean[s.length()][s.length()];
    
        if(s.length() <= 1)
            return s.length();
        
        for(int i=0;i<s.length()-1;i++){
            palin[i][i] = true; //길이 1
            
            if(s.charAt(i) == s.charAt(i+1)){
                palin[i][i+1] = true; //길이 2
            }
        }
    
        for(int i=2;i<s.length();i++){
            for(int j=0;j<s.length();j++){
                int sIdx = j;
                int eIdx = j+i;
                
                if(eIdx>=s.length())
                    continue;
                    
                if(s.charAt(sIdx) == s.charAt(eIdx)){
                    
                    if(palin[sIdx+1][eIdx-1]){
                        palin[sIdx][eIdx] = true;
                        answer = Math.max(answer, eIdx-sIdx+1);
                    }
                }
            }
        }
    
        return answer;
    }
}
