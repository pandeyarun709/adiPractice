package uca.utils.ds.Tree.bst;

public class TestBst {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BST<Integer , String> bst = new BST<Integer,String>();
		bst.add(5, "five");
		bst.add(7, "seven");
		bst.add(3, "three");
		bst.add(4, "four");
		bst.add(1, "one");
		bst.add(1, "one");//repeat value not accepted
		bst.add(6, "six");
		bst.add(2, "two");
		bst.add(8, "eight");
		bst.add(7, "seven");//repeat value not accepted
		
		bst.inOrder();
		bst.postOrder();
		bst.preOrder();
		bst.zigZag();
		bst.topView();
		bst.bottomView();
		bst.getRank(7); // 7
		bst.getRank(4); // 4
		
		
	 bst.commonAncestor(2, 8) ; //5
	 bst.commonAncestor(2, 1); // 1
     bst.commonAncestor(4, 4); // 4
      System.out.println("Diameter : " + bst.diameter());
	}

}
