/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
