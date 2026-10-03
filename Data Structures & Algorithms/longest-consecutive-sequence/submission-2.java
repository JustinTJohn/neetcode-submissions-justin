class Solution {
    public int longestConsecutive(int[] nums) {
        int res = 0;
        Set<Integer> set = new HashSet<>();

        for(int n : nums){
            set.add(n);
        }

        for(int n : nums){
            if(set.contains(n - 1)){
                continue;
            }

            int temp = 0;
            while(set.contains(n++)){
                temp++;
            }
            res = Math.max(res, temp);
        }
        return res;
    }
}
