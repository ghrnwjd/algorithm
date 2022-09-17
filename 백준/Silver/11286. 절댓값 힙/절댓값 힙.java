import java.util.*;

import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());		
		StringBuilder sb = new StringBuilder();
		
		PriorityQueue<Integer> que = new PriorityQueue<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				//절대값 기준으로 앞 값이 더 크다면 자리를 바꿔준다.
				if(Math.abs(o1) > Math.abs(o2)) {
					return Math.abs(o1) - Math.abs(o2);
				//절대값 기준으로 두 값이 같다면 음수를 앞으로 보내준다.
				}
				else if(Math.abs(o1) == Math.abs(o2)) {
					return o1 - o2;
				}
				else {
					return -1;
				}
			}
		});

		
		while(N --> 0) {
			
			int temp = Integer.parseInt(br.readLine());
			if(temp == 0) {
				if(que.isEmpty()) 
					System.out.println(0);
				else 
					System.out.println(que.poll());
			}
			else {
				que.add(temp);
			}
			
		}
			
		
		System.out.println(sb);
	}

}



// 시간 초과


//public class Main {
//
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//
//		int N = Integer.parseInt(st.nextToken());
//
//		Array List = new Array();
//
//		while (N-- > 0) {
//
//			int temp = Integer.parseInt(br.readLine());
//
//			if (temp == 0) {
//				List.remove();
//			} else {
//				List.insert(temp);
//			}
//		}
//		
//		System.out.println(List.sb.toString());
//
//	}
//}
//
//class Array {
//
//	static ArrayList<int[]> arrayList;
//	static StringBuilder sb = new StringBuilder();
//
//	public Array() {
//		arrayList = new ArrayList<>();
//	}
//
//	public static void insert(int num) {
//		if (!isExisted(num)) {
//			if (num < 0) {
//				arrayList.add(new int[] { -1 * num, -1 });
//			} else {
//				arrayList.add(new int[] { num, 1 });
//			}
//			sort();
//		}
//	}
//
//	public static void remove() {
//
//		if (arrayList.isEmpty()) {
//			sb.append(0 + "\n");
//		} 
//		else {
//			if (arrayList.get(0)[1] == -1) {
//				sb.append(arrayList.get(0)[0] * -1 + "\n");
//			} else {
//				sb.append(arrayList.get(0)[0] + "\n");
//			}
//
//			arrayList.remove(0);
//		}
//	}
//
//	public static void sort() {
//		Collections.sort(arrayList, (o1, o2) -> {
//			if(o1[0] == o2[0]) 
//				return o1[1]-o2[1];
//			
//			else 
//				return Integer.compare(o1[0], o1[0]);
//		});
//		
//	
//	}
//	public static boolean isExisted(int num) {
//		if (arrayList.contains(Math.abs(num))) {
//			if (num < 0 && arrayList.get(arrayList.indexOf(num))[1] == -1)
//				return true;
//			if (num > 0 && arrayList.get(arrayList.indexOf(num))[1] == 1)
//				return true;
//		}
//		return false;
//	}
//}