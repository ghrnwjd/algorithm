import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int f, s, g, u, d = 0;
	static boolean flag;
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		f = Integer.parseInt(st.nextToken()); // F층으로 이루어진 건물
		s = Integer.parseInt(st.nextToken()); // 현재 있는 층
		g = Integer.parseInt(st.nextToken()); // 스타트링크 층 수
		u = Integer.parseInt(st.nextToken()); // 위로 U층
		d = Integer.parseInt(st.nextToken()); // 아래로 D층
		
		int [] visited_cnt = new int [f+1];
		
		startLink(visited_cnt);
		if(flag) {
			System.out.println("use the stairs");
		}
		else {
			System.out.println(visited_cnt[g] - 1);
		}
		
	}

	public static void startLink(int [] visited_cnt) {		
		Queue<Integer> que = new LinkedList<>();
		visited_cnt[s] = 1;
		que.add(s);		
		
		while(!que.isEmpty()) {
			int quePeek = que.poll();
			
			if(quePeek == g) {
				return;
			}
			
			if(quePeek + u <= f) {
				if(visited_cnt[quePeek + u] == 0) {
					visited_cnt[quePeek + u] = visited_cnt[quePeek] + 1;
					que.add(quePeek + u);
				}
			}
			
			if(quePeek - d > 0) {
				if(visited_cnt[quePeek - d] == 0) {
					visited_cnt[quePeek - d] = visited_cnt[quePeek] + 1;
					que.add(quePeek - d);
				}
			}
		}	
		
		flag = true;	
		
		
	}
}

