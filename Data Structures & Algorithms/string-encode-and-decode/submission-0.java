// Encode and Decode Strings
class Solution {

    public String encode(List<String> strs) {
        StringBuilder output = new StringBuilder();

        for (String str : strs) {
            output.append(str.length());
            output.append('#');
            output.append(str);
        }
        return output.toString();
    }

    public List<String> decode(String str) {
        List<String> output = new ArrayList<>();
        int i = 0, j;
        
        while (i < str.length()) {
            j = i;
            while (str.charAt(j) != '#') {
                j++;
            }
            int length = Integer.parseInt(str.substring(i, j));
            i = j + 1;
            output.add(str.substring(i, i + length));
            i += length;
        }
        return output;
    }
}
