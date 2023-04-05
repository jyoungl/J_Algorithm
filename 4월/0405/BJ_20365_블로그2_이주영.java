package apr05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_20365_블로그2_이주영 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[] ch = br.readLine().toCharArray();
        int blue = 0;
        int red = 0;

        boolean rcheck = false;
        boolean bcheck = false;
        for (int i = 0; i < N; i++) {
            if (ch[i] == 'R' && !rcheck) {
                blue++;
                rcheck = true;
            }
            else if (rcheck && ch[i] == 'B')
                rcheck = false;

            if (ch[i] == 'B' && !bcheck) {
                red++;
                bcheck = true;
            }
            else if (bcheck && ch[i] == 'R')
                bcheck = false;
        }
        
        System.out.println(Math.min(red, blue)+1);
    }
}
