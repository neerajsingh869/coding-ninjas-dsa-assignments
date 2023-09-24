package tries;

import java.util.ArrayList;

// 65 -> A

public class Trie {
	private TrieNode root;
	
	public Trie() {
		root = new TrieNode('\0');
	}
	
	// Time complexity -> O(word length)
	public void add(String word) {
		TrieNode parentTrieNode = root;
		int i = 0;
		int n = word.length();
		while(i < n && parentTrieNode.children[word.charAt(i)-'A'] != null) {
			parentTrieNode = parentTrieNode.children[word.charAt(i)-'A'];
			if(i == n - 1) {
				parentTrieNode.isTerminal = true;
			}
			i++;
		}
		while(i < n) {
			char childData = word.charAt(i);
			TrieNode newTrieNode = new TrieNode(childData);
			parentTrieNode.children[childData-'A'] = newTrieNode;
			parentTrieNode.childCount++;
			parentTrieNode = newTrieNode;
			if(i == n - 1) {
				parentTrieNode.isTerminal = true;
			}
			i++;
		}
	}
	
	public void addRecursion(String word) {
		addRecursion(root, word, 0);
	}
	
	// Can use substring() method instead of "i" also
	// Time complexity -> O(word length)
	private static void addRecursion(TrieNode parentTrieNode, String word, int i) {
		int n = word.length();
		if(parentTrieNode == null) {
			return;
		}
		if(i == n) {
			parentTrieNode.isTerminal = true;
			return;
		}
		char childData = word.charAt(i);
		int childIdx = childData - 'A';
		TrieNode child = parentTrieNode.children[childIdx];
		if(child == null) {
			child = new TrieNode(childData);
			parentTrieNode.children[childIdx] = child;
			parentTrieNode.childCount++;
		}	
		parentTrieNode = child;
		addRecursion(parentTrieNode, word, i+1);
	}
	
	public boolean search(String word){
		int n = word.length();
		int i = 0;
		TrieNode parentTrieNode = root;
		while(i < n && parentTrieNode != null){
			TrieNode child = parentTrieNode.children[word.charAt(i) - 'A'];
			if(child != null){
				parentTrieNode = child;
				i++;
			}
			else{
				return false;
			}
		}
		if(i == n){
			return parentTrieNode.isTerminal;
		}
		else{
			return false;
		}
	}
	
	// Time complexity -> O(word length)
	public boolean searchRecursion(String word) {
		return searchRecursion(root, word);
	}
	
	private static boolean searchRecursion(TrieNode parentTrieNode, String word){
		if (parentTrieNode == null) {
			return false;
		}
		if(word.length() == 0){
			return parentTrieNode.isTerminal;
		}
		char childData = word.charAt(0);
		int childIdx = childData - 'a';
		TrieNode child = parentTrieNode.children[childIdx];
		if(child != null){
			return searchRecursion(child, word.substring(1));
		}
		else{
			return false;
		}
	}
	
	public void remove(String word) {
		remove(root, word);
	}
	
	private static void remove(TrieNode parentTrieNode, String word) {
		if(word.length() == 0) {
			parentTrieNode.isTerminal = false;
			return;
		}
		char childData = word.charAt(0);
		int childIdx = childData - 'a';
		TrieNode child = parentTrieNode.children[childIdx];
		if(child == null) {
			return ;
		}
		remove(child, word.substring(1));
		if(!child.isTerminal && child.childCount == 0) {
			parentTrieNode.children[childIdx] = null;
			parentTrieNode.childCount--;
		}
	}
	
	public int countWords() {
		return countWords(root);
	}

	private static int countWords(TrieNode parentTrieNode){
		if(parentTrieNode == null){
			return 0;
		}
		int count = 0;
		if(parentTrieNode.isTerminal){
			count++;
		}
		for(TrieNode child : parentTrieNode.children){
			count += countWords(child);
		}
		return count;
	}
	
	/*
	 * Given a list of n words and a pattern p that we want 
	 * to search. Check if the pattern p is present the given 
	 * words or not. Return true if the pattern is present and 
	 * false otherwise.
	 */
	public boolean patternMatching(ArrayList<String> vect, String pattern) {
		for(String word : vect){
			add(word);
		}
		return patternMatching(root, pattern);
	}

	private static boolean patternMatching(TrieNode parTrieNode, String pattern){
		if(parTrieNode == null){
			return false;
		}
		if(pattern.length() == 0){
			return true;
		}
		boolean ans = false;
		char patternChar = pattern.charAt(0);
		TrieNode child = parTrieNode.children[patternChar - 'a'];
		if(child != null){
			ans = patternMatching(child, pattern.substring(1));
		}
		for (TrieNode childNode : parTrieNode.children) {
			boolean tempAns = patternMatching(childNode, pattern);
			ans = (ans || tempAns);
		}
		return ans;
	}
	
	/*
	 * Given n number of words and an incomplete word w. 
	 * You need to auto-complete that word w.
	 * 
	 * That means, find and print all the possible words which 
	 * can be formed using the incomplete word w.
	 * 
	 * Note : Order of words does not matter.
	 */
	public void autoComplete(ArrayList<String> input, String word) {
		for(String i : input){
			add(i);
		}
		TrieNode parentTrieNode = root;
		int i = 0;
		int n = word.length();
		while(i < n){
			TrieNode child = parentTrieNode.children[word.charAt(i) - 'a'];
			if(child == null){
				return;
			}
			parentTrieNode = child;
			i++;
		}
		printAllWords(parentTrieNode, word);
    }

	private static void printAllWords(TrieNode parentTrieNode, String word){
		if(parentTrieNode == null){
			return;
		}
		if(parentTrieNode.isTerminal){
			System.out.println(word);
		}
		for(TrieNode child : parentTrieNode.children){
			if(child != null){
				printAllWords(child, word + child.data);
			}
		}
	}
	
}
