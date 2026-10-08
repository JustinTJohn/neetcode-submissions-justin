class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length - 1;
        while(l < r){
            int total = numbers[l] + numbers[r];
            if(total < target){
                l++;
            }
            else if(total > target){
                r--;
            }
            else{
                return new int[]{l+1, r+1};
            }
        }
        return new int[0];
    }
}

//TC: O(N)
//SC: O(1)
