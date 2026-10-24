class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //Size of the array = max no of elements that occur with size 1
        //Create an array equal to length of nums + 1, and at each
        //index, store the element equal to the frequency there
        //Then loop the array from backwards and return the last K
        //elements
        //1. Frequency
        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int num: nums){
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        //2. Bucket 
        List<Integer>[] bucket = new List[nums.length + 1];
        for(int key: freqMap.keySet()){
            int freq = freqMap.get(key);
            if(bucket[freq] == null){
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(key);
        }
        //Loop from the back, and return the answer
        int[] res = new int[k];
        int j = 0;
        for(int i = bucket.length - 1; i>=0 && j<k; i--){
            if(bucket[i] != null){
                for(int num: bucket[i]){
                    res[j++] = num;
                    if(j == k) break;
                }
            }
        }
        return res;
    }   
}

//TC: O(N)
//SC: O(N)
