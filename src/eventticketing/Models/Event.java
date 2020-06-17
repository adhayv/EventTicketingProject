//This file creates the Event object.
package eventticketing.Models;

//This makes enums for a function in the EventTicketing file as there is a function which requires it.

import java.sql.Date;
import java.sql.Time;

enum Option {
    NAME,
    DATE,
    TIME,
    TYPE
}

public abstract class Event {

    private String name;
    private Date date;
    private Time time;
    private String location;
    private String description;

    public String getName() {
        return name;
    }

    public Date getDate() {
        return date;
    }

    public Time getTime() {
        return time;
    }

    public String getLocation() {
        return location;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
   
    
//Default constructor   
    /*public Event() {
    }*/

//Constructor with parameters
/*    public Event(String name, String date, String time, String type) {
        this.name = name;
       this.date = date;
       this.time = time;
       this.type = type;
    }*/
//This function overwrites the toString() function specifically for the Event object which needs to be printed out.
    public String toString() {
        return name + ", " + date + ", " + time + "";
    }

}
