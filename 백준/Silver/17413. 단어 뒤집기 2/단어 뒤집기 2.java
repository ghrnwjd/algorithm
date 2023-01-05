import java.util.*;
import java.io.*;

public class Main {
	static Stack<Character> stack = new Stack<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		
		StringBuilder ans = new StringBuilder();
		
		boolean flag = false;
		
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == '<') {
				popStack(ans);
				flag = true;				
			}			
			
			if(flag) {
				ans.append(s.charAt(i));
			}
			else {						
				if(s.charAt(i) == ' ') {					
					popStack(ans);
					ans.append(' ');
				}
				else {
				stack.add(s.charAt(i));	
				}
			}
			
			if(s.charAt(i) == '>') {
				flag = false;
			}
		}
		
		popStack(ans);
		System.out.println(ans.toString());			
	}
	
	public static void popStack(StringBuilder sb) {
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
	}
}
