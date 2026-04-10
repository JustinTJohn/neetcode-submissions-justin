class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //Step 1: Calculate the freqMap
        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int num : nums){
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        //Step 2: Create the bucket where index = frequency
        List<Integer>[] bucket = new List[nums.length + 1];
        for(int key : freqMap.keySet()){
            int freq = freqMap.get(key);
            if(bucket[freq] == null){
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(key);
        }

        //Step 3: Create a result array, and store the top k elements in this
        int[] res = new int[k];
        int index = 0;

        for(int i = bucket.length - 1; i>=0 && index < k; i--){
            if(bucket[i] != null){
                for(int num : bucket[i]){
                    res[index++] = num;
                    if(index == k) break;
                }
            }
        }
        return res;
    }
}
