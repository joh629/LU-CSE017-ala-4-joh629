import java.util.Scanner;
/**
 * Class containing recursive methods for counting character occurrences and generating permutations.
 */
class Recursion {
    /**
     * Counts occurrences of character c in string str using recursion.
     * @param str the string to search
     * @param c the character to count
     * @return the number of occurrences of c in str
     */
    public static int count(String str, char c) {
        //base case there is no char in the string
        if (str.indexOf(c) == -1) {
            return 0;
        } 
        //recursive case there is a char c in the string at an index
        else {
            return 1 + count(str.substring(str.indexOf(c) + 1), c);
        }
    }

    /**
     * Generates and prints all permutations of the input string s.
     * calls the helper method with initial parameters.
     */
    public static void permutations(String s) {
        permutations("", s);
    }
    /**
     * Helper method to generate permutations using recursion.
     * @param s1 the current permutation being built
     * @param s2 the remaining characters to use
     */
    public static void permutations(String s1, String s2) {
        if (s2.length() == 0) {
            System.out.println(s1);
        }
        else {
            for (int i = 0; i < s2.length(); i++) {
                char temp = s2.charAt(i);
                permutations(s1+temp, s2.substring(0, i)+s2.substring(i+1));
            }
        }
    }


    /**
     * Main method to test the recursive methods.
     */
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String str = keyboard.nextLine();
        System.out.println("Enter a char: ");
        char c = keyboard.nextLine().charAt(0);
        System.out.println(c+" appears "+count(str, c)+" times in \""+str+"\"");

        System.out.println("Enter a string: ");
        str = keyboard.nextLine();
        permutations(str);
    }
}