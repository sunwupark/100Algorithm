package baekjoon.algorithm.Problems.P11047;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        int N = Integer.parseInt(arr[0]);
        long K = (long) Integer.parseInt(arr[1]);
        Stack<Long> stack = new Stack<>();

        for(int i =0; i< N; i++){
            stack.add(Long.valueOf(br.readLine()));
        }

        int total= 0;

        for(int i = 0; i < N; i++){
            Long temp = stack.pop();
            if(temp < K){
                int value = (int) (K/temp);
                total += value;
                K -= temp * value;
            }
        }
        System.out.println(total);
    }
}
