/*
This is the main file for the program.
The program simulates a single persons account of a ticket booking application.
The program starts up showing the current event with a few details.
When an event is clicked extra data is shown and then the event can be booked
if the user wants.
Once its booked it is added to a table and the user can check the booked events
from the booked tabe in the main GUI.
This runs the program. It first creates the connection to the database
and then makes the EventGui visibile while it is set up in the background.


 */
package eventticketing;

import eventticketing.Models.CharityEvent;
import eventticketing.Models.Event;
import eventticketing.Models.FoodEvent;
import eventticketing.Models.ShowEvent;
import eventticketing.Models.MusicEvent;
import eventticketing.GUI.EventGUI;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Date;

public class EventTicketing {

    /*
    This function takes in data from the events table in the database and
    creates the corresponding objects for them which are then used to create
    the event jtable in the EventGui.
    This arraylist is also used to show the extra details of each event when
    the event is clicked in the Jtable.
     */
    public static ArrayList<Event> createEventsArray(ResultSet rs) {
        DBManager dbManager = DBManager.getInstance();
        ArrayList<Event> eventList = new ArrayList<Event>();
        try {
            while (rs.next()) {
                int id = rs.getInt("ID");
                String type = rs.getString("Type");
                String name = rs.getString("Name");
                Date date = rs.getDate("Date");
                Time time = rs.getTime("Time");
                String location = rs.getString("Location");
                String description = rs.getString("Description");
                Event event = EventFactory.getEvent(type);
                event.addDetails(id, name, date, time, location, description, type);
                switch (type) {
                    case "Music":
                        ResultSet rs1 = dbManager.myQuery("select * from MUSICEVENTS where ID = " + id);
                        rs1.next();
                        String artist = rs1.getString("Artist");
                        String musicgenre = rs1.getString("Genre");
                        ((MusicEvent) event).setArtist(artist);
                        ((MusicEvent) event).setGenre(musicgenre);
                        break;
                    case "Show":
                        ResultSet rs2 = dbManager.myQuery("select * from SHOWEVENTS where ID = " + id);
                        rs2.next();
                        String performer = rs2.getString("Performer");
                        String showgenre = rs2.getString("Genre");
                        ((ShowEvent) event).setPerformer(performer);
                        ((ShowEvent) event).setGenre(showgenre);
                        break;
                    case "Food":
                        ResultSet rs3 = dbManager.myQuery("select * from FOODEVENTS where ID = " + id);
                        rs3.next();
                        String cuisine = rs3.getString("Cuisine");
                        ((FoodEvent) event).setCuisine(cuisine);

                        break;
                    case "Charity":
                        ResultSet rs4 = dbManager.myQuery("select * from CHARITYEVENTS where ID = " + id);
                        rs4.next();
                        String organisation = rs4.getString("Organisation");
                        String cause = rs4.getString("Cause");
                        ((CharityEvent) event).setOrganisation(organisation);
                        ((CharityEvent) event).setCause(cause);
                        break;
                }
                eventList.add(event);
            }
        } catch (SQLException ex) {
            System.out.println("Error Main: " + ex);
            ex.printStackTrace();
        }

        return eventList;
    }

    public static void main(String[] args) {
        DBManager dbManager = DBManager.getInstance();
        ArrayList<Event> eventList = createEventsArray(DBOperations.eventsData());
        EventGUI.setEventList(eventList);
        EventGUI eventGui = EventGUI.getInstance();
        eventGui.setEventsTable();
        eventGui.setVisible(true);

    }

}
