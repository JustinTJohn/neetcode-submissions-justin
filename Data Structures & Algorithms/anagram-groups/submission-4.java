class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s: strs){
            int[] freq = new int[26];
            for(char c: s.toCharArray()){
                freq[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for(int f: freq){
                sb.append(f).append("#");
            }
            String key = sb.toString();
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }
}

//TC: O(N)
//SC: O(N)