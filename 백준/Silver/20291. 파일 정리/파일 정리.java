import java.util.*;
import java.io.*;

public class Main {
	
	static HashMap<String, Integer> map = new HashMap<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < N; i++) {
			String temp = br.readLine();
			String extension = temp.split("[.]")[1];
			calcExtension(extension);
		}
		
		// 키 값 기준으로 정렬하기
		List<String> mapKey = new ArrayList<>(map.keySet());
		Collections.sort(mapKey);
		
		for(String key : mapKey) {
			System.out.println(key + " " + map.get(key));
		}
		
		
	}	
	public static void calcExtension(String extension) {
		// 확장자 이름이 있으면 하나를 더해준다.
		if(isContainExtension(extension)) {
			int addNum = map.get(extension) + 1;
			map.replace(extension, addNum);
		}
		// 확장자 이름이 없으면 새로 만들어준다.
		else { 
			map.put(extension, 1);
		}
	}
	public static boolean isContainExtension(String extension) {
		return map.containsKey(extension);
	}
}
