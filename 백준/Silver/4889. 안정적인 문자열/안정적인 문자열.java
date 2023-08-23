import java.io.*;
import java.util.*;

public class Main {

    public static void main(String [] args) throws IOException {
        new Main().stableString();
    }

    public void stableString() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int cnt = 1;
        while(true) {
             String tempString = br.readLine();
             if(tempString.contains("-")) {
                 break;
             }
             sb.append(cnt++).append(". ").append(leastCalculation(tempString)).append("\n");
        }

        System.out.println(sb.toString());
    }

    public int leastCalculation(String tempString) {
        int leastCount = 0;
        Stack<Character> stack = new Stack();

        for(int i = 0; i < tempString.length(); i++) {
            char tempChar = tempString.charAt(i);

            if(tempChar == '{') {
                stack.add(tempChar);
            }
            else {
                if(stack.isEmpty()) {
                    leastCount++;
                    stack.add('{');
                }
                else {
                    stack.pop();
                }
            }
        }

        int pairCount = 0;
        while(!stack.isEmpty()) {
            stack.pop();
            pairCount++;
        }

        return leastCount + pairCount / 2;

    }
}
