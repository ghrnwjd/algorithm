import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken()); // T개의 테스트케이스
		StringBuilder ans = new StringBuilder();
		
		for(int i = 0; i < T; i++) {
			Stack<Character> stack = new Stack();
			String temp = br.readLine();
			boolean isEmpty = false;
			for(int j = 0; j < temp.length(); j++) {
				if(temp.charAt(j) == '(') {
					stack.add('(');
				}
				else {
					if(stack.isEmpty()) { // 비어있는데 뺄 수는 없기 때문에
						isEmpty = true;
						break;
					}
					stack.pop();
				}
			}
			if(!stack.isEmpty() || isEmpty) { // 과정을 완료하고도 남아있는 괄호가 있거나 불린값이 false인 경우 -> 실패
				ans.append("NO \n");
			}
			else {
				ans.append("YES \n");
			}
		}
		
		System.out.println(ans.toString());
		
	}
}
