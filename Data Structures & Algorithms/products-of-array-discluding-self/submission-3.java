class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        int prefix = 1;
        for(int i = 0; i < n; i++){
            res[i] = prefix;
            prefix *= nums[i];
        }

        int postfix = 1;
        for(int i = n - 1; i >= 0; i--){
            res[i] = res[i] * postfix;
            postfix *= nums[i]; 
        }
        return res;
    }
}  
//1 2 3 4 5

//pre = 1

// index res[i]
// 0 1
// 1 1
// 2 2
// 3 8

// index res[i]
// 0 1
// 1 1
// 2 2
// 3 8

// 8


