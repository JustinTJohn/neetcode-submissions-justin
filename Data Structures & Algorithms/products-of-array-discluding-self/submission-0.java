class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int[] prefProd = new int[n];
        int[] suffProd = new int[n];
        //Prefix prod
        prefProd[0] = nums[0];
        for(int i=1; i<n; i++){
            prefProd[i] = prefProd[i-1] * nums[i]; 
        }
        //Suffix prod
        suffProd[n-1] = nums[n-1];
        for(int i=n-2; i>=0; i--){
            suffProd[i] = nums[i] * suffProd[i+1];
        }
        //Result
        for(int i=0; i<n; i++){
            if(i==0){
                res[i] = suffProd[i+1];
            }
            else if(i==n-1){
                res[i] = prefProd[i-1];
            }
            else{
                res[i] = prefProd[i-1] * suffProd[i+1];
            }
        }
        return res;
    }
}  
