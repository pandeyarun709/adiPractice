package uca.utils.ds.Tree.trie;

import java.util.Scanner;

public class TestTrie {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	/*	TrieTree trie = new TrieTree();
		
		trie.add("hackerrank" , 9);
		trie.add("hackerearth",11);
		trie.add("Rahul",6);
		
	    trie.maxWeight("hacker"); */ 
		
		Scanner sc = new Scanner(System.in);
        int size=0;
        size = sc.nextInt();
        int n ;
        n = sc.nextInt();
        
        TrieTree t = new TrieTree();
        String s;
        for(int i =0 ; i< size;i++){
             s = sc.next();
            int prio = sc.nextInt();
             t.add( s , prio);
        }
       
         for(int j =0; j<n; j++) {
             s = sc.next();
        	 System.out.println(t.maxWeight(s));
        }
         

	}

}



/*
 
 Test case
50 20
egfsicxoqe 11
egfsidkqve 63
egfsigvthk 3
egfsihbfgi 76
egfsijhspc 40
egfsijoofb 10
egfsikgygl 48
egfsilmdfm 2
egfsitwfej 53
egfsivpjet 5
ivpoccxoqe 3
ivpocdkqve 73
ivpocgvthk 43
ivpochbfgi 4
ivpocjhspc 100
ivpocjoofb 36
ivpockgygl 16
ivpoclmdfm 76
ivpoctwfej 6
ivpocvpjet 9
ixkfgcxoqe 39
ixkfgdkqve 64
ixkfggvthk 29
ixkfghbfgi 40
ixkfgjhspc 70
ixkfgjoofb 41
ixkfgkgygl 91
ixkfglmdfm 4
ixkfgtwfej 86
ixkfgvpjet 42
lhppecxoqe 92
lhppedkqve 79
lhppegvthk 35
lhppehbfgi 40
lhppejhspc 3
lhppejoofb 57
lhppekgygl 99
lhppelmdfm 11
lhppetwfej 42
lhppevpjet 67
lqdsfcxoqe 91
lqdsfdkqve 61
lqdsfgvthk 45
lqdsfhbfgi 100
lqdsfjhspc 21
lqdsfjoofb 59
lqdsfkgygl 90
lqdsflmdfm 67
lqdsftwfej 84
lqdsfvpjet 32
ivpoc
ywove
pyaqy
egfsi
whafj
lqdsf
ixkfg
lhppe
yulqs
sxlfx
joofb
hbfgi
kgygl
lmdfm
gvthk
twfej
dkqve
vpjet
jhspc
cxoqe*/


/*output
 100
-1
-1
76
-1
100
91
99
-1
-1
-1
-1
-1
-1
-1
-1
-1
-1
-1
 
*/