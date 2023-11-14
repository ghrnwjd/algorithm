import java.util.*;
import java.io.*;

public class b1759 {

	static char[] used;
	static boolean[] visit;
	static int L, C;
	static ArrayList<Character> nums = new ArrayList<>();
	static ArrayList<String> ans = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		used = new char[C];

		String s = br.readLine();
		s = s.replace(" ", "");
		for (int i = 0; i < C; i++) {
			used[i] = s.charAt(i);
		}
		Arrays.sort(used);
		visit = new boolean[C];
		makeNum(0, 0);
		Collections.sort(ans);

		for (int i = 0; i < ans.size(); i++) {
			System.out.println(ans.get(i));
		}
	}

	public static void makeNum(int cnt, int index) {
		if (cnt == L) {
			int count = 0;

			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < L; i++) {
				if (nums.get(i) == 'a' || nums.get(i) == 'e' || nums.get(i) == 'o' || nums.get(i) == 'i'
						|| nums.get(i) == 'u') {
					count++;
				}
				sb.append(nums.get(i));
			}
			if (count > 0 && nums.size() - count >= 2)
				ans.add(sb.toString());
			
			return;
		}

		for (int i = index; i < C; i++) {
			if (!visit[i]) {
				visit[i] = true;
				nums.add(used[i]);
				makeNum(cnt + 1, i);
				nums.remove(nums.size() - 1);
				visit[i] = false;
			}
		}
	}
}
