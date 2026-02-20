
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

    public String getName() {
        return name;
    }

    public String getNotes() {
        return notes;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("Name setted successfully " + this.name);
    }

    public void setNotes(String notes) {
        this.notes = notes;
        System.out.println("Name setted successfully " + this.notes);
    }

    public void setDate(LocalDate date) {
        this.date = date;
        System.out.println("Date setted successfully " + this.date);
    }

    public void setTime(LocalTime time) {
        this.time = time;
        System.out.println("Time setted successfully " + this.time);
    }

}
