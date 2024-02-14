import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_5464_주차장 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> parking = new PriorityQueue<>();
        Queue<Integer> car = new LinkedList<>();

        for(int i=1;i<=N;i++)
            parking.add(i);

        int[] car_w = new int[M+1]; //차 무게
        int[] park_fee = new int[N+1]; //단위 무게당 요금
        int[] car_parking = new int[M+1]; //차가 어디 주차했는지 저장
        int answer = 0;

        //주차장 요금
        for(int i=1;i<=N;i++)
            park_fee[i] = Integer.parseInt(br.readLine());
        //차량 무게
        for(int i=1;i<=M;i++)
            car_w[i] = Integer.parseInt(br.readLine());
        //주차장 출입 순서
        for(int i=0;i<2*M;i++){
            int now = Integer.parseInt(br.readLine());

            if(now>0){
                //차량 주차시켜야함
                if(!parking.isEmpty()){
                    int num = parking.poll();
//                    answer += (park_fee[num] * car_w[now]);
                    car_parking[now] = num;
                }
                else{
                    car.add(now);
                }
            }
            else if(now<0){
                int x = car_parking[Math.abs(now)];
                parking.add(x);
                answer += (park_fee[x] * car_w[Math.abs(now)]);

                if(!car.isEmpty()){
                    int num = car.poll();
//                    answer += (park_fee[x] * car_w[num]);
                    car_parking[num] = x;
                    parking.poll();
                }
            }

        }
        System.out.println(answer);
    }
}
