import java.util.Random;
import java.util.Scanner;

public class Problem1CollegeCodingArcade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String[] possibleMoves = {"Rock", "Paper", "Scissors"};

        int wins = 0, losses = 0, draws = 0;
        int totalRounds = 5;

        System.out.println("Round | Player Move | Computer Move | Result");
        System.out.println("--------------------------------------------");

        for (int i = 1; i <= totalRounds; i++) {
            System.out.print("Enter your move (Rock, Paper, or Scissors) for Round " + i + ": ");
            String playerMove = scanner.nextLine().trim();

            String computerMove = possibleMoves[random.nextInt(possibleMoves.length)];
            String result = playRound(playerMove, computerMove);

            if (result.equals("Player Wins")) wins++;
            else if (result.equals("Computer Wins")) losses++;
            else draws++;

            System.out.println("Round " + i + " | " + playerMove + " | " + computerMove + " | " + result);
        }

        double winPercentage = ((double) wins / totalRounds) * 100.0;
        System.out.println("\nFinal Summary (after " + totalRounds + " rounds)");
        System.out.println("Wins: " + wins + " | Losses: " + losses + " | Draws: " + draws + " | Win % = " + winPercentage + "%");
        
        scanner.close();
    }

    public static String playRound(String playerMove, String computerMove) {
        if (playerMove.equalsIgnoreCase(computerMove)) {
            return "Draw";
        }
        if ((playerMove.equalsIgnoreCase("Rock") && computerMove.equalsIgnoreCase("Scissors")) ||
            (playerMove.equalsIgnoreCase("Paper") && computerMove.equalsIgnoreCase("Rock")) ||
            (playerMove.equalsIgnoreCase("Scissors") && computerMove.equalsIgnoreCase("Paper"))) {
            return "Player Wins";
        }
        return "Computer Wins";
    }
}