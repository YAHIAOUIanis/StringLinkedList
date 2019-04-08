import java.awt.Point;

public class TestStringLinkedList {

	public static void main(String[] args) {
		StringLinkedList sll = new StringLinkedList();
		add(sll);
	}
	
	public static void add(StringLinkedList sll) {							
		sll.addFirst("e");
		sll.add(null);
		sll.add(null);
		System.out.println(sll.size());
		System.out.println(sll.toString());
	}

}

