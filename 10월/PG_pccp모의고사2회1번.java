class Solution {
    public int[] solution(String command) {
        int[] answer = {0, 0};
        int dir = 0; //0 위 1 오 2 아 3 왼
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        char[] com = command.toCharArray();
        for(int i=0;i<com.length;i++){
            char c = com[i];
            
            switch(c){
                case 'R':
                    dir += 1;
                    dir %= 4;
                    break;
                case 'L':
                    dir -= 1;
                    if(dir == -1)
                        dir = 3;
                    break;
                case 'G':
                    answer[0] += dr[dir];
                    answer[1] += dc[dir];
                    break;
                case 'B':
                    answer[0] += dr[(dir+2)%4];
                    answer[1] += dc[(dir+2)%4];
                    break;
            }
        }
        return answer;
    }
}
