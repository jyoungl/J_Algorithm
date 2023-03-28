package mar28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1969_DNA_이주영 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String[] ch = new String[N];
        char[] dna = {'A','C','G','T'};
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            ch[i] = st.nextToken();
        }

        String ans = "";
        int count = 0;
        for (int i = 0; i < M; i++) {
            int[] alpha = new int[4]; // A C G T
            for (int j = 0; j < N; j++) {
                char[] c = ch[j].toCharArray();

                switch (c[i]) {
                    case 'A':
                        alpha[0]++;
                        break;
                    case 'C':
                        alpha[1]++;
                        break;
                    case 'G':
                        alpha[2]++;
                        break;
                    case 'T':
                        alpha[3]++;
                        break;
                }
            }
            int x = 0;
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < 4; j++) {
                if (max < alpha[j]) {
                    x = j;
                    max = alpha[j];   
                }
            }
            ans += dna[x];
            count += (N-max);
        }
        System.out.println(ans);
        System.out.println(count);
    }
}
