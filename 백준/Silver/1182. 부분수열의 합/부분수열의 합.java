import java.util.*;
import java.io.*;

public class Main {
	
	static ArrayList<Integer> nums = new ArrayList<>();
	static int N, S;
	static int count;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N; i++) {
			nums.add(Integer.parseInt(st.nextToken()));
		}
		
		// 혹시 모르니까 정렬
		Collections.sort(nums);
		
		partialSum(nums.get(0), 1);

		System.out.println(count);
		
		
	}
	public static void partialSum(int sum, int index) {
		
		
		// 종료조건 1. 부분 수열의 합이 N 과 같다면 count 를 1 더한다.
		if(S == sum) { 
			count ++;
		}
		
		// 종료조건 2. 인덱스를 벗어났다면 리턴한다.
		if(index >= N) {
			return;
		}			

		// case1. 현재 인덱스를 계속 더해가는 경우
		partialSum(sum + nums.get(index), index + 1);
		// case2. 이전 인덱스를 빼고 현재 인덱스를 더하는 경우
		partialSum(sum - nums.get(index - 1) + nums.get(index), index + 1);
		
	}
}
