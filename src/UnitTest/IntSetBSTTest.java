package UnitTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Random;

import org.junit.jupiter.api.Test;


public class IntSetBSTTest{
	int maxelems;
	int maxval;
	int num;
	
	Node root;
	
	
	public IntSetBSTTest(int maxelems, int maxval) { // constructor
		this.root = null;
		this.maxelems = maxelems;
		this.maxval = maxval;
		num = 0;
	}
	
	
	@Test
	public void insert(int element){
		Node newNode = new Node(element);
		
		if(root == null){
			root = newNode;
			num++;
			return;
		}
		
		Node current = root;
		Node parent = null;
		
		assertEquals(root, current);
		assertEquals(null, parent);
		
		while(true){
			parent = current;
			if(element<current.data){				
				current = current.left;
				if(current==null){
					parent.left = newNode;
					num++;
					return;
				}
			}else{
				current = current.right;
				if(current==null){
					parent.right = newNode;
					num++;
					return;
				}
			}
		}
	}
	
	
	
	@Test
	public int size(){
		return this.num;
	}
	
	
	
	@Test
	public void report(ArrayList<Integer> v) {
		long startTime = System.currentTimeMillis();
		
		traversal(v, this.root);
		
		long finishTime = System.currentTimeMillis() - startTime;
		
		System.out.println("The time elapsed for the 'report' operation is: " + finishTime + "ms");
	}
	
	
	
	@Test
	public void traversal(ArrayList<Integer> v, Node r) {
		if(r != null) {
			traversal(v, r.left);
			v.add(r.data);
			traversal(v, r.right);
		}
		return;
	}
	
	
	@Test
	public static void genSets(int maxelems, int maxval) {   // create an instance of a binary search tree
		
		
		
		long startTimeForEntire = System.currentTimeMillis();
		
		
		
		
		Random rand = new Random();
		ArrayList<Integer> v = new ArrayList<Integer>();
		
		IntSetBSTTest test = new IntSetBSTTest(maxelems,  maxval);
		
		
		assertEquals(maxelems, test.maxelems);
		assertEquals(maxval, test.maxval);
		
		
		
		long startTimeForInsert = System.currentTimeMillis();
		
		for(int i=0 ; i<test.maxelems ; i++) {
			test.insert(rand.nextInt(test.maxval + 1));  //assign random numbers to the created array
		}
		long finishTimeForInsert = System.currentTimeMillis() - startTimeForInsert;
		System.out.println("The time elapsed for the 'insert' operation is: " + finishTimeForInsert + "ms");
		
		
		
		test.report(v);
		
		
				
		
		long finishTimeForEntire = System.currentTimeMillis() - startTimeForEntire;
		System.out.println("The time elapsed for the entire operation is: " + finishTimeForEntire + "ms");
		
	}
	
	
	@Test
	public static void main(String[] args) {
		genSets(10000, 1000000);	// 테스트용 set 생성	
	}
}




class Node{
	int data;
	Node left;
	Node right;
	
	public Node(){
		this.left = null;
		this.right = null;
	}
	
	public Node(int v){
		this.data = v;
		this.left = null;
		this.right = null;
	}
}
	


