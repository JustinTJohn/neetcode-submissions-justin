class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //1. Sort the array
        //2. For each index, check if its not a duplicate by checking
        //the previous element. If duplicate go to the next element
        //3. Using two pointers, check for other elements
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        if(nums.length == 0 || nums[0] > 0) return res;
        for(int i = 0; i < nums.length; i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int l = i + 1;
            int r = nums.length - 1;
            while(l < r){
                int sum = nums[i] + nums[l] + nums[r];
                if(sum > 0){
                    r--;
                }
                else if(sum < 0){
                    l++;
                }
                else{
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    r--;
                    while(l < r && nums[l] == nums[l-1]){
                        l++;
                    }
                    while(l < r && nums[r] == nums[r + 1]){
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
