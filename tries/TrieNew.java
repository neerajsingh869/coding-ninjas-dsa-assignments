package tries;

class TrieNode1{
	char data;
	boolean isTerminating;
	TrieNode1 children[];
	int childCount;

	public TrieNode1(char data) {
		this.data = data;
		isTerminating = false;
		children = new TrieNode1[26];
		childCount = 0;
	}
}

public class TrieNew {
	private TrieNode1 root;
	private int numWords;

	public TrieNew() {
		root = new TrieNode1('\0');
		numWords = 0;
	}
	
	// Time complexity -> O(word length)
	public void remove(String word){
		if(remove(root, word)) {
			numWords--;
		}
	}
	

	private boolean remove(TrieNode1 root, String word) {
		if(word.length() == 0){
			if(root.isTerminating) {
				root.isTerminating = false;
				return true;
			}
			else {
				return false;
			}
		}
		int childIndex = word.charAt(0) - 'a';
		TrieNode1 child = root.children[childIndex];
		if(child == null){
			return false;
		}
		boolean ans = remove(child, word.substring(1));
		// We can remove child node only if it is non terminating and its number of children are 0	

		if(!child.isTerminating && child.childCount == 0){
			root.children[childIndex] = null;
			child = null;
			root.childCount--;
		}
		return ans;
	}

	private boolean add(TrieNode1 root, String word){
		if(word.length() == 0){
			if(root.isTerminating) {
				return false;
			}
			else {
				root.isTerminating = true;
				return true;
			}
		}		
		int childIndex = word.charAt(0) - 'a';
		TrieNode1 child = root.children[childIndex];
		if(child == null){
			child = new TrieNode1(word.charAt(0));
			root.children[childIndex] = child;
			root.childCount++;
		}
		return add(child, word.substring(1));
	}

	// Time complexity -> O(word length)
	public void add(String word){
		if(add(root, word)) {
			numWords++;
		}
	}
	
	// Time complexity -> O(1)
	public int countWords() {
		// Write your code here
		return numWords;
	}
}
