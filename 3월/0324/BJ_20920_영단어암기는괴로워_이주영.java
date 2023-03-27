package mar22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BJ_20920_영단어암기는괴로워_이주영 {
    public static class Word {
        String word;
        int cnt;
        int length;

        public Word(String word, int cnt, int length) {
            this.word = word;
            this.cnt = cnt;
            this.length = length;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<Word> list = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String str = br.readLine();

            if (str.length() < M)
                continue;

            if (map.containsKey(str)) {
                int x = map.get(str);
                map.put(str, x + 1);
            } else {
                map.put(str, 1);
            }
        }
        
        for (String str : map.keySet()) {
            list.add(new Word(str, map.get(str), str.length()));
        }

        list.sort(new Comparator<Word>() {
            @Override
            public int compare(Word o1, Word o2) {
                if (o1.cnt == o2.cnt) {
                    if (o1.length == o2.length) {
                        return o1.word.compareTo(o2.word);
                    }
                    return o2.length - o1.length;
                }
                else {
                    return o2.cnt - o1.cnt;
                }
            } 
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i).word + "\n");
        }
        System.out.println(sb);
    }
}
