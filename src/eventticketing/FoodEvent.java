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
enum Setting{
        FORMAL,
        CASUAL
    }

public class FoodEvent extends Event {
    String cuisine;
    Setting getup;
    
    public FoodEvent(){
        
    }

    public FoodEvent(String name, String date, String time, String location, String description, String cuisine, Setting getup){
        this.name = name;
        this.date = date;
        this.time = time;
        this.location = location;
        this.description = description;
        this.getup = getup;
        this.cuisine = cuisine;
    }
    public String toString() {
        return name + ", " + date + ", " + time + ", " + getup + ", " + cuisine + ", ";
    }
}
