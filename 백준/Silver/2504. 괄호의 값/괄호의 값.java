import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String bracket = br.readLine();
		
		Stack<Character> stack = new Stack<>();		
		
        int result = 0;
        int value = 1;

        for(int i = 0; i < bracket.length(); i++) {
            if(bracket.charAt(i) == '(') { 
                stack.push(bracket.charAt(i)); 
                value *= 2; //( : 2
            } 
            else if(bracket.charAt(i) == '[') {
                stack.push(bracket.charAt(i)); 
                value *= 3; //[ : 3
            } 
            else if(bracket.charAt(i) == ')') {
                if(stack.isEmpty() || stack.peek() != '(') { 
                    result = 0;
                    break;
                } 
                else if(bracket.charAt(i-1) == '(') {
                    result += value;
                }
                stack.pop();
                value /= 2;
            } 
            else if(bracket.charAt(i) == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    result = 0;
                    break;
                } 
                else if (bracket.charAt(i - 1) == '[') {
                    result += value;
                }
                
                stack.pop();
                value /= 3;
            }
        }
        
        if(!stack.isEmpty()) {
        	System.out.println(0);
        }
        else {
        	System.out.println(result);
        }
        
	}

}
