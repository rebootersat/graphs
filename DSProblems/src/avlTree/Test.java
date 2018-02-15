package avlTree;

public class Test {
	public static void main(String[] args) {
		AvlTree tree = new AvlTree();
		
		int i = 1;
		while(i<10)
			tree.insert(i++);
			
		
		System.out.println(tree);
		
	}
}
