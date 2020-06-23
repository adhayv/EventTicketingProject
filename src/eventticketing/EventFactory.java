/*
EventFactory implments the factory design for creating the Event objects.
This is used to know what type of event should be created.
 */
package eventticketing;

import eventticketing.Models.*;

/**
 *
 * @author Adhay
 */
public class EventFactory {
    
    public static Event getEvent(String type){
        if(type.equalsIgnoreCase("Music")){
            return new MusicEvent();
        }
        
        else if(type.equalsIgnoreCase("Food")){
            return new FoodEvent();
        }
        
        else if(type.equalsIgnoreCase("Show")){
            return new ShowEvent();
        }
        
        else if(type.equalsIgnoreCase("Charity")){
            return new CharityEvent();
        }
        
        return null;
    }
}
