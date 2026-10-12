class Solution {
    public int longestConsecutive(int[] nums) {
        int ans = 0;
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        for(int num : nums){
            int temp = 0;
            if(!set.contains(num - 1)){
                temp = 1;
                 while(set.contains(num + 1)){
                    temp++;
                    num++;
                }
            }
            ans = Math.max(ans, temp);
        }
        return ans;
    }
}

//TC: O(N)
//SC: O(N)