import java.awt.Point;
import java.util.Iterator;

import javax.sound.midi.Soundbank;

public class TestStringLinkedList {

	public static void main(String[] args) {
		StringLinkedList sll = new StringLinkedList();

		// add(sll);
		// addWithIndex(sll);
		// addFirst(sll);
		// addLast(sll);
		// clear(sll);
		// contains(sll);
		// getElementWithIndex(sll);
		// getLastElement(sll);
		// getFirstElement(sll);
		// indexOfTest(sll);
		// peek(sll);
		// remove(sll);
		// removeWithIndex(sll);
		//removeObejct(sll);
		//set(sll);
		//size(sll);
		
/*        
        sll.addFirst("a");
        sll.addFirst("b");

        testIterator(sll);
        testIteratorDescending(sll);
*/

	}
	
    public static void testIterator(StringLinkedList sll) {
        for(Node n : sll){
            System.out.print(n.value+"    ");
        }
        System.out.println();
    }
    public static void testIteratorDescending(StringLinkedList sll) {
        for(Iterator<Node> itr = sll.iteratorDescending(); itr.hasNext();){
            System.out.print(itr.next().value+"    ");
        }
        System.out.println();
    }


	public static void add(StringLinkedList sll) {

		sll.add("a");
		sll.add("b");
		sll.add(null);
		sll.add("c");
		System.out.println(sll.toString());

	}

	public static void addWithIndex(StringLinkedList sll) {
		sll.add(0, "a");
		sll.add(1, "b");
		sll.add(2, null);
		sll.add(3, "c");
		try {
			sll.add(-2, "d");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			sll.add(40, "d");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		finally {
			System.out.println(sll.toString());
		}
	}

	public static void addFirst(StringLinkedList sll) {
		sll.addFirst("a");
		sll.addFirst("b");
		sll.addFirst(null);
		sll.addFirst("c");
		System.out.println(sll.toString());
	}

	public static void addLast(StringLinkedList sll) {
		sll.add("a");
		sll.add("b");
		sll.add(null);
		sll.add("c");
		System.out.println(sll.toString());
	}

	public static void clear(StringLinkedList sll) {
		sll.add("a");
		sll.add("b");
		sll.add(null);
		sll.add("c");
		System.out.println(sll.toString());
		sll.clear();

		System.out.println("after clear : " + sll.toString());
	}

	public static void contains(StringLinkedList sll) {
		sll.add("a");
		sll.add("b");
		sll.add(null);
		sll.add("c");
		System.out.println(sll.toString());
		System.out.println("sll contient a ? : " + sll.contains("a"));
		System.out.println("sll contient d ? : " + sll.contains("d"));
		try {
			sll.contains(new Point());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void getElementWithIndex(StringLinkedList sll) {
		sll.add("a");
		sll.add("b");
		sll.add(null);
		sll.add("c");
		System.out.println(sll.toString());
		System.out.println("index = 0, element ? : " + sll.get(0));
		System.out.println("index = 2, element ? : " + sll.get(2));
		System.out.println("index = 3, element ? : " + sll.get(3));

		try {
			System.out.println("index = -1, element ? : " + sll.get(-1));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			System.out.println("index = 5, element ? : " + sll.get(5));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public static void getLastElement(StringLinkedList sll) {
		System.out.println("sll est vide");
		System.out.println("le dernier noued : " + sll.getLast());
		sll.add("a");
		sll.add("b");
		sll.add(null);
		sll.add("c");
		System.out.println("sll n'pas vide");
		System.out.println(sll.toString());
		System.out.println("le dernier noued : " + sll.getLast());
	}

	public static void getFirstElement(StringLinkedList sll) {
		System.out.println("sll est vide");
		System.out.println("le dernier noued : " + sll.getFirst());
		sll.add("a");
		sll.add("b");
		sll.add(null);
		sll.add("c");
		System.out.println("sll n'pas vide");
		System.out.println(sll.toString());
		System.out.println("le dernier noued : " + sll.getFirst());
	}

	public static void indexOfTest(StringLinkedList sll) {
		sll.add("a");
		sll.add("b");
		sll.add(null);
		sll.add("c");
		System.out.println(sll.toString());
		System.out.println("indexOf a ? : " + sll.indexOf("a"));
		System.out.println("indexOf null ? : " + sll.indexOf(null));
		System.out.println("indexOf d ? : " + sll.indexOf("d"));
		try {
			System.out.println("indexOf Point ? : " + sll.indexOf(new Point()));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void peek(StringLinkedList sll) {

		try {
			System.out.println("la liste est vide");
			System.out.println("peek ? : " + sll.peek());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		sll.add("a");
		sll.add("b");
		sll.add(null);
		sll.add("c");
		System.out.println("affichage de la liste :");
		System.out.println(sll.toString());
		System.out.println("peek ? : " + sll.peek());
		System.out.println("affichage de la liste après la récupératiion avec peek :");
		System.out.println(sll.toString());

	}

	public static void remove(StringLinkedList sll) {

		try {
			System.out.println("la liste est vide");
			System.out.println("peek ? : " + sll.remove());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		sll.add("a");
		sll.add("b");
		sll.add(null);
		sll.add("c");
		System.out.println("affichage de la liste :");
		System.out.println(sll.toString());
		System.out.println("supprimer le premier ? : " + sll.remove());
		System.out.println("affichage de la liste après la suppression :");
		System.out.println(sll.toString());
	}

	public static void removeWithIndex(StringLinkedList sll) {
		try {
			System.out.println("la liste est vide");
			System.out.println("essayer de supprimer ? : " + sll.remove(1));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		sll.add("a");
		sll.add("b");
		sll.add(null);
		sll.add("c");
		System.out.println("affichage de la liste :");
		System.out.println(sll.toString());
		System.out.println("supprimer null ? : " + sll.remove(2));
		try {
			System.out.println("supprimer null ? : " + sll.remove(-1));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			System.out.println("supprimer null ? : " + sll.remove(10));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println("affichage de la liste après la suppression :");
		System.out.println(sll.toString());
	}

	public static void removeObejct(StringLinkedList sll) {
		try {
			System.out.println("la liste est vide");
			System.out.println("essayer de supprimer de type Point ? : " + sll.remove(new Point()));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		sll.add("a");
		sll.add("b");
		sll.add(null);
		sll.add("c");
		System.out.println("affichage de la liste :");
		System.out.println(sll.toString());
		System.out.println("supprimer a ? : " + sll.remove("a"));
		System.out.println("supprimer null ? : " + sll.remove(null));
		try {
			System.out.println("essayer de supprimer de type Point ? : " + sll.remove(new Point()));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println("affichage de la liste après la suppression :");
		System.out.println(sll.toString());
	}

	public static void set(StringLinkedList sll) {
		sll.add("a");
		sll.add("b");
		sll.add(null);
		sll.add("c");
		System.out.println(sll.toString());
		System.out.println("modifier a en aa");
		sll.set(0, "aa");		
		System.out.println(sll.toString());
		
		try {
			System.out.println("modifier null en aa");
			sll.set(-5, "aa");			
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public static void size(StringLinkedList sll) {
		sll.add("a");
		sll.add("b");
		sll.add(null);
		sll.add("c");
		System.out.println(sll.toString());
		System.out.println("size = "+sll.size());
	}

}

