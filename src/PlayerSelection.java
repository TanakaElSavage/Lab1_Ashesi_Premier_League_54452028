import java.util.Scanner;

public class PlayerSelection {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("---ASHESI PREMIER LEAGUE - PLAYER SELECTION SIMULATOR ---");
        System.out.println();

        // Read player details from keyboard
        System.out.print("Enter player's name: ");
        String name = scanner.nextLine();

        System.out.print("Enter player's age: ");
        int age = scanner.nextInt();

        System.out.print("Enter player's height in meters: ");
        double height = scanner.nextDouble();

        System.out.print("Enter player's weight in pounds: ");
        double weight = scanner.nextDouble();

        System.out.print("Enter player's jersey number: ");
        int jerseyNumber = scanner.nextInt();

        // Task 2: Data conversion
        final double POUND = 0.45359237;
        final int METER = 100;
        double heightCm = height * METER;
        double weightKgs = weight * POUND;
        int roundedWeight = (int) weightKgs; // Casting to int

        // Task 5: Player category
        String category;
        if (age < 20) {
            category = "Rising Star";
        } else if (age <= 30) {
            category = "Prime Player";
        } else {
            category = "Veteran";
        }

        // Task 6: Player position based on jersey number
        String position;
        switch (jerseyNumber) {
            case 1:
                position = "Goalkeeper";
                break;
            case 2:
            case 3:
            case 4:
            case 5:
                position = "Defender";
                break;
            case 6:
            case 8:
                position = "Midfielder";
                break;
            case 7:
            case 11:
                position = "Winger";
                break;
            case 9:
                position = "Striker";
                break;
            case 10:
                position = "Playmaker";
                break;
            default:
                position = "Unknown Position";
        }

        // Attacker jersey check (jersey numbers 7, 9, 10, 11 are attackers)
        boolean isAttackerJersey = (jerseyNumber == 7 || jerseyNumber == 9 ||
                jerseyNumber == 10 || jerseyNumber == 11);
        String attackerStatus = isAttackerJersey ? "Yes" : "No";

        // Task 4: Eligibility check
        boolean isEligible = (age >= 18 && age <= 35 && roundedWeight < 90);
        String eligibilityStatus = isEligible ? "Eligible" : "Not Eligible";

        //Task 8: Lineup decision
        String lineupDecision;
        if (category.equals("Prime Player")) {
            if (roundedWeight < 80) {
                lineupDecision = "Starting Lineup";
            } else {
                lineupDecision = "Bench (weight ≥ 80kg)";
            }
        } else {
            lineupDecision = "Bench (not Prime Player)";
        }

        // Task 9 Final decision using ternary operator
        String finalDecision = isEligible ? "Play" : "Rest";

        // Print Player Report
        System.out.println();
        System.out.println("--- PLAYER REPORT ---");
        System.out.println("Player: " + name);
        System.out.println("Age: " + age + " (" + category + ")");
        System.out.println("Height: " + heightCm + "cm");
        System.out.println("Weight: " + roundedWeight + "kg");
        System.out.println("Jersey: " + jerseyNumber);
        System.out.println("Position: " + position);
        System.out.println("Attacker jersey: " + attackerStatus);
        System.out.println("Eligibility: " + eligibilityStatus);
        System.out.println("Lineup Decision: " + lineupDecision);
        System.out.println("Final Decision: " + finalDecision);

        // Demonstrate unwanted fall-through (Task 7 - Part A)
        System.out.println();
        System.out.println("--- FALL-THROUGH DEMONSTRATION ---");
        System.out.println("Testing jersey number " + jerseyNumber + " with missing breaks:");

        switch (jerseyNumber) {
            case 1:
                System.out.println("Goalkeeper");
                break;
            case 2:
                System.out.println("Defender RB");
            case 6:
                System.out.println("Midfielder CDM");
            case 7:
                System.out.println("Winger RW");
                break;
            case 9:
                System.out.println("Striker");
                break;
            default:
                System.out.println("Position not in demo cases");
        }

        System.out.println("Note how multiple lines print when breaks are missing!");

        scanner.close();
    }
}