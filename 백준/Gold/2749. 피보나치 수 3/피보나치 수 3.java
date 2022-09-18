import java.util.*;

import java.io.*;
import java.math.BigInteger;


public class Main {

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		/*
		 * 피사노 주기
		 * 피보나치 수를 어떤 수 K로 나눌 때, 나머지는 항상 주기를 갖게 됌.
		 * N % P번째 피보나치 수를 M으로 나눈 나머지와 같다
		 * 주기 M = 10^k, K>2일 땐 항상 15 * 10^(k-1)이다.
		 * 
		 * 이 문제의 경우 modulo가 10^6 이므로 주기는 15 * 10^5이 된다.
		 * */
		
		Long n = Long.parseLong(st.nextToken());
		Long pisano = 1500000L;
		Long modulo = 1000000L;
		n = n % pisano;
		
		long [] fibbo = new long [(int) (n + 1)];
		
		fibbo[0] = 0L;
		fibbo[1] = 1L;
		
		for(int i = 2; i <= n; i++) {
			fibbo[i] = ( fibbo[i-1] + fibbo[i-2] ) % modulo;
		}
		
		System.out.println(fibbo[fibbo.length-1]);
		
	}
}

