public class gabia {
    public static int max = 0;
    public static void main(String[] args) {
        String[] word = {"cent", "center", "term", "terminus", "rm", "min", "minus", "us"};
        String s = "centerminus";
        int x = solution(s, word);
        System.out.println(x);
    }

    public static int solution(String s, String[] word_dict){
        int answer = 0;

        for(int i=0;i<word_dict.length;i++){
            String str = s;
            max = 0;
            check(str, word_dict, 0);
        }

        return max;
    }

    public static void check(String str, String[] word_dict, int cnt){
        if(str.length() == 1){
            max = Math.max(max, cnt);
            System.out.println("cnt --- " + cnt);
            return;
        }

        for(int i=0;i<word_dict.length;i++){
            if(!str.contains(word_dict[i]))
                continue;

            int len = word_dict[i].length();
            System.out.println("word: " + word_dict[i]);
            System.out.println("str: " + str.substring(0, len));
            if(word_dict[i].equals(str.substring(0, len))) {
//                str = str.replaceFirst(word_dict[i], String.valueOf(word_dict[i].charAt(len-1)));
                System.out.println(str.replaceFirst(word_dict[i], String.valueOf(word_dict[i].charAt(len-1))));
                check(str.replaceFirst(word_dict[i], String.valueOf(word_dict[i].charAt(len-1))), word_dict, cnt+1);
            }
        }

        return;
    }
}
