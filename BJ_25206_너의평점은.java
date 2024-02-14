import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_25206_너의평점은 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        double answer = 0;
        double count = 0;
        for(int i=0;i<20;i++){
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            double grade = Double.parseDouble(st.nextToken());
            char[] score = st.nextToken().toCharArray();
            if(score[0] == 'P')
                continue;
            if(score[0] == 'F'){
                count += grade;
                continue;
            }
            answer += calcurate(grade, score);
            count += grade;
//            System.out.println(calcurate(grade, score) + " " + count);
        }

        System.out.println(Math.round(answer/count*10000)/10000.0);
    }
    public static double calcurate(double grade, char[] score){
        double avg = 0;
        switch(score[0]){
            case 'A':
                avg += 4.0;
            break;
            case 'B':
                avg += 3.0;
                break;
            case 'C':
                avg += 2.0;
                break;
            case 'D':
                avg += 1.0;
                break;
            default:
                avg += 0.0;
                break;
        }

        if(score[1] == '+')
            avg += 0.5;

        return grade*avg;
    }
}
