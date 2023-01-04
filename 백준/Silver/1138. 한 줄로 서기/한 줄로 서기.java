import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 사람의 수
		int height [] = new int [N];
		ArrayList<Integer> ans = new ArrayList<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			height[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = N-1; i >=0; i--) {
			ans.add(height[i], i+1);
		}
		
		for(int i = 0; i < ans.size(); i++) {
			System.out.print(ans.get(i) + " ");
		}
		
	}
}
