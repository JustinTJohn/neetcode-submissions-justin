class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //Use HashMap, create a frequency key for anagram,
        //and store the elements as a list in each key
        Map<String, List<String>> map = new HashMap<>();
        for(String str: strs){
            //1. Build key
            int[] freq = new int[26];
            for(char c: str.toCharArray()){
                freq[c - 'a']++;
            }
            StringBuilder keyBuilder = new StringBuilder();
            for(int f: freq){
                keyBuilder.append(f).append("#");
            }
            String key = keyBuilder.toString();
            //2. add the key to map if not present, and add the str
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
//TC: O(N)
//SC: O(N)