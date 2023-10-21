class Solution {
    public int solution(int[] money) {
        int answer = 0;
        int N = money.length;
        int[] dp = new int[N];
        int[] dp2 = new int[N];
        // int[][] dp = new int[N][2];
        dp[0] = money[0];
        dp[1] = Math.max(money[0], money[1]);
        dp2[1] = money[1];
        
        for(int i=2;i<N-1;i++){
            dp[i] = Math.max(dp[i-2]+money[i], dp[i-1]);
            dp2[i] = Math.max(dp2[i-2]+money[i], dp2[i-1]);
            //System.out.println(dp[i][0] + " " + dp[i][1]);
        }
        
        answer = Math.max(dp2[N-3] + money[N-1], dp[N-2]);
        return answer;
    }
    
}
