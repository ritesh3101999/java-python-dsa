/* 
=====================================================================================================================================================
Question: A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings.
Implement the Trie class:
- Trie() Initializes the trie object.
- void insert(String word) Inserts the string word into the trie.
- boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
- boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix, and false otherwise.
=====================================================================================================================================================
Examples
=====================================================================================================================================================
Example 1:

Input: 
["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]

Output: 
[null, null, true, false, true, null, true]
=====================================================================================================================================================
Complexity Analysis
=====================================================================================================================================================
Time Complexity: O(m) 
— For insert, search, and startsWith, where m is the length of the key. We traverse exactly m nodes.
Space Complexity: O(m) 
— For insert, we may add up to m new nodes. Search and startsWith use O(1) auxiliary space.
=====================================================================================================================================================
*/

class TrieNode {
    TrieNode[] children;
    boolean isEndOfWord;

    public TrieNode() {
        children = new TrieNode[26];
        isEndOfWord = false;
    }
}

public class ImplementTrie {
    private TrieNode root;

    public ImplementTrie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isEndOfWord = true;
    }
    
    public boolean search(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (node.children[index] == null) {
                return false;
            }
            node = node.children[index];
        }
        return node.isEndOfWord;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if (node.children[index] == null) {
                return false;
            }
            node = node.children[index];
        }
        return true;
    }

    public static void main(String[] args) {
        ImplementTrie trie = new ImplementTrie();
        trie.insert("apple");
        System.out.println("Search 'apple': " + trie.search("apple"));       // Output: true
        System.out.println("Search 'app': " + trie.search("app"));           // Output: false
        System.out.println("Starts with 'app': " + trie.startsWith("app"));  // Output: true
        trie.insert("app");
        System.out.println("Search 'app' again: " + trie.search("app"));     // Output: true
    }
}