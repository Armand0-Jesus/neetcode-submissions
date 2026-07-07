// Group Anagrams
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] letters = str.toCharArray();
            Arrays.sort(letters);

            String value = new String(letters);

            map.putIfAbsent(value, new ArrayList<>());
            map.get(value).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
