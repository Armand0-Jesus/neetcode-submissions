// Design Add and Search Word Data Structure
class WordDictionary {
    public WordDictionary[] dictionary;
    public boolean endOfWord;

    public WordDictionary() {
        dictionary = new WordDictionary[26];
        endOfWord = false;
    }

    public void addWord(String word) {
        WordDictionary node = this;

        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);

            if (node.dictionary[letter - 'a'] == null) {
                node.dictionary[letter - 'a'] = new WordDictionary();
            }

            node = node.dictionary[letter - 'a'];
        }

        node.endOfWord = true;
    }

    public boolean search(String word) {
        WordDictionary node = this;

        return dfs(word, 0, node);
    }

    public boolean dfs(String word, int index, WordDictionary node) {
        if (index == word.length()) {
            return node.endOfWord;
        }

        char letter = word.charAt(index);
        
        if (letter != '.') {
            int position = letter - 'a';

            if (node.dictionary[position] == null) {
                return false;
            }

            return dfs(word, index + 1, node.dictionary[position]);
        }

        for (int i = 0; i < 26; i++) {
            if (node.dictionary[i] != null) {
                if (dfs(word, index + 1, node.dictionary[i])) {
                    return true;
                }
            }
        }

        return false;
    }
}
