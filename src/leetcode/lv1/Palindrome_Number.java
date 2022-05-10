package leetcode.lv1;

class Palindrome_Number {
    public static void main(String[] args) {
        Palindrome_Number pn = new Palindrome_Number();

        boolean palindrome = pn.isPalindrome(121);
        System.out.println("palindrome = " + palindrome);

        boolean palindrome_solution = pn.isPalindrome_solution(121);
        System.out.println("palindrome_solution = " + palindrome_solution);

    }
    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        int l=0;
        int r = s.length()-1;
        while(l<r){
            if (s.charAt(l) != s.charAt(r)) 
                return false;
            l++;
            r--;
        }
        return true;
    }

    /**
     *
     * Time Complexity : O(log10(n))
     * Space Complexity : O(1)
     */

    public boolean isPalindrome_solution(int x){
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int revertedNumber = 0;
        while(x > revertedNumber){
            revertedNumber = revertedNumber*10+x%10;
            x/=10;
        }

        return x == revertedNumber || x == revertedNumber/10;
    }
}