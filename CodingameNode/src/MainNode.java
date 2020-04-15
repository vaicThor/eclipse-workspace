
public class MainNode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node node16 = new Node(null, null, 16);
		Node node17 = new Node(node16, null, 17);
		Node node13 = new Node(null, node17, 13);
		
		Node node2 = new Node(null, null, 2);
		Node node6 = new Node(null, null, 6);
		Node node5 = new Node(node2, node6, 5);
		Node node8 = new Node(null, null, 8);
		Node node7 = new Node(node5,node8, 7);
		Node small = new Node(node7, node13, 9);
		
		Node n = small.findVal(8); 
	}

}
