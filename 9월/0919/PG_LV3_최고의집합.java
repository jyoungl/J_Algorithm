class Solution {
    public static int[] num;
    public static int[] answer;
    public static long max = 0;
    public static boolean b = false;
    public int[] solution(int n, int s) {
        answer = new int[n];
        num = new int[n];
        int[] no = {-1};
        
        for(int i=1;i<=9;i++){
            num[0] = i;
            func(1,i,s);   
        }
        
        if(!b)
            return no;
        else
            return answer;
    }
    public static void func(int cnt, int sum, int s){
        if(cnt == num.length){
            if(sum == s){
                b = true;
                long ans = 1;

                for(int j=0;j<num.length;j++){
                    ans *= num[j];
                }

                if(max<ans){
                    answer = num.clone();
                    max = ans;
                }    
            }           
            return;
        }
        
        for(int i=1;i<=9;i++){
            num[cnt] = i;
            if(sum+i>s)
                continue;
            
            func(cnt+1,sum+i,s);
        }
    }
}
