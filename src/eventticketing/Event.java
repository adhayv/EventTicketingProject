//This file creates the Event object.
package eventticketing;

//This makes enums for a function in the EventTicketing file as there is a function which requires it.
enum Option {
    NAME,
    DATE,
    TIME,
    TYPE
}

public abstract class Event {

    String name;
    String date;
    String time;
    String location;
    String description;
    
    
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
