import java.util.Scanner;

public class BJ_2018_수들의합5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int l = 1;
        int r = 2;
        int sum = l+r;
        int answer = 1;
        while(l<r){
            if(sum == N){
                answer++;
                sum -= l;
                l++;
            }

            if(sum<N){
                r++;
                sum += r;
            }
            else if(sum>N){
                sum -= l;
                l++;
            }
        }

        System.out.println(answer);
    }
}
