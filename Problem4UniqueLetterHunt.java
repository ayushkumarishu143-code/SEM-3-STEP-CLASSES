import java.util.Scanner;

public class Problem4UniqueLetterHunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = scanner.nextLine();

        char result = findFirstNonRepeatingChar(text);
        if (result != '\0') {
            System.out.println("First Non-Repeating Character: '" + result + "'");
        } else {
            System.out.println("No Non-Repeating Character Found");
        }

        scanner.close();
    }

    public static char findFirstNonRepeatingChar(String text) {
        if (text == null || text.isEmpty()) return '\0';
        int[] charCount = new int[256];

        for (int i = 0; i < text.length(); i++) {
            charCount[text.charAt(i)]++;
        }

        for (int i = 0; i < text.length(); i++) {
            if (charCount[text.charAt(i)] == 1) {
                return text.charAt(i);
            }
        }
        return '\0';
    }
}