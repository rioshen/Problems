public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) return true;
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (!isValid(s, left)) {
                left++;
            } else if(!isValid(s, right)) {
                right--;
            } else if (!isSame(s, left, right)) {
                return false;
            } else {
                left++;
                right--;
            }
        }
        return true;
    }
    
    private boolean isValid(String s, int pos) {
        // bug 1: number is also valid
        //return s.charAt(pos) >= 'A' && s.charAt(pos) <= 'z';
        return Character.isDigit(s.charAt(pos)) || Character.isLetter(s.charAt(pos));
    }
    
    private boolean isSame(String s, int i, int j) {
        return Character.toLowerCase(s.charAt(i)) == Character.toLowerCase(s.charAt(j));
    }
}