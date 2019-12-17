package xsir;

import java.util.*;
import java.util.stream.Collectors;

public class WordDictionary {
    private static class TrieNode {
        public boolean isEnd;
        Map<Character, TrieNode> child = new HashMap<>();
    }

    private Map<Character, TrieNode> trieMap;

    /** Initialize your data structure here. */
    public WordDictionary() {
        trieMap = new HashMap<>();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        if (word == null || word.length() == 0) {
            return;
        }
        TrieNode cur = null;
        Map<Character, TrieNode> child = trieMap;
        for (int i = 0; i < word.length(); i++) {
            if (child.get(word.charAt(i)) == null) {
                TrieNode node = new TrieNode();
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

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        if (word == null || word.length() == 0) {
            return false;
        }
        List<Map<Character, TrieNode>> children = Collections.singletonList(trieMap);
        List<TrieNode> cur = null;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                cur = children.stream().flatMap(child -> child.values().stream()).collect(Collectors.toList());
                children = cur.stream().map(node -> node.child).collect(Collectors.toList());
            } else {
                if (children.stream().noneMatch(child -> child.containsKey(c))) {
                    return false;
                }
                cur = children.stream().map(child -> child.get(c)).filter(child -> child != null).collect(Collectors.toList());
                children = cur.stream().map(node -> node.child).collect(Collectors.toList());
            }
        }
        return cur.stream().anyMatch(node -> node.isEnd);
    }

    public static void main(String[] args) {
        WordDictionary dict = new WordDictionary();
        dict.addWord("bad");
        dict.addWord("dad");
        dict.addWord("mad");
        System.out.println(dict.search("pad"));
        System.out.println(dict.search("bad"));
        System.out.println(dict.search(".ad"));
        System.out.println(dict.search("b.."));
    }
}
