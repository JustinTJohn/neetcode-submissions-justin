class Solution {
    public int trap(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int lMax = height[l], rMax = height[r];
        int totalWater = 0;
        while(l < r){
            if(lMax <= rMax){
                l++;
                if(lMax - height[l] > 0){
                    totalWater += lMax - height[l];
                }
                lMax = Math.max(lMax, height[l]);
            }
            else{
                r--;
                if(rMax - height[r] > 0){
                    totalWater += rMax - height[r];
                }
                rMax = Math.max(rMax, height[r]);
            }
        }
        return totalWater;
    }
}
//TC: O(N)
//SC: O(1)