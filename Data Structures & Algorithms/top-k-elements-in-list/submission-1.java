class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //Bucket sort
        //1. Frequency map, (count the frequency for each element)
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        //2. The max number of time a number can occur is equal to the 
        //length of the array, so create a bucket array with the index
        //representing frequency, and value representing arraylist
        List<Integer>[] bucket = new List[nums.length + 1];
        for(int key: map.keySet()){
            int freq = map.get(key);
            if(bucket[freq] == null){
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(key);
        }
        //3. Loop backwards from the highest frequency element
        int[] res = new int[k];
        int j = 0;
        for(int i = bucket.length-1; i >= 0 && j < k; i--){
            if(bucket[i] != null){
                for(int num: bucket[i]){
                    res[j++] = num;
                    if(j == k){
                        break;
                    }
                }
            }
        }
        return res;
    }
}

//TC: O(N)
//SC: O(N)
