import java.awt.Point;

public class TestStringLinkedList {

	public static void main(String[] args) {
		StringLinkedList sll = new StringLinkedList();
		add(sll);
	}
	
	public static void add(StringLinkedList sll) {							
		sll.add(0, "a");
		sll.add(3, "a");
		System.out.println(sll.size());
		System.out.println(sll.toString());
	}

}


