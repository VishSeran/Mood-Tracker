
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class MoodTracker {

    public static void main(String[] args) {

        ArrayList<Mood> moodsList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        boolean running = true;
        int choice;

        System.out.println("Welcome to the Mood Tracking Application");
        System.out.println("========================================");

        while (running) {

            System.out.println("\n press 1: Add a new Mood");
            System.out.println("\n press 2: View all Moods");
            System.out.println("\n press 3: Search Moods");
            System.out.println("\n press 4: Edit Mood");
            System.out.println("\n press 5: Delete Mood(s)");
            System.out.println("\n press 6: Write Moods to a file");
            System.out.println("\n press 7: Exit");

            choice = Integer.parseInt(scanner.nextLine());

            if (choice == 7) {
                running = false;
                System.out.println("System shutting down");
                return;
            }

            switch (choice) {
                case 1:
                    Mood newMood = CreateMood();
                    moodsList.add(newMood);
                    break;
                default:
                    throw new AssertionError();
            }
        }

    }

    private static Mood CreateMood() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name: ");
        String name = scanner.nextLine();

        if (name.trim().isEmpty()) {
            System.out.println("Name cannot be empty!");
            scanner.close();
            return null;
        }

        System.out.println("\nEnter date (DD/MM/YYY) or Enter to skip: ");
        String userDate = scanner.nextLine();
        LocalDate date = null;

        System.out.println("\nEnter time (HH-mm-ss) or Enter to skip: ");
        String userTime = scanner.nextLine();
        LocalTime time = null;

        System.out.println("\nEnter notes or Enter to skip:");
        String notes = scanner.nextLine();

        try {
            if (!userDate.isEmpty()) {
                DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("DD/MM/YYYY");
                date = LocalDate.parse(userDate, dateFormatter);
            }

            if (!userTime.isEmpty()) {
                DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH-mm-ss");
                time = LocalTime.parse(userTime, timeFormatter);
            }

        } catch (DateTimeException e) {
            System.out.println("Invalid date or time");
        }

        scanner.close();
        Mood mood = new Mood(name, date, time, notes);
        System.out.println("New mood created! " + mood);

        return mood;

    }
}
