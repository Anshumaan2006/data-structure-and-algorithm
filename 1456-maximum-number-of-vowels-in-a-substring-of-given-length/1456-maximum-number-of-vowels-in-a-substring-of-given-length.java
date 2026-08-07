class Solution {

    public int maxVowels(String s, int k) {

        int count = 0;

        // Count vowels in first window
        for(int i = 0; i < k; i++)
        {
            if(isVowels(s.charAt(i)))
                count++;
        }

        int max = count;

        // Slide the window
        for(int i = k; i < s.length(); i++)
        {
            // Remove left character
            if(isVowels(s.charAt(i - k)))
                count--;

            // Add new character
            if(isVowels(s.charAt(i)))
                count++;

            max = Math.max(max, count);
        }

        return max;
    }

    public boolean isVowels(char ch)
    {
        return ch=='a' ||
               ch=='e' ||
               ch=='i' ||
               ch=='o' ||
               ch=='u';
    }
}