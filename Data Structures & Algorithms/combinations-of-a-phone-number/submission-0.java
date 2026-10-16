// Letter Combinations of a Phone Number
class Solution {
    public String[] digitsToLetters = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();

        if (digits.isEmpty()) {
            return combinations;
        }
        
        backtrack(combinations, digits, "", 0);
        return combinations;
    }

    public void backtrack(List<String> combinations, String digits, String currCombination, int index) {
        if (index == digits.length()) {
            combinations.add(currCombination);
            return;
        }

        String letters = digitsToLetters[digits.charAt(index) - '0'];

        for (char letter : letters.toCharArray()) {
            backtrack(combinations, digits, currCombination + letter, index + 1);
        }
    }
}
