package baekjoon.algorithm.Problems.P11053;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int[] dp = new int[N+1];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < N; i++){
            dp[i] = 1;
            for(int j = 0; j < i; j++){
                if(arr[j] < arr[i] && dp[i] < dp[j] + 1){
                    dp[i] = dp[j] +1;
                }
            }
        }

        int max_value = -1;
        for(int i =0; i < N; i++){
            max_value = dp[i] > max_value ? dp[i] : max_value;
        }

        System.out.println(max_value);
    }

}