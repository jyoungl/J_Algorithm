package mar27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BJ_1253_좋다_이주영 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        if (N <= 2) {
            System.out.println("0");
            return;
        }

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(st.nextToken());
            list.add(x);
        }
        Collections.sort(list);
        int ans = 0;
        for (int i = 0; i < list.size(); i++) {
            int lp = 0;
            int rp = list.size() - 1;

            while (lp < rp) {
                if (lp == i) {
                    lp++;
                    continue;
                }
                else if (rp == i) {
                    rp--;
                    continue;
                }

                int sum = list.get(lp) + list.get(rp);
                if (sum == list.get(i)) {
                    ans++;
                    break;
                } else if (sum < list.get(i)) {
                    lp++;
                } else {
                    rp--;
                }
            }
        }
        System.out.println(ans);
    }
}
