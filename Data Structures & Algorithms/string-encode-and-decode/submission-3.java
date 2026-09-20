class Solution {

    public String encode(List<String> strs) {
        StringBuilder s = new StringBuilder();
        for(String str : strs){
            s.append(str.length()).append("#").append(str);
        }
        return s.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while(i < str.length()){//0<15, 7<15
            int hashIndex = str.indexOf("#", i);
            int length = Integer.parseInt(str.substring(i, hashIndex));
            res.add(str.substring(hashIndex + 1, hashIndex + length + 1));
            i = hashIndex + length + 1;
        }
        return res;
    }
}
