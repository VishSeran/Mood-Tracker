
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class MoodTracker {

    public static void main(String[] args) throws InvalidMoodException {

        ArrayList<Mood> moodsList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        boolean running = true;
        int choice;

        System.out.println("Welcome to the Mood Tracking Application");
        System.out.println("========================================");

        while (running) {

            System.out.println("\npress 1: Add a new Mood");
            System.out.println("press 2: View all Moods");
            System.out.println("press 3: Search Moods");
            System.out.println("press 4: Edit Mood");
            System.out.println("press 5: Delete Mood(s)");
            System.out.println("press 6: Write Moods to a file");
            System.out.println("press 7: Exit\n");

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

    private static void CreateMood (ArrayList<Mood> moodlist) throws InvalidMoodException {

        try {

            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter name: ");
            String name = scanner.nextLine();
            String trimName = name.trim();

            Mood mood;

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

                    mood = new Mood(name);
                    

                } else if (userTime.isEmpty() && notes.isEmpty()) {

                    mood = new Mood(name, date);
                    

                } else if (notes.isEmpty()) {

                    mood = new Mood(name, date, time);
                    

                } else if (userDate.isEmpty() & userTime.isEmpty()) {

                    mood = new Mood(name, notes);
                  

                } else {

                    mood = new Mood(name, date, time, notes);
                    

                }

                boolean isValid = isValidMood(moodlist, mood);

                if (isValid) {
                    moodlist.add(mood);
                    System.out.println("\nNew mood created!\n" + mood);
                    System.out.println("The mood has been added to the tracker\n");

                }

            } else {
                System.out.println("Name cannot be empty!");
            }

        } catch (DateTimeException e) {
            System.out.println("Invalid date ot time!");
        }catch( InvalidMoodException e){
            System.out.println("The mood is not valid");
        }

    }

    private static boolean isValidMood(ArrayList<Mood> moodlist, Mood mood) throws InvalidMoodException {

        for (Mood moodItem : moodlist) {
            if (moodItem.equals(mood)) {
                throw new InvalidMoodException();
            }
        }
        return true;
    }
}
