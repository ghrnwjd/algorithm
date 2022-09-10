import java.util.*;
import java.io.*;

public class Main {
	
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());				
		
		primeCount(0,0);
 	}
	
	public static void primeCount(int value, int cnt) {
		
		if(cnt == N) {
			System.out.println(value);
		}
		
		int temp = 0;
        
		for(int i = 0; i < 10; i++) {			
			temp = value * 10 + i;
			if(isPrime(temp)) {
				primeCount(temp, cnt+1);
			}
		}
	}
	
	
	public static boolean isPrime(int value) {
		if(value == 0 || value == 1) return false;
		
		for(int i = 2; i * i <= value; i++) {
			if(value % i == 0) {
				return false;
			}
		}
		return true;
	}
	
}
