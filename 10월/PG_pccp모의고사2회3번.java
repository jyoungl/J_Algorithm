class Solution {
    public int solution(int[] menu, int[] order, int k) {
        int answer = 1;
        
        int i=0;
        int wait = 1; //기다리는 사람 수
        int next = k; //다음 손님 올 시간
        int end = menu[order[i]]; //첫번째 손님 음료 다 만드는 시간
        int time = 0;
        
        while(true){
            if(i == order.length)
                break;
            //음료 완성
            if(end == time){
                i++;
                wait--; //대기 손님 감소
                // System.out.println("1번 " + wait + " " + end + " " + time);
                if(i == order.length)
                    continue;
                if(wait != 0)
                    end += menu[order[i]]; //다음 음료 다 만드는 시간
            }
            //다음 손님 옴
            if(next == time && next <= (order.length-1)*k){
                // System.out.println(wait + " " + end + " " + time);
                if(wait == 0)
                    end = time + menu[order[i]];
                wait++;
                answer = Math.max(answer, wait);
                next += k;
            }
            // System.out.println("time++");
            time++;
        }
        return answer;
    }
}
