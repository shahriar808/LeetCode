class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (words.length != pattern.length()) {
            return false;
        }
        Map<Character, String> map = new HashMap<>();
        Set<String> usedWords = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            char c = pattern.charAt(i);
            if(map.containsKey(c)){
                if (!map.get(c).equals(words[i])) {
                    return false;
                }
            }
            else{
                if(usedWords.contains(words[i])){
                    return false;
                }
                map.put(c, words[i]);
                usedWords.add(words[i]);
            }
        }
        return true;
    }
}