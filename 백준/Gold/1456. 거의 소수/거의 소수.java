import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		new Main().almostPrime();
	}

	public void almostPrime() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());

		System.out.println(answer(a, b));
	}

	public int answer(long a, long b) {
		List<Integer> primes = getPrimeList((int) Math.sqrt(b));
		int ans = 0;
		for (int i = 0; i < primes.size(); i++) {
			long prime = primes.get(i);
			long temp_prime = prime;
			int prime_size = countNumSize(prime);
			while((temp_prime *= prime) <= b) {
				if( temp_prime >= a) {
					ans++;
				}
				if(prime_size + countNumSize(temp_prime) > 15) break;
			}
		}
		return ans;
	}

	public int countNumSize(long prime) {
		int len = 0;

		while (prime != 0) {
			len++;
			prime /= 10;
		}
		
		return len;
		// return (long)(Math.log10(prime) + 1);
	}

	public List<Integer> getPrimeList(int num) {
		// 에라토스테네스의 체
		List<Integer> primes = new ArrayList<Integer>();
		boolean[] isPrime = new boolean[num + 1];
		int sqrtNum = (int) Math.sqrt(num);
		for (int i = 3; i <= sqrtNum; i += 2) {
			if (isPrime[i])
				continue;
			int base = i + i;
			while (base <= num) {
				isPrime[base] = true;
				base += i;
			}
		}
		primes.add(2);
		for (int i = 3; i <= num; i += 2) {
			if (!isPrime[i])
				primes.add(i);
		}

//        for(int temp:primes) {
//        	System.out.print(temp+ " ");
//        }
//        System.out.println();

		return primes;

//      시간 초과 이유	
//		List<Integer> primes = new ArrayList<Integer>();		
//		primes.add(2);
//		boolean flag = false;
//		for(int i = 3; i <= (int)Math.sqrt(num); i += 2) {
//			flag = false;
//			for(int j = 2; j * j <= i; j++) {
//				if(i % j == 0) {
//					flag = true;
//					break;
//				}
//			}
//			if(!flag) {
//				primes.add(i);
//			}
//		}
	}
}
