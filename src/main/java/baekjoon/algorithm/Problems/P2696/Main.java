package baekjoon.algorithm.Problems.P2696;

import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(st.nextToken());

        while(T-->0){
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            sb.append((M+1)/2);
            sb.append("\n");

            // 최소 힙과 최대 힙을 설정
            // 최소 힙은 내림차순, 최대 힙은 오름차순으로 정렬해서 중앙값을 접근할 수 있도록
            PriorityQueue<Integer> minPQ = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> maxPQ = new PriorityQueue<>();

            int cnt = 0;
            for(int i=0;i<M;i++){
                // 입력 시 한 줄에 10개 입력
                if(i%10==0) st = new StringTokenizer(br.readLine());
                int var = Integer.parseInt(st.nextToken());

                // 두 힙의 사이즈가 같을 경우 : 제일 처음 포함 홀수 번째 --> 최대 힙에 저장
                // 두 힙의 사이즈가 다를 경우 : 짝수 번째 --> 최소 힙에 저장
                if(minPQ.size() == maxPQ.size()) maxPQ.add(var);
                else minPQ.add(var);

                // 값이 입력될 때마다 최소 힙의 최대값과 최대 힙의 최솟값과 비교해서 최소 힙의 최댓값이 최대 힙의 최솟값보다 크다면
                // 서로 다른 힙에 저장된 값이므로 교환
                if(!minPQ.isEmpty() && !maxPQ.isEmpty()){
                    if(minPQ.peek() > maxPQ.peek()){
                        int tmp = maxPQ.poll();
                        maxPQ.add(minPQ.poll());
                        minPQ.add(tmp);
                    }
                }

                // 홀수 번째 수를 읽을 때마다 중앙값 출력
                // 이 때 최대 힙 기준으로 값을 추가했기 때문에 최대 힙의 최솟값이 중앙값이 된다.
                if(i%2==0){
                    sb.append(maxPQ.peek());
                    sb.append(" ");

                    // 출력 개수가 10개여야 하므로 출력 조건이 10번 실행된 후에 줄바꿈이 진행되야 함
                    cnt++;

                    // 한 줄에 10개씩 출력
                    if(cnt%10==0) sb.append("\n");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}