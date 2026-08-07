
import java.util.Scanner;

public class Problem2QATextVerificationToolkit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text to check palindrome: ");
        String text = scanner.nextLine();

        boolean iterative = isPalindromeIterative(text);
        boolean recursive = isPalindromeRecursive(text);
        boolean arrayRev = isPalindromeArrayReversal(text);

        System.out.println("\"" + text + "\"");
        System.out.println(" | Iterative: " + (iterative ? "Palindrome" : "Not Palindrome") +
                           " | Recursive: " + (recursive ? "Palindrome" : "Not Palindrome") +
                           " | Array Reversal: " + (arrayRev ? "Palindrome" : "Not Palindrome"));

        scanner.close();
    }

    public static boolean isPalindromeIterative(String text) {
        if (text == null) return false;
        String clean = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int left = 0, right = clean.length() - 1;
        while (left < right) {
            if (clean.charAt(left) != clean.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static boolean isPalindromeRecursive(String text) {
        if (text == null) return false;
        String clean = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        return recursiveHelper(clean, 0, clean.length() - 1);
    }

    private static boolean recursiveHelper(String s, int left, int right) {
        if (left >= right) return true;
        if (s.charAt(left) != s.charAt(right)) return false;
        return recursiveHelper(s, left + 1, right - 1);
    }

    public static boolean isPalindromeArrayReversal(String text) {
        if (text == null) return false;
        String clean = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        char[] charArray = clean.toCharArray();
        String reversed = "";
        for (int i = charArray.length - 1; i >= 0; i--) {
            reversed += charArray[i];
        }
        return clean.equals(reversed);
    }
}