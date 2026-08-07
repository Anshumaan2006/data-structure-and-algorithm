class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {

        int count = 0;

        // Calculate sum of first window
        for(int i = 0; i < k; i++)
        {
            count += arr[i];
        }

        int avg = count / k;
        int n = 0;

        // Check the first window
        if(avg >= threshold)
        {
            n++;
        }

        // Slide the window
        for(int i = k; i < arr.length; i++)
        {
            count = count - arr[i - k] + arr[i];
            avg = count / k;

            if(avg >= threshold)
            {
                n++;
            }
        }

        return n;
    }
}