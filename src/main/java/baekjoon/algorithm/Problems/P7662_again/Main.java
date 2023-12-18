package baekjoon.algorithm.Problems.P7662_again;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PriorityQueue<Integer> minQueue = new PriorityQueue<>();
    PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Comparator.reverseOrder());
    Map<Integer, Integer> hashMap = new HashMap<>();

    int T = Integer.parseInt(br.readLine());
    for(int o = 0; o < T; o++){
      int k = Integer.parseInt(br.readLine());
      while(k > 0){
        k--;
        String[] s = br.readLine().split(" ");
        String character = s[0];
        Integer integer = Integer.parseInt(s[1]);
        if(character.equals("I")){
          hashMap.put(integer, hashMap.getOrDefault(integer, 0) + 1);
          minQueue.add(integer);
          maxQueue.add(integer);
        } else if (character.equals("D")){
            if (hashMap.isEmpty()) {
              continue;
            } else {
              PriorityQueue<Integer> que = integer == 1 ? maxQueue : minQueue;
              removeQueue(que, hashMap);
            }
        }
      }
      if (hashMap.size() == 0)
        System.out.println("EMPTY");
      else {
        int n = removeQueue(maxQueue, hashMap);
        System.out.println(n + " " + (hashMap.size() > 0 ? removeQueue(minQueue, hashMap) : n));
      }

    }

  }

  public static int removeQueue(PriorityQueue<Integer> queue, Map<Integer, Integer> hashMap){
    int num;
    while(true){
      num = queue.poll();
      int cnt = hashMap.getOrDefault(num, 0);

      if(cnt == 0){
        continue;
      }
      if(cnt == 1){
        hashMap.remove(num);
      } else{
        hashMap.put(num, cnt-1);
      }
      break;
    }
    return num;
  }
}
