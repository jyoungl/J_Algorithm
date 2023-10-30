class Solution {
    public static String[] bean = {"RR", "Rr", "rr"};
    public static int ans = -1;
    public String[] solution(int[][] queries) {
        String[] answer = new String[queries.length];
        
        for(int i=0;i<queries.length;i++){
            int gen = queries[i][0];
            int order = queries[i][1];

            if(gen == 1){
                answer[i] = bean[1];
                continue;
            }
            else if(gen == 2){
                if(order == 1)
                    answer[i] = bean[0];
                else if(order == 2 || order == 3)
                    answer[i] = bean[1];
                else
                    answer[i] = bean[2];
                continue;
            }
            int[] pow = new int[gen-2];
            int cnt = 0;
            while(gen>2){
                pow[cnt++] = order%4;
                order = (order/4)+1;
                gen--;
            }
            
            for(int j=pow.length-1;j>=0;j--){
                order = choose(order, pow[j]);
            }
            answer[i] = bean[order-1];
        }
        return answer;
    }

    
    //1:RR , 2:Rr , 3:rr
    public int choose(int order, int x){
        switch(order){
            case 1:
                return 1;
            case 2,3:
                if(x == 1)
                    return 1;
                else if(x==2 || x == 3)
                    return 2;
                else
                    return 3;
            default:
                return 3;
        }
    }
}
