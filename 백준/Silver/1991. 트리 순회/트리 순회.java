import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Tree tree = new Tree();
		
		tree.root = new Node("A"); // 초기 설정
		
		int N = Integer.parseInt(st.nextToken());		

		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			String pData = st.nextToken();
			String lData = st.nextToken();
			String rData = st.nextToken();
			
			
			tree.connectNode(tree.root, lData, rData, pData);
		}
		
		tree.preorder(tree.root);
		System.out.println();
		
		tree.inorder(tree.root);
		System.out.println();
		
		tree.postorder(tree.root);
		
	}		
}

class Node{
	
	String data;
	Node left;
	Node right;
	
	public Node(String data) {
		this.data = data;
	}	
	
}

class Tree {
	
	Node root;		
	
	/**
	 * @param temp 루트노드부터 시작
	 * @param leftNode 연결할 왼쪽노드
	 * @param rightNode 연결할 오른쪽 노드
	 * @param data 부모노드의 data
	 */
	public void connectNode(Node temp, String lData, String rData, String data) {
		
		if(temp == null) return;
		
		if(temp.data.equals(data)) {
			
			if(!lData.equals(".")) {
				temp.left = new Node(lData);
			}
			if(!rData.equals(".")) {
				temp.right = new Node(rData);
			}
			return;
		}
		
		else {
			connectNode(temp.left, lData, rData, data);
			connectNode(temp.right, lData, rData, data);
		}				
	}	
	
	public void preorder(Node node) { // 전위순회
		if(node == null) return;
		
		System.out.print(node.data);
		preorder(node.left);
		preorder(node.right);
	}
	
	public void inorder(Node node) { // 중위순회
		if(node == null) return;
		
		inorder(node.left);
		System.out.print(node.data);
		inorder(node.right);
	}
	
	public void postorder(Node node) { // 후위순회
		if(node == null) return;
		
		postorder(node.left);
		postorder(node.right);
		System.out.print(node.data);
	}
}


