package com.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * ×ÖµäÊ÷
 * @author fluo
 */
public class Trie {

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        if(search(word)) return;//ÒÑ´æÔÚ
        
        TrieNode curNode = root;
        for(int i=0;i<word.length();i++){
        	Map<Character, TrieNode> curSon = curNode.sons;
        	if(curSon.get(word.charAt(i))!=null){
        		curNode = curSon.get(word.charAt(i));
        	}else{
        		TrieNode tmp = new TrieNode(word.charAt(i));
        		curSon.put(word.charAt(i),tmp);
        		curNode=tmp;
        	}
        	if(i==word.length()-1) curNode.isEnd=true;
        }
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
    	TrieNode curNode = root;
    	for(int i=0;i<word.length();i++){
    		Map<Character, TrieNode> curSon = curNode.sons;
    		if(curSon.get(word.charAt(i))!=null){
    			curNode=curSon.get(word.charAt(i));
    		}else{
    			return false;
    		}
    	}
    	if(curNode.isEnd){
    		return true;
    	}
    	return false;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
    	TrieNode curNode = root;
    	for(int i=0;i<prefix.length();i++){
    		Map<Character, TrieNode> curSon = curNode.sons;
    		if(curSon.get(prefix.charAt(i))!=null){
    			curNode=curSon.get(prefix.charAt(i));
    		}else{
    			return false;
    		}
    	}
    	return true;
    }
}
class TrieNode {
	public char c;
	public Map<Character, TrieNode> sons;
	public boolean isEnd;
	
    // Initialize your data structure here.
    public TrieNode() {
        isEnd=false;
        sons = new HashMap<Character,TrieNode>();
    }
    public TrieNode(char c) {
    	isEnd=false;
    	sons = new HashMap<Character,TrieNode>();
    	this.c = c;
    }
}