class Solution {
    public long maximumSubarraySum(int[] nums, int k) {

        HashMap<Integer, Long> map = new HashMap<>();

        long prefix = 0;
        long ans = Long.MIN_VALUE;

        for (int x : nums) {

            // x - k can be the starting element
            if (map.containsKey(x - k)) {
                ans = Math.max(ans, prefix + x - map.get(x - k));
            }

            // x + k can be the starting element
            if (map.containsKey(x + k)) {
                ans = Math.max(ans, prefix + x - map.get(x + k));
            }

            // Store minimum prefix sum for value x
            map.put(x, Math.min(
                map.getOrDefault(x, Long.MAX_VALUE),
                prefix
            ));

            prefix += x;
        }

        return ans == Long.MIN_VALUE ? 0 : ans;
    }
}