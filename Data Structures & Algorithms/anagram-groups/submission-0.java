class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s : strs){
            int[] chars = new int[26];

            //Constructing frequency array
            for(char c : s.toCharArray()){
                chars[c - 'a']++;
            }

            //Key will be same for anagrams
            StringBuilder keyBuilder = new StringBuilder();
            for(int c : chars){
                keyBuilder.append(c).append('#');
            }

            String key = keyBuilder.toString();

            map.putIfAbsent(key, new ArrayList());
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
