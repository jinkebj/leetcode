# Implement Trie (Prefix Tree)

Implement a trie with insert, search, and startsWith methods.

Example:

    Trie trie = new Trie();

    trie.insert("apple");
    trie.search("apple");   // returns true
    trie.search("app");     // returns false
    trie.startsWith("app"); // returns true
    trie.insert("app");   
    trie.search("app");     // returns true

Note:

- You may assume that all inputs are consist of lowercase letters a-z.
- All inputs are guaranteed to be non-empty strings.

**Java:**
```java
class Trie {

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode p = root;
        for (int i = 0; i < word.length(); i++) {
            int index = (int)(word.charAt(i) - 'a');
            if (p.children[index] == null) p.children[index] = new TrieNode();
            p = p.children[index];
        }
        p.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = find(word);
        return node != null && node.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return find(prefix) != null;
    }

    private TrieNode find(String prefix) {
        TrieNode p = root;
        for (int i = 0; i < prefix.length(); i++) {
            int index = (int)(prefix.charAt(i) - 'a');
            if (p.children[index] == null) return null;
            p = p.children[index];
        }
        return p;
    }

    private class TrieNode {
        public TrieNode() {
            children = new TrieNode[26];
            isWord = false;
        }
        public boolean isWord;
        public TrieNode[] children;
    }

    private TrieNode root;
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
```
