class Solution {
    public int longestConsecutive(int[] nums) {
        int ans = 0;
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            if(!set.contains(num)){
                set.add(num);
            }
        }
        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            //not the first digit of the sequence
            if(set.contains(num - 1)){
                continue;
            }
            int res = 1;
            while(set.contains(++num)){
                res++;
            }
            ans = Integer.max(ans, res);
        }
        return ans;
    }
}
