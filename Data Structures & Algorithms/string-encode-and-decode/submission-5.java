class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str : strs){
            sb.append(str.length()).append("#").append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while(i < str.length()){
            int hashIndex = str.indexOf("#", i);
            int length = Integer.parseInt(str.substring(i, hashIndex));
            res.add(str.substring(hashIndex + 1, hashIndex + 1 + length));
            i = hashIndex + 1 + length;
        }
        return res;
    }
}

//TC: O(m + n) for each encode() and decode() function calls
//SC: O(1) since we exclude the output space. If interviewer wants it to be included, then its O(m + n) for each encode() and decode() function calls 
//where m is the sum of length of all the string, and n is the number of strings