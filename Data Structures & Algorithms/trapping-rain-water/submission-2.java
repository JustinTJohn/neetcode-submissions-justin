class Solution {
    public int trap(int[] height) {
        //1. Construct prefix and suffix max array
        int n = height.length;
        if(n < 3){
            return 0;
        }
        int[] pref = new int[n];
        int[] suff = new int[n];
        //prefix
        pref[0] = height[0];
        for(int i = 1; i < n; i++){
            pref[i] = Math.max(pref[i-1], height[i]);
        }
        //suffix
        suff[n-1] = height[n-1];
        for(int i = n - 2; i >= 0; i--){
            suff[i] = Math.max(suff[i+1], height[i]);
        }
        //total water calc
        int totalWater = 0;
        for(int i = 0; i < n; i++){
            totalWater += Math.min(pref[i], suff[i]) - height[i];
        }
        return totalWater;
    }
}

//TC: O(N)
//SC: O(1)


//i = 0, pref[0] = 0
//i = 1, pref[1] = 0
//i = 2, pref[2] = 2
//i = 3, pref[3] = 2
//i = 4, pref[4] = 3