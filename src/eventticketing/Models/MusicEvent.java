/*
MusicEvent is a sublcass of the abstract Event class.
 */
package eventticketing.Models;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author Adhay
 */
public class MusicEvent extends Event {

    String artist;
    String genre;

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getArtist() {
        return artist;
    }

    public String getGenre() {
        return genre;
    }

    public MusicEvent() {

    }

    public MusicEvent(int id, String name, Date date, Time time, String location, String description, String type, String artist, String genre) {
        super.setId(id);
        super.setName(name);
        super.setDate(date);
        super.setTime(time);
        super.setLocation(location);
        super.setDescription(description);
        super.setType(type);
        this.artist = artist;
        this.genre = genre;
    }

    public MusicEvent(String name, Date date, Time time, String location, String description) {
        super.setName(name);
        super.setDate(date);
        super.setTime(time);
        super.setLocation(location);
        super.setDescription(description);
    }

    public String toString() {
        String details = ("Name: " + getName() + "\nDate: " + getDate() + "\nTime: " + getTime()
                + "\nLocation: " + getLocation() + "\nArtist: " + artist + "\nGenre: " + genre + "\nDescirption: " + getDescription());
        return details;
    }
}
