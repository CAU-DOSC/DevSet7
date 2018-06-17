package IntSet;

public class IntSetList implements IntSet {
	int maxelems;
	int maxval;
	int size;
	Node head;
	
	public IntSetList() {
		this.maxelems = 0;
		this.maxval = 0;
		this.size = 0;
		this.head = null;
	}
	
	public void intSetImp(int maxelems, int maxval) {
		this.maxelems = maxelems;
		this.maxval = maxval;
	}
	
	public void insert(int element) {
		if (this.size >= this.maxelems || element >= this.maxval) 
			return;
		
		Node temp = this.head;
		if (temp == null) {
			head = new Node(element);
			this.size++;
			return;
		}
		else if (element < temp.value) {
			head = new Node(element, temp);
			this.size++;
			return;
		}
		else if (element == temp.value) {
			return;
		}
		Node prev = temp;
		temp = temp.next;
		
		while (temp != null) {
			if (element == temp.value) {
				return;
			}
			else if (element < temp.value) {
				prev.next = new Node(element, temp);
				this.size++;
				return;
			}
			prev = temp;
			temp = temp.next;
		}
		prev.next = new Node(element);
		this.size++;
	}
	
	public int size() {
		return this.size;
	}
	
	public int[] report() {
		int[] result = new int[this.size];
		
		Node temp = this.head;
		for (int i = 0; i < this.size; i++) {
			result[i] = temp.value;
			temp = temp.next;
		}
		
		return result;
	}
	
	public static void main(String[] args) {		// driver
		IntSet set = new IntSetList();
		set.intSetImp(10, 10);
		int[] input = {2, 4, 1, 6, 3, 2, 7, 4, 3, 1, 5};
		
		for (int i = 0; i < input.length; i++) {
			set.insert(input[i]);
		}
		
		System.out.println("size of set = " + set.size());
		int[] output = set.report();
		for (int i = 0; i < output.length; i++) {
			System.out.print(output[i] + " ");
		}
		System.out.println();
	}
		
	class Node {
		int value;
		Node next;
		
		Node(int value, Node next) {
			this.value = value;
			this.next = next;
		}
		
		Node(int value) {
			this(value, null);
		}
	}

}
