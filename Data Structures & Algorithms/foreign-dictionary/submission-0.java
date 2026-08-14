// Alien Dictionary
class Solution {
    public Map<Character, List<Character>> reversedList = new HashMap<>();
    public Map<Character, Boolean> seen = new HashMap<>();
    public StringBuilder result = new StringBuilder();

    public String foreignDictionary(String[] words) {
       for(String word : words){
            for(char letter : word.toCharArray()){
                reversedList.putIfAbsent(letter, new ArrayList<>());
            }
        }
        
        for(int i = 0; i < words.length - 1; i++){
            String word1= words[i];
            String word2 = words[i+1];
            
            if(word1.length() > word2.length() && word1.startsWith(word2)){
                return "";
            }

            for(int j = 0; j < Math.min(word1.length(), word2.length()); j++){
                if(word1.charAt(j) != word2.charAt(j)){
                    reversedList.get(word2.charAt(j)).add(word1.charAt(j));
                    break;
                }
            }
        }
        
        for(Character letter : reversedList.keySet()){
            boolean res = dfs(letter);
            if(!res) return "";
        }
        
        if(result.length() < reversedList.size()){
            return "";
        }
        
        return result.toString();
    }

    public boolean dfs(Character letter) {
        if(seen.containsKey(letter)){
            return seen.get(letter);
        }
        
        seen.put(letter, false);
        
        for(Character next: reversedList.get(letter)){
            boolean res = dfs(next);
            if(!res) return false;
        }
        
        seen.put(letter, true);
        result.append(letter);
        return true;
    }
}
