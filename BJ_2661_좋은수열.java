import java.util.Scanner;

public class BJ_2661_좋은수열 {
    static int N;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        String str = "";
        back(str, 0);
    }

    public static void back(String str, int cnt){
        if(cnt == N){
            System.out.println(str);
            System.exit(0);
            return;
        }

        for(int i=1;i<=3;i++){
            if(check(str+String.valueOf(i))){
                back(str+String.valueOf(i), cnt+1);
            }
        }
    }

    public static boolean check(String s){
        int len = s.length();

        for(int i=0;i<len/2;i++){
            String x = s.substring(len-2*(i+1),len-(i+1));
            String y = s.substring(len-(i+1),len);
            if(x.equals(y))
                return false;
        }
        return true;
    }
}
