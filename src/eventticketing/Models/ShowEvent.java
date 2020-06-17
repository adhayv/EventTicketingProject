/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
    
    

    public ShowEvent(String name, Date date, Time time, String location, String description, String artist, String genre){
        super.setName(name);
        super.setDate(date);
        super.setTime(time);
        super.setLocation(location);
        super.setDescription(description);
        this.performer = artist;
        this.genre = genre;
    }
    
    public ShowEvent(String name, Date date, Time time, String location, String description){
        super.setName(name);
        super.setDate(date);
        super.setTime(time);
        super.setLocation(location);
        super.setDescription(description);
    }
//    public String toString() {
//        return name + ", " + date + ", " + time + performer + ", " + genre + ", ";
//    }
    
}
