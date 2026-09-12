class Solution {

    public String encode(List<String> strs) {
        StringBuilder encoded_string = new StringBuilder();
        for(String s: strs){
            encoded_string.append(s.length()).append("#").append(s);
        }
        return encoded_string.toString(); //5#Hello5#World
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while(i < str.length()){
            int hashIndex = str.indexOf("#", i);
            int length = Integer.parseInt(str.substring(i, hashIndex));
            res.add(str.substring(hashIndex + 1, hashIndex + length + 1));
            i = hashIndex + length + 1;
        }
        return res;
    }
}