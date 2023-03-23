package mar23;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class BJ_1644_소수의연속합_이주영 {
    static boolean[] arr;
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        
        if (N == 1) {
            System.out.println("0");
        }
        
        arr = new boolean[N + 1];
        arr[0] = arr[1] = true;
        elatos(N);

        ArrayList<Integer> prime = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            if (!arr[i])
                prime.add(i);
        }
        
        int lp = 0;
        int rp = 0;
        int sum = prime.get(lp);
        int ans = 0;
        while (lp <= rp) {
            if (sum < N) {
                rp++;
                if (rp >= prime.size())
                    break;
                sum += prime.get(rp);
            } else if (sum > N) {
                sum -= prime.get(lp);
                lp++;
            } else {
                ans++;
                if (rp + 1 == prime.size())
                    break;
                rp++;
                sum += prime.get(rp);
            }
        }
        System.out.println(ans);
    }

    public static void elatos(int N) {
        for (int i = 2; i*i <= N; i++) {
            if (!arr[i]) {
                for(int j=i*i;j<=N;j+=i)
                    arr[j] = true;
            }
        }
    }
}
