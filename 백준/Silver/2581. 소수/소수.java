import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(br.readLine());

		int sum = 0;
		int min_prime = 0;
		for (int i = N; i <= M; i++) {
			if (isPrime(i)) {
				sum += i;
				if (min_prime == 0) {
					min_prime = i;
				}
			}
		}

		if (sum != 0) {
			System.out.println(sum);
			System.out.println(min_prime);
		}
		else {
			System.out.println(-1);
		}
	}

	public static boolean isPrime(int x) {

		if (x == 0 || x == 1)
			return false;

		for (int i = 2; i * i <= x; i++) {
			if (x % i == 0) {
				return false;
			}
		}

		return true;
	}
}
