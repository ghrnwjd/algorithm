import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();	
		
		boolean prime [] = new boolean [1000001];
		
		for(int i = 2; i <= 1000000; i ++) {
			if(isPrime(i)) {
				prime[i] = true;
			}
		}
		
		while(true) {			
			int num = Integer.parseInt(br.readLine());
			if(num == 0) {
				break;
			}
			
			boolean flag = false;
			for(int i = num; i > 0; i--) {
				if(prime[i] && prime[num-i]) {					
					flag = true;
					sb.append(num + " = " + (num-i) + " + " + i + "\n");
					break;				
				}
			}
			
			if(!flag) {
				sb.append("Goldbach's conjecture is wrong.\n");	
			}			
		}		
		
		System.out.println(sb.toString());
	}
	
	public static boolean isPrime(int num) {
		
		if(num < 2) return false;
		
		for(int i = 2; i * i <= num; i++) {
			if(num % i == 0) {
				return false;
			}
		}
		return true;
	}
}
