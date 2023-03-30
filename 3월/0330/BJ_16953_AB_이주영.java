package mar30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import javax.lang.model.util.ElementScanner6;

public class BJ_16953_AB_이주영 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int count = 0;
        while (A <= B) {
            if (B == A) {
                System.out.println(count + 1);
                return;
            }
            if (B % 10 == 1) {
                B /= 10;
                count++;
            }
            else if (B % 2 == 0) {
                B /= 2;
                count++;
            }
            else {
                System.out.println("-1");
                return;
            }
        }
        System.out.println("-1");
    }
}
