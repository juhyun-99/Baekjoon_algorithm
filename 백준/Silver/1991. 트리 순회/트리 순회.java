import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
class Node{
	char root;
	Node left;
	Node right;
	Node(char root) {
		this.root = root;
	}
}
public class Main {
	static int n;
	static Node[] arr;
	static StringBuilder sb = new StringBuilder(); 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		
		n = Integer.parseInt(br.readLine());
		arr = new Node[n];
		for (int i = 0; i < n ; i++) {
			arr[i] = new Node((char) ('A' + i));
		}
		for (int i = 0; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			char root= st.nextToken().charAt(0);
			char left= st.nextToken().charAt(0);
			char right= st.nextToken().charAt(0);			
			if(left != '.') arr[root - 'A'].left = arr[left - 'A']; 
			if(right != '.') arr[root - 'A'].right = arr[right - 'A']; 
		}
		
		preOrder(arr[0]);
		sb.append("\n");
		inOrder(arr[0]);
		sb.append("\n");
		postOrder(arr[0]);
		System.out.println(sb);
		
		
	}
	private static void postOrder(Node node) {
		if(node.left != null) postOrder(node.left);
		if(node.right != null) postOrder(node.right);
		sb.append(node.root);
		
	}
	private static void inOrder(Node node) {
		if(node.left != null) inOrder(node.left);
		sb.append(node.root);
		if(node.right != null) inOrder(node.right);
		
	}
	private static void preOrder(Node node) {
		sb.append(node.root);
		if(node.left != null) preOrder(node.left);
		if(node.right != null) preOrder(node.right);
		
	}
}
