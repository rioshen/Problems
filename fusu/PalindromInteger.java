// Finding If N Is Palindrome
// http://www.fusu.us/2013/06/algorithms-review-p1-palindrome.html
// Time Complexity: O(n), where is n is the number of digits in number
// Space: contant time
public class PalindromInteger {
    public static boolean isPalindromeNumber(int number) {
        boolean negative = (number < 0) ? true : false;
        int value = Math.abs(number);
        
        int reversed = 0;
        while (value > 0) {
            reversed = reversed * 10 + value % 10;
            value /= 10;
        }
        
        if (negative) {
            reversed = -reversed;
        }

        return number == reversed;
    }
    
    public static void main(String[] args) {
        PalindromInteger solution = new PalindromInteger();

        System.out.println(solution.isPalindromeNumber(0)); // single number is true
        System.out.println(solution.isPalindromeNumber(121)); // true
        System.out.println(solution.isPalindromeNumber(-121)); // true
        System.out.println(solution.isPalindromeNumber(1781)); // true
    }
}