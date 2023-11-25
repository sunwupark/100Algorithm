package baekjoon.algorithm.Problems.P1935;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(bufferedReader.readLine());
    String expression = bufferedReader.readLine();
    double[] arr = new double[N];

    for (int i = 0; i < N; i++) {
      arr[i] = (Double.parseDouble(bufferedReader.readLine()));
    }

    Stack<Double> stack = new Stack<>();

    double result = 0;
    for (int i = 0; i < expression.length(); i++) {
      if ('A' <= expression.charAt(i) && expression.charAt(i) < 'Z') {
        stack.push(arr[expression.charAt(i) - 'A']);
      } else {
        if (!stack.isEmpty()) {
          double first = stack.pop();
          double second = stack.pop();
          switch (expression.charAt(i)) {
            case '+':
              result = second + first;
              stack.push(result);
              continue;
            case '-':
              result = second - first;
              stack.push(result);
              continue;
            case '*':
              result = second * first;
              stack.push(result);
              continue;
            case '/':
              result = second / first;
              stack.push(result);
              continue;
          }
        }
      }
    }
    System.out.printf("%.2f", stack.pop());
    bufferedReader.close();
  }
}
