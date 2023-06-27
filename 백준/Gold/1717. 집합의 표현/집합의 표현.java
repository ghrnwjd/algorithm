import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int elements [];
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		elements = new int [n+1];		
		for(int i = 0; i <= n ; i++) {
			elements[i] = i;
		}
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			if( a == 0 ) {
				union(b, c);
			}
			else {
				sb.append((sameParent(b, c) ? "YES" : "NO") + "\n");
			}		
		}	
		
		System.out.println(sb.toString());	
	
		
	}
	public static int findElementParent(int element) {
		if(element == elements[element]) {
			return element;
		}
		
		elements[element] = findElementParent(elements[element]);
		
		return elements[element];
	}
	
	public static void union(int b, int c) {
		b = findElementParent(b);
		c = findElementParent(c);
		
		if(b != c) {
			if( b < c) {
				elements[b] = c;
			}
			else {
				elements[c] = b;
			}
		}
	}
	
	public static boolean sameParent(int x, int y) {
		x = findElementParent(x);
		y = findElementParent(y);
		
		return (x == y) ? true : false;
	}
}


// 메모리 초과 코드
//public class Main {
//
//	static List<Set> setList;
//	static boolean isUseElement[];
//
//	public static void main(String[] args) throws IOException {
//
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//
//		int n = Integer.parseInt(st.nextToken());
//		int m = Integer.parseInt(st.nextToken());
//		StringBuilder sb = new StringBuilder();
//
//		isUseElement = new boolean[n + 1];
//
//		setList = new ArrayList<>();
//		for (int i = 0; i < m; i++) {
//			st = new StringTokenizer(br.readLine());
//			int a = Integer.parseInt(st.nextToken());
//			int b = Integer.parseInt(st.nextToken());
//			int c = Integer.parseInt(st.nextToken());
//
//			if (a == 0) {
//				if (!isUseElement[b] && !isUseElement[c]) {
//					setList.add(new Set(b, c));					
//					isUseElement[b]= true;
//					isUseElement[c]= true;					
//				} 
//				
//				else if (!isUseElement[b] || !isUseElement[c]) {
//					addElement(b,c);					
//				}
//				else {
//					addElements(b, c);
//				}
//			}
//			else {
//				if(!isUseElement[b] || !isUseElement[c]) {
//					sb.append("NO").append("\n");
//				}
//				else {
//					if (findElement(b, c)) {
//						sb.append("YES").append("\n");
//					} else {
//						sb.append("NO").append("\n");
//					}
//				}				
//			}
//		}
//
//		System.out.println(sb.toString());
//
//	}
//
//	public static boolean findElement(int ele1, int ele2) {
//		for (int i = 0; i < setList.size(); i++) {
//			if (setList.get(i).elements.contains(ele1)) {
//				if (setList.get(i).elements.contains(ele2)) {
//					return true;
//				}
//				break;
//			}
//		}
//
//		return false;
//	}
//
//	public static void addElement(int ele1, int ele2) {
//
//		for (int i = 0; i < setList.size(); i++) {
//
//			if (setList.get(i).elements.contains(ele1)) {
//				setList.get(i).addElement(ele2);
//				isUseElement[ele2] = true;
//				return;
//			}
//
//			if (setList.get(i).elements.contains(ele2)) {
//				setList.get(i).addElement(ele1);
//				isUseElement[ele1] = true;
//				return;
//			}
//		}
//
//	}
//
//	public static void addElements(int ele1, int ele2) {
//		int idx1 = -1, idx2 = -1;
//		for (int i = 0; i < setList.size(); i++) {
//			if (idx1 != -1 && idx2 != -1) {
//				break;
//			}
//
//			if (setList.get(i).elements.contains(ele1)) {
//				idx1 = i;
//			}
//
//			if (setList.get(i).elements.contains(ele2)) {
//				idx2 = i;
//			}
//		}
//
//		if (idx1 == idx2) {
//			return;
//		}
//
//		setList.get(idx1).addElements(setList.get(idx2).elements);
//		setList.remove(idx2);
//	}
//}
//
//class Set {
//
//	HashSet<Integer> elements = new HashSet<>();
//
//	public Set(Integer element) {
//		this.elements.add(element);
//	}
//
//	public Set(Integer ele1, Integer ele2) {
//		this.elements.add(ele1);
//		this.elements.add(ele2);
//	}
//
//	public void addElements(HashSet<Integer> elements) {
//		for (Integer element : elements) {
//			this.elements.add(element);
//		}
//	}
//
//	public void addElement(Integer element) {
//		this.elements.add(element);
//	}
//
//}
