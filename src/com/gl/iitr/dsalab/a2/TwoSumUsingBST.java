package com.gl.iitr.dsalab.a2;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class TwoSumUsingBST {

	static class Node {
		int data;
		Node left, right;
		
		Node(int data){
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
	
	static Node newNode(int data) {
		return new Node(data);
	}
	
	static Node insert(Node root, int data) {
		
		if(root == null) {
			return newNode(data);
		}
		else if(data < root.data){
			root.left = insert(root.left, data);
		}
		else if(data > root.data){
			root.right = insert(root.right, data);
		}
		return root;
	}
	
	/*
	 *  Output:
	    Pair for sum 130 is ( 70, 60 )
		Pair for sum 80 is ( 50, 30 )
		Pair for sum 90 is ( 50, 40 )
		Nodes pair not found for the sum: 200
		Pair for sum 70 is ( 40, 30 )
	 */
	
	static boolean find2Sum(Node root, int sum, HashSet<Integer> hashSet) {
		
		if(root == null) {
			return false;
		}
		
		if(find2Sum(root.left, sum, hashSet)) {
			return true;
		}
		
		if(hashSet.contains(sum - root.data)) {
			System.out.println("Pair for sum " + sum + " is ( " + root.data + ", " + (sum-root.data) + " )");
			return true;
		}
		
		hashSet.add(root.data);
		
		if(find2Sum(root.right, sum, hashSet)) {
			return true;
		}
		
		return false;
	}
	
	static boolean findPairForSum(Node root, int sum) {
		
		HashSet<Integer> set = new HashSet<Integer>();
		return find2Sum(root, sum, set);
	}
	
	static void inorderTravel(Node root, LinkedList<Integer> list) {
		
		if(root == null) {
			return;
		}
		
		inorderTravel(root.left, list);
		list.addLast(root.data);
		inorderTravel(root.right, list);
	}
	
	static int findHeightOfBST(Node root) {
		
		if(root == null) {
			return 0;
		}
		
		int leftHeight = 0, rightHeight = 0;  
		
		if(root.left != null) {
			leftHeight = findHeightOfBST(root.left);
		}
		
		if(root.right != null) {
			rightHeight = findHeightOfBST(root.right);
		}
		
		
		int h = (leftHeight > rightHeight) ?leftHeight : rightHeight;
		
		return h+1;
	}
	
	public TwoSumUsingBST() {
		
		
	}

	public static void main(String[] args) {
		
		Node root = null;
		
		root = insert(root, 40);
		root = insert(root, 20);
		root = insert(root, 10);
		root = insert(root, 30);
		root = insert(root, 60);
		root = insert(root, 50);
		root = insert(root, 70);
		
		LinkedList<Integer> list = new LinkedList<Integer>();
		inorderTravel(root, list);
		
		System.out.println("---- Inorder Traversal of constructed tree \n");
		
		Iterator<Integer> it = list.iterator();
		while(it.hasNext()) {
			System.out.print(it.next() + " ");
		}
		
		System.out.println(" ---- Finding 2sum pairs ----- \n");
		int sumList[] = {130, 80, 90, 200, 70};
		
		for (int sum : sumList) {
			if (!findPairForSum(root, sum)) {
				System.out.println("Nodes pair not found for the sum: " + sum);
			}
		}
	}

}
