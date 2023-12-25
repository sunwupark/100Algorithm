package baekjoon.algorithm.Problems.P7662_again2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int p = 0; p < T; p++){
            PriorityQueue<Integer> minpq = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> maxpq = new PriorityQueue<>();
            int k = Integer.parseInt(br.readLine());
            Map<Integer, Integer> map = new HashMap<>();
            for(int l = 0; l < k; l++){
                String[] s = br.readLine().split(" ");
                int num = Integer.parseInt(s[1]);

                switch (s[0]){
                    case "I":
                        map.put(num, map.getOrDefault(num, 0) + 1);
                        maxpq.add(Integer.parseInt(s[1]));
                        minpq.add(Integer.parseInt(s[1]));
                        break;
                    case "D":
                        if(map.size() == 0){
                            break;
                        }
                        PriorityQueue<Integer> queue = num == 1? maxpq: minpq;
                        removeMap(queue, map);
                        break;
                }
            }
            if(map.size() == 0){
                System.out.println("EMPTY");
            }
            else {
                int n = removeMap(maxpq, map);
                System.out.println(n + " " + (map.size() > 0 ? removeMap(minpq, map) : n));
            }
        }
    }

    static int removeMap(PriorityQueue<Integer> que, Map<Integer, Integer> map){
        int num;
        while(true){
            num = que.poll();
            int cnt = map.getOrDefault(num, 0);
            if(cnt == 0)
                continue;
            if(cnt == 1)
                map.remove(num);
            else
                map.put(num, cnt-1);
            break;
        }
        return num;
    }
}
