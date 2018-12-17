package uca.utils.ds.Tree.trie;

import java.util.HashMap;
import java.util.Map;

public class TrieTree {
   
    private Trie head;
    
    public TrieTree() {
    	head = new Trie();
    }
    
   public void add(String s,int wt){
       
       head = add(head , s , wt);
   }
   
   private Trie add(Trie node, String s,int wt){ // wt --> weight word used in search Engine
       Trie root = node;
       for(int i=0 ; i<s.length() ; i++){
           
           if(!root.map.containsKey(s.charAt(i))){
              root.map.put(s.charAt(i) , new Trie());
               //root.weight = wt;
           }
        
           root = root.map.get(s.charAt(i));
           root.weight = Math.max(wt, root.weight);
           
       }
       
       root.isEnd = true;
       
       return node;
   }
 /*######################### Search Engine ########################*/
   public boolean search(String s){
       Trie root = head;
       int i=0;
       for(i=0;i<s.length() ; i++){
           
           if(!root.map.containsKey(s.charAt(i))){
               return false;
           }
           
           root = root.map.get(s.charAt(i));
           
       }
       
       if(i == s.length() )
           return root.isEnd;
       return  false;    
   }
 /*######################## max weight Search Engine###############*/
   public int maxWeight(String s){
       Trie root = head;
       int i=0;

       for(i=0;i<s.length() ; i++){
           
    	   if(!root.map.containsKey(s.charAt(i)))
               return -1;
            root = root.map.get(s.charAt(i));
       }
       return root.weight;
      // System.out.println("Maximum Weight Search : "+maxWt );
    
        
   }
   
/*################# head ######################*/  
  private class Trie{
       Map<Character, Trie> map;
       boolean isEnd;
       private int weight; // searchEngine
       
       public Trie(){
           map = new HashMap<>();
           isEnd = false;
           weight = -1;
       }
   } 
   
}
