/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventticketing;

/**
 *
 * @author Adhay
 */
public class ShowEvent extends Event {
    String performer;
    String genre;

    public ShowEvent(){
        
    }

    public ShowEvent(String name, String date, String time, String location, String description, String artist, String genre){
        this.name = name;
        this.date = date;
        this.time = time;
        this.location = location;
        this.description = description;
        this.performer = artist;
        this.genre = genre;
    }
    public String toString() {
        return name + ", " + date + ", " + time + performer + ", " + genre + ", ";
    }
    
}
