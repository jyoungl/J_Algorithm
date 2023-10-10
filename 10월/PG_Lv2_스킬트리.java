class Solution {
    public static boolean[] alpha = new boolean[43];
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for(int i=0;i<skill.length();i++){
            alpha[skill.charAt(i) - '0'] = true;
        }

        for(int i=0;i<skill_trees.length;i++){
            if(check(skill, skill_trees[i]))
                answer++;

        }
        return answer;
    }

    public boolean check(String order, String skill){
        int idx = 0;

        for(int i=0;i<skill.length();i++){
           if(!alpha[skill.charAt(i) - '0'])
               continue;

           if(order.charAt(idx) == skill.charAt(i)){
               idx++;
           }
            else
                return false;
        }

        return true;
    }
}
