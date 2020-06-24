/*
ShowEvent is a sublcass of the abstract Event class.
This is created as a Show Event which falls under Event.
 */
package eventticketing.Models;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author Adhay
 */
public class ShowEvent extends Event {
    String performer;
    String genre;

    public ShowEvent(){
        
    }

    public String getPerformer() {
        return performer;
    }

    public String getGenre() {
        return genre;
    }

    public void setPerformer(String performer) {
        this.performer = performer;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
    
    

    public ShowEvent(int id, String name, Date date, Time time, String location, String description, String type, String performer, String genre){
        super.setId(id);
        super.setName(name);
        super.setDate(date);
        super.setTime(time);
        super.setLocation(location);
        super.setDescription(description);
        super.setType(type);
        this.performer = performer;
        this.genre = genre;
    }
    
    public ShowEvent(String name, Date date, Time time, String location, String description){
        super.setName(name);
        super.setDate(date);
        super.setTime(time);
        super.setLocation(location);
        super.setDescription(description);
    }
    public String toString() {
        String details = (performer + "\nGenre: " + genre);
        return super.toString() + details;
    }
    
}
