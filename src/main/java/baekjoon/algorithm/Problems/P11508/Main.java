package baekjoon.algorithm.Problems.P11508;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[N];

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr, Collections.reverseOrder());
        int total = 0;
        boolean isFalse = true;

        for(int i = 1; i <= N;i++){
            if(i%3 != 0){
                total += arr[i-1];
            }
        }

        System.out.println(total);
    }
}
