// Implement Trie
class PrefixTree {
    public PrefixTree[] children;
    public boolean endOfWord;

    public PrefixTree() {
         children = new PrefixTree[26];
         endOfWord = false;
    }

    public void insert(String word) {
        PrefixTree node = this;

        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);

            if (node.children[letter - 'a'] == null) {
                node.children[letter - 'a'] = new PrefixTree();
            }
            node = node.children[letter - 'a'];
        }

        node.endOfWord = true;
    }

    public boolean search(String word) {
        PrefixTree node = this;

        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);

            if (node.children[letter - 'a'] == null) {
                return false;
            }

            node = node.children[letter - 'a'];
        }

        return node.endOfWord;
    }

    public boolean startsWith(String prefix) {
        PrefixTree node = this;
        
        for (int i = 0; i < prefix.length(); i++) {
            char letter = prefix.charAt(i);

            if (node.children[letter - 'a'] == null) {
                return false;
            }

            node = node.children[letter - 'a'];
        }

        return true;
    }
}
