
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
                    CreateMood(moodsList);
                    break;
                default:
                    throw new AssertionError();
            }
        }

    }

    private static void CreateMood(ArrayList<Mood> moodlist) {

        try {

            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter name: ");
            String name = scanner.nextLine();
            String trimName = name.trim();

            if (!trimName.isEmpty()) {

                System.out.println("\nEnter date (DD/MM/YYY): ");
                String userDate = scanner.nextLine();

                LocalDate date = null;

                if (!userDate.isEmpty()) {
                    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    date = LocalDate.parse(userDate, dateFormatter);
                }

                System.out.println("\nEnter time (HH-mm-ss): ");
                String userTime = scanner.nextLine();

                LocalTime time = null;

                if (!userTime.isEmpty()) {
                    DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH-mm-ss");
                    time = LocalTime.parse(userTime, timeFormatter);
                }

                System.out.println("\nEnter notes:");
                String notes = scanner.nextLine();

                if (userDate.isEmpty() && userTime.isEmpty() && notes.isEmpty()) {

                    Mood mood = new Mood(name);
                    System.out.println("New mood created! " + mood);
                    moodlist.add(mood);

                } else if (userTime.isEmpty() && notes.isEmpty()) {

                    Mood mood = new Mood(name, date);
                    System.out.println("New mood created! " + mood);
                    moodlist.add(mood);
                } else if (notes.isEmpty()) {
                    Mood mood = new Mood(name, date, time);
                    System.out.println("New mood created! " + mood);
                    moodlist.add(mood);
                } else if (userDate.isEmpty() & userTime.isEmpty()) {
                    Mood mood = new Mood(name, notes);
                    System.out.println("New mood created! " + mood);
                    moodlist.add(mood);

                } else {
                    Mood mood = new Mood(name, date, time, notes);
                    System.out.println("New mood created! " + mood);
                    moodlist.add(mood);
                }

            } else {
                System.out.println("Name cannot be empty!");
            }

        } catch (DateTimeException e) {
            System.out.println("Invalid date ot time!");
        }

    }
}
