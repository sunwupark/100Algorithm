package baekjoon.algorithm.Problems.P15787;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new int[N+1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken()); // 명령
            int k = Integer.parseInt(st.nextToken()); // 기차 번호
            int x = -1; // 좌석 번호 ( x가 1부터 시작해서 0부터로 바꿔주기 위해 초기값 -1로 설정, 이후 x에 입력값을 더하는 방식)
            switch (c){
                case 1:
                    x += Integer.parseInt(st.nextToken());
                    arr[k] |= (1 << x);
                    break;
                case 2:
                    x += Integer.parseInt(st.nextToken());
                    arr[k] &= ~(1 << x);
                    break;
                case 3:
                    arr[k] = (arr[k] & ~(1 << 19)) << 1;
                    break;
                case 4:
                    arr[k] = (arr[k] & ~(1 << 0)) >> 1;
                    break;
            }
        }

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            set.add(arr[i]);
        }
        System.out.println(set.size());
    }
}
