import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
					
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		String s = br.readLine();
		
		String pattern = pattern(n);		
		
		boolean charI [] = findCharI(s);
		
		int ans = 0;
		for(int i = 0; i < charI.length; i++) {
			if(charI[i] && (i + (2 * n + 1)) <= m ) {
				if(s.subSequence(i, i + (2 * n + 1)).equals(pattern)) {
					ans++;
				}
			}
		}
		
		System.out.println(ans);
		
	}
	
	public static String pattern(int n) {
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < n; i++) {
			sb.append("IO");
		}
		
		sb.append("I");
		return sb.toString();
	}
	
	public static boolean [] findCharI(String s) {
		boolean charI [] = new boolean [1000001];
		
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == 'I') {
				charI[i] = true;
			}
		}
		
		return charI;		
	}
}
