/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventticketing;

import eventticketing.Models.Event;
import eventticketing.GUI.*;
import java.sql.ResultSet;
import java.sql.Time;
import java.sql.Date;

/**
 *
 * @author Adhay
 */
public class DBOperations {

    public static void addToDB(Event event) {
        DBManager dbManager = DBManager.getInstance();
        String name = event.getName();
        Date date = event.getDate();
        Time time = event.getTime();
        String location = event.getLocation();
        String description = event.getDescription();
        String type = event.getType();
        ResultSet rs = dbManager.myQuery("select * from BOOKEDEVENTS where Name = '" + name + "'");
        //try{System.out.println(rs.);} catch(Exception ex){System.out.println(ex);}
        
        try {
            if (rs.next()) {
                AlreadyBooked popup = new AlreadyBooked();
                popup.setVisible(true);
                
            } else {
                dbManager.myUpdate("insert into BOOKEDEVENTS (name, date, time, location, description, type) values ('" + name + "' , '"
                        + date + "' , '" + time + "' , '" + location + "' , '" + description + "' , '" + type + "')");
            }
        } catch (Exception ex) {
            System.out.println("Error: " + ex);
        }

    }
    
//    public void addToBookedJtable(){
//        Resultset rs1
//    }
}
