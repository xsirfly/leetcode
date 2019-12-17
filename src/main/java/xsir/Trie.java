package xsir;

import java.util.HashMap;
import java.util.Map;

public class Trie {

    private static class TrieNode {
        public Character val;
        public boolean isEnd;
        Map<Character, TrieNode> child = new HashMap<>();

        public TrieNode(Character val) {
            this.val = val;
        }
    }

    private Map<Character, TrieNode> trieMap;

    /** Initialize your data structure here. */
    public Trie() {
        trieMap = new HashMap<>();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (word == null || word.length() == 0) {
            return;
        }
        TrieNode cur = null;
        Map<Character, TrieNode> child = trieMap;
        for (int i = 0; i < word.length(); i++) {
            if (child.get(word.charAt(i)) == null) {
                TrieNode node = new TrieNode(word.charAt(i));
                child.put(word.charAt(i), node);
                child = node.child;
                cur = node;
            } else {
                cur = child.get(word.charAt(i));
                child = cur.child;
            }
        }
        cur.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if (word == null || word.length() == 0) {
            return false;
        }
        TrieNode cur = null;
        Map<Character, TrieNode> child = trieMap;
        for (int i = 0; i < word.length(); i++) {
            if (!child.containsKey(word.charAt(i))) {
                return false;
            }
            cur = child.get(word.charAt(i));
            child = cur.child;
        }
        return cur.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if (prefix == null || prefix.length() == 0) {
            return false;
        }
        Map<Character, TrieNode> child = trieMap;
        for (int i = 0; i < prefix.length(); i++) {
            if (!child.containsKey(prefix.charAt(i))) {
                return false;
            }
            child = child.get(prefix.charAt(i)).child;
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("apple");
        System.out.println(trie.search("apple"));   // returns true
        System.out.println(trie.search("app"));     // returns false
        System.out.println(trie.startsWith("app")); // returns true
        trie.insert("app");
        System.out.println(trie.search("app"));     // returns true
    }
}
