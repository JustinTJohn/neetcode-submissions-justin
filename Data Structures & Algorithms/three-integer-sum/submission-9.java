class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        //1. Sort the array
        Arrays.sort(nums);
        //2. Check if the first element is greater than 0
        if(nums.length == 0 || nums[0] > 0) return res;
        //3. For each element, use 2 pointer approach and find the 
        //element
        for(int i = 0; i < nums.length - 2; i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int l = i + 1;
            int r = nums.length - 1;
            while(l < r){
                int sum = nums[i] + nums[l] + nums[r];
                if(sum < 0){
                    l++;
                }
            else if(sum > 0){
                r--;
                }
            else{
                res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                l++;
                r--;
                while(l < r && nums[l] == nums[l-1]){
                    l++;
                }
                while(l < r && nums[r] == nums[r+1]){
                    r--;
                }
            }
        }
        }
        return res;
}
}
//TC: O(N2)
//SC: O(1)
