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
        pref[0] = 0;
        for(int i = 1; i < n; i++){
            pref[i] = Math.max(height[i-1], pref[i-1]);
        }
        //suffix
        suff[n-1] = 0;
        for(int i = n - 2; i >= 0; i--){
            suff[i] = Math.max(height[i+1], suff[i+1]);
        }
        //total water calc
        int totalWater = 0;
        for(int i = 1; i < n-1; i++){
            int min = Math.min(pref[i], suff[i]);
            if(min - height[i] < 0){
                continue;
            }
            totalWater += min - height[i];
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