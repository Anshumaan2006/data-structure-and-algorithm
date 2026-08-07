class Solution {

    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> ans = new ArrayList<>();

        if (s.length() < p.length())
            return ans;

        int[] pFreq = new int[26];
        int[] sFreq = new int[26];

        // Frequency of pattern
        for (int i = 0; i < p.length(); i++) {
            pFreq[p.charAt(i) - 'a']++;
            sFreq[s.charAt(i) - 'a']++;
        }

        // Check first window
        if (Arrays.equals(pFreq, sFreq))
            ans.add(0);

        // Slide the window
        for (int i = p.length(); i < s.length(); i++) {

            // Add new character
            sFreq[s.charAt(i) - 'a']++;

            // Remove old character
            sFreq[s.charAt(i - p.length()) - 'a']--;

            if (Arrays.equals(pFreq, sFreq))
                ans.add(i - p.length() + 1);
        }

        return ans;
    }
}