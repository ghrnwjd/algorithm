import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		ArrayList<Integer> crain = new ArrayList<>();
		ArrayList<Integer> box = new ArrayList<>();
		
		int n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < n; i++) {			
			crain.add(Integer.parseInt(st.nextToken()));
		}
		
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < m; i++) {			
			box.add(Integer.parseInt(st.nextToken()));
		}
		
		Collections.sort(crain, Collections.reverseOrder());
		Collections.sort(box, Collections.reverseOrder());
		
		if(box.get(0) > crain.get(0)) {
			System.out.println(-1);
			return;			
		}
		
		int cnt = 0;
		
		while(!box.isEmpty()) {			
			int idx = 0;
			for(int i = 0; i < n;) {
				if(idx == box.size()) break;
				else if(crain.get(i) >= box.get(idx)) {
					box.remove(idx);
					i++;
				}
				else {
					idx++;
				}
			}	
			
			cnt ++;
		}	
		
		System.out.println(cnt);		
	}
}