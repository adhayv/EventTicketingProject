/*
This file takes care of functions that require the database. This being either
getting data or putting data in the database. 
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

    /*
    addToDB takes the event that the user wants to books and inserts it into the
    BookedEvents database. The user is notifed when the event is booked and if
    the event already exists within the database the user is notified that the 
    event has already been booked.
     */
    public static void addToDB(Event event) {
        DBManager dbManager = DBManager.getInstance();
        int id = event.getId();
        String name = event.getName();
        Date date = event.getDate();
        Time time = event.getTime();
        String location = event.getLocation();
        String description = event.getDescription();
        String type = event.getType();
        ResultSet rs = dbManager.myQuery("select * from BOOKEDEVENTS where ID = " + id);

        try {
            if (rs.next()) {
                AlreadyBooked popup = new AlreadyBooked();
                popup.setVisible(true);

            } else {
                dbManager.myUpdate("insert into BOOKEDEVENTS (id, name, date, time, location, description, type) values (" + id + " , '" + name + "' , '"
                        + date + "' , '" + time + "' , '" + location + "' , '" + description + "' , '" + type + "')");
                ThankyouBooking typopup = new ThankyouBooking();
                typopup.setVisible(true);
            }
        } catch (Exception ex) {
            System.out.println("Error: " + ex);
        }

    }

    /*
    bookedEventData function returns the resultset of the BOOKEDEVENTS. This is
    used to set up the booked events jtable.
     */
    public static ResultSet bookedEventsData() {
        DBManager dbManager = DBManager.getInstance();
        ResultSet rs = dbManager.myQuery("select * from BOOKEDEVENTS");
        return rs;

    }
    
    public static ResultSet eventsData(){
        DBManager dbManager = DBManager.getInstance();
        ResultSet rs = dbManager.myQuery("select * from EVENTS");
        return rs;
    }
}
