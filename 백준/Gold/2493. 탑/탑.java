import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		Stack<int[]> stack = new Stack<>();
		StringBuilder ans = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {

			int temp = Integer.parseInt(st.nextToken());

			while (!stack.isEmpty()) { 
				if(temp <= stack.peek()[0]) { 
					ans.append(stack.peek()[1] + " ");
					break;
				}
				stack.pop();
			}
			
			if(stack.isEmpty()) {
				ans.append(0 + " ");
			}
			
			stack.add(new int[] { temp, i + 1 });
		}

		System.out.println(ans);
	}
}

// LIFO