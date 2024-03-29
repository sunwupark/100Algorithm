package baekjoon.algorithm.Problems.P11726;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] dp= new int[1001];

        for(int i=1; i<= N; i++){
            if(i == 1){
                dp[i] = 1;
            } else if(i == 2){
                dp[i] = 2;
            } else{
                dp[i] = dp[i-1] + dp[i-2];
                dp[i] %= 10007;
            }
        }

        System.out.println(dp[N]);
    }
}
