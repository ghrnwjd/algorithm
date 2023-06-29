import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		
		PriorityQueue<Integer> plusBook = new PriorityQueue<>();
		PriorityQueue<Integer> minusBook = new PriorityQueue<>();
		
		st = new StringTokenizer(br.readLine());
		int minusMax = 0, plusMax = 0;
		
		for(int i = 0; i < n; i++) {
			int temp = Integer.parseInt(st.nextToken());
			if(temp < 0) {
				minusBook.add(Math.abs(temp));
				minusMax = Math.max(Math.abs(temp), minusMax);
			}
			else {
				plusBook.add(Math.abs(temp));
				plusMax = Math.max(Math.abs(temp), plusMax);
			}
		}
		
		int ans = 0;
		
		
		
		if(plusMax < minusMax) {
			// plus 부터 이동			
			System.out.println(libraryShortCut(plusBook, minusBook, m));
		}
		else {
			System.out.println(libraryShortCut(minusBook, plusBook, m));
		}
		
	}
	
	public static int libraryShortCut(PriorityQueue<Integer> book1, PriorityQueue<Integer> book2, int oneHand) {
		
		int ans = 0;
		int len = 0;
		
		int idx = 0;
		
		int modBook1 = book1.size() % oneHand;
		int modBook2 = book2.size() % oneHand;
		while(!book1.isEmpty()) {		
			idx ++ ;
			
			if(idx == 1) {
				if(book1.size() % oneHand == 0) continue;
				for(int i = 0; i < modBook1; i++) {
					len = book1.poll();
					if(book1.isEmpty()) {
						break;
					}
				}
			}
			else {
				for(int i = 0; i < oneHand; i++) {
					len = book1.poll();
					if(book1.isEmpty()) {
						break;
					}
				}
			}
			
			ans += 2 * Math.abs(len);
		}
		
		idx = 0;
		while(!book2.isEmpty()) {
			idx ++ ;
			
			if(idx == 1) {
				if(book2.size() % oneHand == 0) continue;
				for(int i = 0; i < modBook2; i++) {
					len = book2.poll();
					if(book2.isEmpty()) {
						ans += len;
						return ans;
					}
				}
			}
			
			else {
				for(int i = 0; i < oneHand; i++) {
					len = book2.poll();
					if(book2.isEmpty()) {
						ans += len;
						return ans;
					}
				}
			}
			
			ans += 2 * Math.abs(len);
		}
		
		return ans;		
	}
}


