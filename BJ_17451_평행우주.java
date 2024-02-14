import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_17451_평행우주 {
    static long[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] distance = new long[N];
        long max = Integer.MIN_VALUE;
        int idx = 0;
        for(int i=0;i<N;i++) {
            distance[i] = Integer.parseInt(st.nextToken());
            if(max<distance[i]){
                max= distance[i];
                idx = i;
            }
        }

        if(max == distance[0]){
            System.out.println(max);
            return;
        }

        arr = new long[idx];
        for(int i=0;i<idx;i++)
            arr[i] = distance[i];

        Arrays.sort(arr);
        long l = max;
        long r = (long)1e15;
        long answer = distance[0];
        while(l<=r){
            long mid = (l+r)/2;
//            System.out.println(mid);
            if(check(mid, max)){
                answer = mid;
                r = mid-1;
            }
            else
                l = mid+1;
        }

        System.out.println(answer);
    }
    public static boolean check(long x, long max){
        for(int i=0;i<arr.length;i++){
            if(x%arr[i] != 0){
                if(x/arr[i]>=1){
                    x -= (x%arr[i]);
                    continue;
                }
                else return false;
            }
        }
//        System.out.println("X: "+x+" max: "+max);
        if(x>=max) {
//            System.out.println("True");
            return true;
        }
        else
            return false;
    }
    public static long getLCM(long[] arr){
        if(arr.length == 1)
            return arr[0];

        long gcd = getGCD(arr[0], arr[1]);
        long l = (arr[0]*arr[1])/gcd;

        for(int i=2;i<arr.length;i++){
            gcd = getGCD(l, arr[i]);
            l = (l*arr[i])/gcd;
        }

        return l;
    }
    public static long getGCD(long num1, long num2){
        if(num1%num2==0)
            return num2;

        return getGCD(num2, num1%num2);
    }
}
