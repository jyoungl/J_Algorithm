package mar29;

import java.util.Scanner;

public class BJ_5585_거스름돈_이주영 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int x = 1000 - N;
        int answer = 0;
    
        if (x > 500) {
            x -= 500;
            answer++;
        }
            
        if (x > 100) {
            answer += x / 100;
            x = x % 100;
        }
        
        if (x > 50) {
            x -= 50;
            answer++;
        }

        answer += x / 10;
        x %= 10;
        answer += x / 5;
        answer += x % 5;
        System.out.println(answer);
    }
}
