import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		long c = Long.parseLong(st.nextToken());
		
		long answer = 1;
		while(b > 0) {
			if( b % 2 == 1) {
				answer = (answer * a) % c;
			}
			a = ((a % c) * (a % c)) % c;
			b /= 2;
		}
		
		System.out.println(answer);
		
	}
}
