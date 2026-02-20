
import java.time.LocalDate;
import java.time.LocalTime;

public class Mood {

    private String notes;
    private String name;
    private LocalDate date = LocalDate.now();
    private LocalTime time = LocalTime.MIDNIGHT;

    public Mood(String name) {
        this.name = name;

    }

    public Mood(String name, LocalDate date) {
        this.name = name;
        this.date = date;

    }

    public Mood(String name, LocalDate date, LocalTime time) {
        this.name = name;
        this.date = date;
        this.time = time;
    }

    public Mood(String name, String notes) {
        this.name = name;
        this.notes = notes;

    }

    public Mood(String name, LocalDate date, String notes) {
        this.name = name;
        this.notes = notes;
        this.date = date;

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

    @Override
    public String toString() {
        return "name: " + name + "\nCreated Day: " + date + "\n Created time: "
                + time + "\n Note: " + notes;
    }

    public boolean equals(Mood mood) {

        if (mood.name.equalsIgnoreCase(this.name)
                && mood.notes.equalsIgnoreCase(this.notes)
                && mood.date.isEqual(this.date) && mood.time.equals(this.time)) {
            return true;
        } else {
            return false;
        }

    }

}
