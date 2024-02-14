public class msadf {
    public static void main(String[] args) {
        boolean[] answer = new boolean[4];
        String[] a = {"abab", "bbaa", "bababa", "bbbabababbbaa"};

        for(int i=0;i<a.length;i++) {
            answer[i] = check(a[i]);
            System.out.println(answer[i]);
        }
    }

    public static boolean check(String str){
        while(str.length()>1){
            str = check_b(str);
            System.out.println(str);

            if(str.equals("a"))
                return true;

            str = check_a(str);
            System.out.println(str);
        }

        if(str.equals("a"))
            return true;
        else return false;
    }

    public static String check_a(String str){
        if(str.length() <=0)
            return "";

        if(str.charAt(0) == 'a')
            return str.substring(1);
        else if(str.charAt(str.length()-1) == 'a')
            return str.substring(0, str.length()-1);
        else
            return str;
    }

    public static String check_b(String str){
        int left_cnt = 0;
        int l_idx = 0;
        while(l_idx < str.length() && str.charAt(l_idx) == 'b') {
            left_cnt++;
            l_idx++;
        }

        int right_cnt = 0;
        int r_idx = str.length()-1;
        while(r_idx >= 0 && str.charAt(r_idx) == 'b'){
            right_cnt++;
            r_idx--;
        }

        System.out.println("cnt: " + left_cnt + " " + right_cnt);
        System.out.println("idx: " + l_idx + " " + r_idx);

        if(left_cnt == right_cnt){
            if(l_idx == str.length())
                return "";

            if(l_idx == r_idx){
                return String.valueOf(str.charAt(l_idx));
            }
            else
                str = str.substring(l_idx, r_idx);
        }

        return str;
    }
}
