package baekjoon.algorithm.Problems.P13305;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] dist = new long[N-1];
        long[] price= new long [N];
        String[] string_dist = br.readLine().split(" ");
        String[] string_price = br.readLine().split(" ");

        for(int i =0; i < N-1; i++){
            dist[i] = Long.parseLong(string_dist[i]);
        }

        for(int i =0; i < N; i++){
            price[i] = Long.parseLong(string_price[i]);
        }

        int curr = 0;
        int distance = 0;
        long sum =0;
        while(distance != N-1){
            sum += price[curr]*dist[distance];
            distance+=1;
            if(price[curr] > price[distance]){
                curr = distance;
            }
        }
        System.out.println(sum);
    }
}
