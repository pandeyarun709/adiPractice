
package uca.utils.ds.Tree.bst;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

@SuppressWarnings("unused")
public class BST<K extends Comparable<K> , V > {
	
	private Node head;
	
	public BST(){
		head =null;
	}
	
/*################## add Node ##################################*/
	
	public void add(final K key ,final V val ) {
		head = add(head , key , val);
	}
	
	private Node add(Node root , K key , V val) {
		
		if(root == null) {
			return new Node(key , val);
		}
		
		int cmp = key.compareTo(root.key);
		
		if(cmp < 0)
			root.left = add(root.left , key , val);
		else if(cmp > 0)
			root.right = add(root.right , key , val);
		
		root.N = 1 + sizeOf(root.left) + sizeOf(root.right);
		return root;
	}
/*######################### inorder ##################################*/
	public void inOrder() {
		System.out.println("Inorder : ");
		inOrder(head);
		System.out.println();
	}
	
	private void inOrder(Node root) {
		
		if(root == null)
			 return;
		inOrder(root.left);
		System.out.print("key: "+root.key+" val: "+root.val+" | ");
		inOrder(root.right);
		
	}
/*######################### postorder ################################*/
	public void postOrder() {
		System.out.println("Postorder : ");
		postOrder(head);
		System.out.println();
	}
	
	private void postOrder(Node root) {
		
		if(root == null)
			 return;
		postOrder(root.left);
		postOrder(root.right);
		System.out.print("key: "+root.key+" val: "+root.val+" | ");
		
	}
/*######################### preorder #################################*/
	public void preOrder() {
		System.out.println("Preorder : ");
		preOrder(head);
		System.out.println();
	}
	
	private void preOrder(Node root) {
		
		if(root == null)
			 return;
		
		System.out.print("key: "+root.key+" val: "+root.val+" | ");
		preOrder(root.left);
		preOrder(root.right);
		
	}
/*######################### Zigzag order ############################*/
	public void zigZag() {
		
		boolean direction = false;
	    Stack<Node> stk1 = new Stack<>();
		Stack<Node> stk2 = new Stack<>();
		
		System.out.println("Zig Zag traversal : ");
		
		stk1.push(head);
		while(!stk1.isEmpty()) {
			
			while(!stk1.isEmpty()) {
				Node temp = stk1.pop();
				System.out.print("key: "+temp.key+" val: "+temp.val+" | ");
				
				if(temp.left != null)
					stk2.push(temp.left);
				
				if(temp.right != null)
					stk2.push(temp.right);
			}
			
			while(!stk2.isEmpty()) {
				
				Node temp = stk2.pop();
				System.out.print("key: "+temp.key+" val: "+temp.val+" | ");
				
				 if(temp.right != null)
					stk1.push(temp.right);
				 
				 if(temp.left != null)
					stk1.push(temp.left);
			}
		}
		System.out.println();
		
	}
/*######################## Top view ##################################*/
	private class CoordinateNode{
		private int dist;
		private Node node;
	    public CoordinateNode(int dist , Node n) {
			this.dist = dist;
			this.node = n;
		}
	}
	void topView() {
		
		Queue<CoordinateNode> q = new LinkedList<>();
		
		q.add(new CoordinateNode(0, head));
		Map<Integer , K> map = new HashMap<>();
		map.put(0, head.key);
		Integer max = Integer.MIN_VALUE;
		Integer min = Integer.MAX_VALUE;
		
		while(!q.isEmpty()) {
			
			 CoordinateNode t = q.poll();
			 
			 if(!map.containsKey(t.dist))
				 map.put(t.dist, t.node.key);
			 
			 min = min > t.dist ? t.dist : min;
			 max = max < t.dist ? t.dist : max;
			 
			 if(t.node.left != null)
				 q.add(new CoordinateNode(t.dist-1, t.node.left));
			 
			 if(t.node.right != null)
				 q.add(new CoordinateNode(t.dist+1, t.node.right));
		 
		 
		 
		}
		
		System.out.print("Top view : ");
		for(int i = min ;i<=max ;i++) {
			System.out.print(map.get(i)+" ");
		}
		System.out.println();
	}
/*##################### bottom view ##################################*/
	void bottomView() {
		
		Queue<CoordinateNode> q = new LinkedList<>();
		
		q.add(new CoordinateNode(0, head));
		Map<Integer , K> map = new HashMap<>();
		map.put(0, head.key);
		Integer max = Integer.MIN_VALUE;
		Integer min = Integer.MAX_VALUE;
		
		while(!q.isEmpty()) {
			
			 CoordinateNode t = q.poll();
			 
				 map.put(t.dist, t.node.key);
			 
			 min = min > t.dist ? t.dist : min;
			 max = max < t.dist ? t.dist : max;
			 
			 if(t.node.left != null)
				 q.add(new CoordinateNode(t.dist-1, t.node.left));
			 
			 if(t.node.right != null)
				 q.add(new CoordinateNode(t.dist+1, t.node.right));
		 
		 
		 
		}
		
		System.out.print("Bottom view : ");
		for(int i = min ;i<=max ;i++) {
			System.out.print(map.get(i)+" ");
		}
		System.out.println();
	}
/*###################### get rank ####################################*/
	public int sizeOf(Node n) {
		
		return n == null ? 0 : n.N;
	}
	
	void getRank(K n) {
		
		System.out.println(" Rank of key : "+ n +" = "+ getRank(head,n) );
	}
	private int getRank(Node node,K data) {
		
		if(node == null)
			return -1;
		
		int cmp = node.key.compareTo(data);
		
		if(cmp == 0)
		{
			return sizeOf(node) - sizeOf(node.right);
		}else if(cmp > 0) {
			return getRank(node.left,data);
		}
		else return 1 + sizeOf(node.left) + getRank(node.right,data);
	}
/*######################## Common Ancestor ###########################*/
	public void commonAncestor(K A, K B) {
		
		System.out.println("LCA of "+ A +" & "+B+" : "+ LCA(head,A,B).key);
	}
	
	private Node LCA(Node root , K A,K B) {
		
		if(root == null)
			return null;
		
		if(root.key.compareTo(A) == 0 || root.key.compareTo(B) == 0 )
			 return root;
		
		Node left = LCA(root.left, A , B);
		Node right = LCA(root.right , A ,B);
		
		if(left != null && right != null)
			return  root;
		
		return left == null ? right : left;
	}
	
/*#######################	level sum ###############################*/
/*####################### SIde view ###############################*/
/*####################### circumfrence ###############################*/
/*###################### height ##################################*/
  public int height() {
	  return height(head);
  }
  
  private int height(Node n) {
	  if(n == null)
		   return 0;
	  else return 1 + Math.max(height(n.left), height(n.right));
  }
  
/*###################### Diameter ###################################*/	
	public int diameter() {
		return diameter(head);
	}
	
   private int diameter(Node node)
    {
        // Your code here
        if(node == null)
            return 0;
            
         int l = height(node.left);
         int  r = height(node.right);
         
         int temp = 1+ l + r; //calculate current
         int dia = Math.max(diameter(node.left),diameter(node.right)); //gives the n-1 pMI
        // return  temp > Math.max(diameter(node.left),diameter(node.right)) ? temp : Math.max(diameter(node.left),diameter(node.right));
         return  temp > dia ? temp : dia;
    }
	
	
	
	
/*################### Node class #####################*/	

	private class Node{
		private K key;
		private V val;
		private Node left;
		private Node right;
		
		private int N; // for weight of Node
		
		public Node(K key , V val) {
			this.key = key;
			this.val = val;
			this.N = 1;
			left = null;
			right = null;
		}
		
	}
}
