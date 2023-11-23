package baekjoon.algorithm.Problems.P18258;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
  public static void main(String[] args) throws IOException {
    Queue<Integer> queue = new LinkedList<>();
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    Integer s = Integer.parseInt(bufferedReader.readLine());

    for (int i = 0; i < s; i++) {
      String[] s1 = bufferedReader.readLine().split(" ");
      switch (s1[0]) {
        case "push":
          queue.add(Integer.parseInt(s1[1]));
          break;
        case "pop":
          if (queue.isEmpty()) {
            System.out.println(-1);
          } else {
            System.out.println(queue.poll());
          }
          break;
        case "size":
          System.out.println(queue.size());
          break;
        case "empty":
          if (queue.isEmpty()) {
            System.out.println(1);
          } else {
            System.out.println(0);
          }
          break;
        case "front":
          if (queue.isEmpty()) {
            System.out.println(-1);
          } else {
            System.out.println(queue.peek());
          }
          break;
        case "back":
          if (queue.isEmpty()) {
            System.out.println(-1);
          } else {
            System.out.println(((LinkedList<Integer>) queue).getLast());
          }
          break;
      }
    }
  }
}

