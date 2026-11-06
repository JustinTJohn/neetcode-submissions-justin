class Solution {
    public int maxArea(int[] heights) {
        int maxWater = 0;
        int l = 0;
        int r = heights.length - 1;
        while(l < r){
            int water = Math.min(heights[l], heights[r]) * (r - l);
            maxWater = Math.max(water, maxWater);
            if(heights[l] < heights[r]){
                l++;
            }
            else{
                r--;
            }
        }
        return maxWater;
    }
}
//TC: O(N)
//SC: O(1)