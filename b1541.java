import java.util.*;
import java.io.*;

class b1541 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), "-");
		
		ArrayList<String> al = new ArrayList<>();
		ArrayList<Integer> ans = new ArrayList<>();
		
		while(st.hasMoreTokens()) {
			al.add(st.nextToken());
		}
		
		for(int i =0;i < al.size(); i++) {
			if(al.get(i).contains("+")) {
				st = new StringTokenizer(al.get(i), "+");
				int temp = 0;
				while(st.hasMoreTokens()) {
					temp += Integer.parseInt(st.nextToken());
				}
				ans.add(temp);
			}
			else {
				ans.add(Integer.parseInt(al.get(i)));
			}			
		}
		
		int answer = ans.get(0);
		for(int i = 1; i < ans.size(); i++) {
			answer -= ans.get(i);
		}
		
		System.out.println(answer);		
	}
}
