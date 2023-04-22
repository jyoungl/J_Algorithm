package apr22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BJ_10025_게으른백곰 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        ArrayList<int[]> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) });
        }
        
        list.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        int l = 0;
        int r = 0;
        int sum = 0, max = 0;
        int d = 2 * K + 1;

        while (r < N) {
            if (list.get(r)[1] - list.get(l)[1] <= d) {
                sum += list.get(r++)[0];
                max = Math.max(max, sum);
            } else {
                sum -= list.get(l++)[0];
            }
        }
        System.out.println(max);
    }
}
