class Solution {
    public double findMaxAverage(int[] nums, int k) {

        double avg = 0.0;
        int sum = 0;

        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        avg = (double) sum / k;
        double max = avg;

        for (int i = k; i < nums.length; i++) {
            sum = sum - nums[i - k] + nums[i];
            avg = (double) sum / k;
            max = Math.max(max, avg);
        }

        return max;
    }
}