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
public class MusicEvent extends Event{
    String artist;
    String genre;

    public MusicEvent(){
        
    }

    public MusicEvent(String name, String date, String time, String location, String description, String artist, String genre){
        this.name = name;
        this.date = date;
        this.time = time;
        this.location = location;
        this.description = description;
        this.artist = artist;
        this.genre = genre;
    }
    public String toString() {
        return name + ", " + date + ", " + time + ", " + artist + ", " + genre + ", ";
    }
}
