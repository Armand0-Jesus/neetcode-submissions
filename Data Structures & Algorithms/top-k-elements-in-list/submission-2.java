// Top K Frequent Elements
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer>[] buckets = new ArrayList[nums.length + 1];
        int[] res = new int[k];

        for (int i = 0; i <= nums.length; i++) {
            buckets[i] = new ArrayList<>();
        }

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            int freq = map.get(num);
            buckets[freq].add(num);
        }

        for (int i = nums.length ; i >= 0; i--) {
            if (buckets[i].size() == k) {
                for (int j = 0; j < k; j++) {
                    res[j] = buckets[i].get(j);
                }
                break;
            }
        }
        return res;
    }
}
