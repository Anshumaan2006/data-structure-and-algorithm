class Solution {
    public String removeOuterParentheses(String s) {
        String result = "";
        int count = 0;

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if(c == '(') {
                if(count > 0) {
                    result = result + c;
                }
                count++;
            } 
            else {
                count--;
                if(count > 0) {
                    result = result + c;
                }
            }
        }

        return result;
    }
}
