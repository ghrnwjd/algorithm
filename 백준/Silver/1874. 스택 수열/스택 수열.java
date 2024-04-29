import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
      static Stack<Integer> stack = new Stack<>();
      static StringBuilder ans = new StringBuilder();
      static int pointer = 0;
      static boolean flag = true;
      public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());

            for(int i = 0; i < N; i++) {
                  int value = Integer.parseInt(br.readLine());
                  push(value);
                  pop(value);
                  if(!flag) break;
            }

            if(flag) System.out.println(ans.toString());
            else System.out.println("NO");

      }
      static void push(int value) {
            for(int i = pointer + 1; i <= value; i++) {
                  stack.push(i);
                  ans.append("+").append("\n");
            }
            pointer = (value > pointer) ? value : pointer;
      }

      static void pop(int value) {
            if(stack.peek() == value) {
                  stack.pop();
                  ans.append("-").append("\n");
            }
            else {
                  flag = false;
            }
      }
}
