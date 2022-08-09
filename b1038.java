import java.util.*;
import java.io.*;

public class b1038 {

	static int n;
	static ArrayList<Long> Nums = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		if(n > 1022) {
			System.out.println(-1);
		}
		else {
			for(int i = 0; i < 10; i++) {
				decline_Nums(i, 1);
			}
			
			Collections.sort(Nums);
			System.out.println(Nums.get(n));
		}
		
		
	}
	
	public static void decline_Nums(long value, int cnt) {		
		if(cnt > 10) return;
		
		Nums.add(value);
		
		for(int i = 0; i < value % 10; i++) {
			decline_Nums(value * 10 + i, cnt + 1);
		}
		
	}
}