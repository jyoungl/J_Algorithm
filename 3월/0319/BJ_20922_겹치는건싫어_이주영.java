package mar18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_20922_겹치는건싫어_이주영 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }//입력
        int[] visited = new int[200001]; //숫자 몇 개 썼는지 기록할 배열
        int max = Integer.MIN_VALUE; // 정답 저장
        int start = 0; //시작 포인터
        int end = 0; // 끝 포인터

        //시작 포인터 <= 끝 포인터여야 하고, 끝 포인터는 길이보다 작아야함
        while (start <= end && end < N) {
            //겹치는 수가 K개 이하인 경우. 계속 끝 포인터를 증가시켜 앞으로 나감
            if (end < N && visited[arr[end]] < K) {
                visited[arr[end]]++;
                end++;
            }
            //겹치는 수가 K개가 됐음. 시작 포인터를 끌어와서 겹치는 수 빼줘야함
            //예제 1의 경우 5를 하나 빼줘야 다시 앞으로 나갈 수 있음
            else if (visited[arr[end]] == K) {
                visited[arr[start]]--;
                start++;
            }
            //최대 길이 계속 갱신해줌
            max = Math.max(max, end - start); //이러면 끝 ~
        }
        System.out.println(max);
    }
}
