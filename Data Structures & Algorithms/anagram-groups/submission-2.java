class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s: strs){
            char[] chars = s.toCharArray();
            int[] freq = new int[26];
            for(char c: chars){
                freq[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for(int f: freq){
                sb.append(f).append("#");
            }
            String key = sb.toString();
            if(map.containsKey(key)){
                // List<String> list = map.get(sb);
                // list.add(s);
                map.get(key).add(s);
            }
            else{
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(key, list);
            }
        }
        return new ArrayList<>(map.values());
    }
}

//TC: O(N)
//SC: O(N)