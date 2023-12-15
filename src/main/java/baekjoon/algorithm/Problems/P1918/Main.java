package baekjoon.algorithm.Problems.P1918;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s = br.readLine();
    Stack<Character> stack = new Stack<>();
    StringBuilder sb = new StringBuilder();
    for(int i =0 ; i < s.length(); i++){
      char now = s.charAt(i);
      switch(now){
        case '+':
        case '-':
        case '*':
        case '/':
          while(!stack.isEmpty() && compare(s.charAt(i)) <= compare(stack.peek())){
            sb.append(stack.pop());
          }
          stack.add(now);
          break;
        case '(':
          stack.add(now);
          break;
        case ')':
          while(!stack.isEmpty() && stack.peek() != '('){
            sb.append(stack.pop());
          }
          stack.pop();
          break;
        default:
          sb.append(now);
      }
    }

    while(!stack.isEmpty()){
      sb.append(stack.pop());
    }

    System.out.println(sb.toString());

  }

  public static int compare(char var){
    if (var == '(' || var==')'){
      return 0;
    } else if(var == '+' || var == '-'){
      return 1;
    } else if(var == '*' || var == '/'){
      return 2;
    }
    return -1;
  }
}
