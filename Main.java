import java.util.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder ans = new StringBuilder();
		int T = Integer.parseInt(st.nextToken());

		for (int i = 0; i < T; i++) {
			Deque<Integer> dq = new LinkedList<>();
			String p = br.readLine();
			int n = Integer.parseInt(br.readLine());

			st = new StringTokenizer(br.readLine(), ",[]");
			while (dq.size() != n) {
				dq.add(Integer.parseInt(st.nextToken()));
			}
			System.out.println(AC(dq, p));

		}

		System.out.println(ans);

	}

	public static String AC(Deque dq, String p) {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		int r_cnt = 0;

		for (int i = 0; i < p.length(); i++) {
			char temp = p.charAt(i);
			{
				switch (temp) {
				case 'R':
					r_cnt++;
					break;
				case 'D':
					if (!dq.isEmpty()) {
						if (r_cnt % 2 == 0)		dq.poll();
						else	dq.pollLast();
					} else	return "error";
					break;
				}
			}
		}

		while (!dq.isEmpty()) {
			if (r_cnt % 2 == 0) {
				if (dq.size() != 1)		sb.append(dq.poll() + ",");
				else	sb.append(dq.poll());
			} else {
				if (dq.size() != 1) sb.append(dq.pollLast() + ",");
				else	sb.append(dq.pollLast());
			}
		}

		sb.append("]");
		return sb.toString();
	}
}
