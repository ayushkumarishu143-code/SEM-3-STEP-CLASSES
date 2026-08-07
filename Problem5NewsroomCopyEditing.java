import java.util.Scanner;

public class Problem5NewsroomCopyEditing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = scanner.nextLine();

        String[] result = findShortestAndLongestWord(text);
        if (result[0].isEmpty() && result[1].isEmpty()) {
            System.out.println("No valid words found.");
        } else {
            System.out.println("Shortest: \"" + result[0] + "\" (" + result[0].length() + ") | Longest: \"" + result[1] + "\" (" + result[1].length() + ")");
        }

        scanner.close();
    }

    public static String[] findShortestAndLongestWord(String text) {
        if (text == null || text.trim().isEmpty()) {
            return new String[]{"", ""};
        }
        String[] words = text.replaceAll("[^a-zA-Z ]", "").split("\\s+");
        if (words.length == 0 || words[0].isEmpty()) {
            return new String[]{"", ""};
        }
        
        String shortest = words[0];
        String longest = words[0];

        for (String word : words) {
            if (!word.isEmpty()) {
                if (word.length() < shortest.length()) {
                    shortest = word;
                }
                if (word.length() > longest.length()) {
                    longest = word;
                }
            }
        }
        return new String[]{shortest, longest};
    }
}