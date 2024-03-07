package baekjoon.algorithm.Problems.P1931;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        int N = Integer.parseInt(br.readLine());
        Map<Integer, Integer> arr = new HashMap<>();
        List<Integer> arr2 = new ArrayList<>();

        for(int i =0; i < N; i++){
            String[] input =  br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            arr.put(a,b);
        }

        List<Integer> keylist = new ArrayList<>(arr.keySet());
        keylist.sort((a,b) -> a.compareTo(b));
        for (int key : keylist) {
            System.out.println("key: " + key + ", value: " + arr.get(key));
        }
    }
}
