class Solution:
    def trap(self, height: List[int]) -> int:
        if height is None or len(height) < 3:
            return 0
        
        totalWater = 0;
        l, r = 0, len(height) - 1
        lMax, rMax = height[l], height[r]
        
        while(l < r):
            if lMax <= rMax:
                l += 1
                lMax = max(lMax, height[l])
                totalWater += lMax - height[l]
            else:
                r -= 1
                rMax = max(rMax, height[r])
                totalWater += rMax - height[r]
        
        return totalWater

#TC: O(N), SC: O(1)
