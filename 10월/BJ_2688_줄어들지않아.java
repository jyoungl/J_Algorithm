import java.util.Scanner;

public class BJ_2688_줄어들지않아 {
    public static long [][] dp = new long [65][10];
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        StringBuilder sb = new StringBuilder();
        int max = Integer.MIN_VALUE;
        int[] answer = new int[N];

        for(int i=0;i<N;i++){
            int x = in.nextInt();
            max = Math.max(max, x);
            answer[i] = x;
        }

        for(int i=0;i<=9;i++)
            dp[1][i] = 1;

        check(max);

        for(int i=0;i<N;i++){
            long ans = 0;
            for(int last = 0; last<= 9; last++)
                ans += dp[answer[i]][last];
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }

    public static void check(int N){
        for(int i=2;i<=N;i++){
            for(int last = 0;last<=9;last++){
                for(int prev=0;prev<=last;prev++)
                    dp[i][last] += dp[i-1][prev];
            }
        }
    }
}
