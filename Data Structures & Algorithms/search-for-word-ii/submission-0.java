// Word Search II
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
}

class Solution {
    public char[][] board;
    public int rows;
    public int cols;

    public final int[] rowDir = {0, 1, 0, -1};
    public final int[] colDir = {1, 0, -1, 0};

    public List<String> findWords(char[][] board, String[] words) {
        this.board = board;
        this.rows = board.length;
        this.cols = board[0].length;

        List<String> result = new ArrayList<>();
        PrefixTree trie = new PrefixTree();

        for (String word : words) {
            trie.insert(word);
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                backtrack(row, col, trie, new StringBuilder(), result);
            }
        }

        return result;
    }

     public void backtrack(int row, int col, PrefixTree node, StringBuilder currentWord, List<String> result) {

        if (row < 0 || row >= rows || col < 0 || col >= cols ||
            board[row][col] == '#') {
            return;
        }

        char letter = board[row][col];

        if (node.children[letter - 'a'] == null) {
            return;
        }

        node = node.children[letter - 'a'];
        currentWord.append(letter);

        if (node.endOfWord) {
            result.add(currentWord.toString());
            node.endOfWord = false;
        }

        char originalChar = board[row][col];
        board[row][col] = '#';

        for (int direction = 0; direction < 4; direction++) {
            int nextRow = row + rowDir[direction];
            int nextCol = col + colDir[direction];
            backtrack(nextRow, nextCol, node, currentWord, result);
        }

        board[row][col] = originalChar;
        currentWord.deleteCharAt(currentWord.length() - 1);
    }
}
