
import java.time.LocalDate;
import java.time.LocalTime;

public class Mood {

    private String notes;
    private String name;
    private LocalDate date;
    private LocalTime time;

    public Mood(String name) {
        this.name = name;
        date = LocalDate.now();
        time = LocalTime.MIDNIGHT;
    }

    public Mood(String name, LocalDate date) {
        this.name = name;
        this.date = date;
        time = LocalTime.MIDNIGHT;
    }

    public Mood(String name, LocalDate date, LocalTime time) {
        this.name = name;
        this.date = date;
        this.time = time;
    }

    public Mood(String name, String notes) {
        this.name = name;
        this.notes = notes;
        date = LocalDate.now();
        time = LocalTime.MIDNIGHT;
    }

    public Mood(String name, LocalDate date, String notes) {
        this.name = name;
        this.notes = notes;
        this.date = date;
        time = LocalTime.MIDNIGHT;
    }

    public Mood(String name, LocalDate date, LocalTime time, String notes) {
        this.name = name;
        this.date = date;
        this.time = time;
        this.notes = notes;
    }

}
