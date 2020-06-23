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

import eventticketing.GUI.DetailEventFrame;
import eventticketing.Models.CharityEvent;
import eventticketing.Models.Event;
import eventticketing.Models.FoodEvent;
import eventticketing.Models.ShowEvent;
import eventticketing.Models.MusicEvent;
import eventticketing.GUI.EventGUI;
import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Date;
import java.util.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class EventTicketing {

    /*
    This function filters the event list once the user has used the search function.
    This is done by comparing the eventlist array with the users search input.
    This uses the enums which are created in the object file.
     */
//    public static ArrayList<Event> filterEvent(Option inputOption, String inputValue, ArrayList<Event> eventList) {
//        ArrayList<Event> filterList = new ArrayList<Event>();
//        for (Event event : eventList) {
//            switch (inputOption) {
//                case NAME:
//                    if (event.name.contains(inputValue)) {
//                        filterList.add(event);
//                    }
//                    break;
//                case DATE:
//                    if (event.date.contains(inputValue)) {
//                        filterList.add(event);
//                    }
//                    break;
//                case TIME:
//                    if (event.time.contains(inputValue)) {
//                        filterList.add(event);
//                    }
//                    break;
//                case TYPE:
//                    if (event.type.equals(inputValue)) {
//                        filterList.add(event);
//                    }
//                    break;
//            }
//
//        }
//        return filterList;
//    }
    
    
    public static void main(String[] args) {

        DBManager dbManager = DBManager.getInstance();
        EventGUI eventGui = new EventGUI();
        eventGui.setVisible(true);
        
        /*
        This function takes in data from the events table in the database and
        creates the corresponding objects for them which are then used to create
        the event jtable in the EventGui.
        This arraylist is also used to show the extra details of each event when
        the event is clicked in the Jtable.
        */
        ArrayList<Event> eventList = new ArrayList<Event>();
        ResultSet rs = dbManager.myQuery("select * from EVENTS");
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
                        
        EventGUI.setEventList(eventList);
        
        DefaultTableModel tableModel = (DefaultTableModel) eventGui.getEventTable().getModel();
        for (Event event : eventList) {
            Object[] row = {event.getId(), event.getName(), event.getDate(), event.getTime(), event.getLocation()};
            tableModel.addRow(row);
            
        }
        
        
        
        
        
        

//        EventGUI.getInstance().getEventListPanel().add(eventtable);
    //JTable table = eventGui.getEventListPanel();
//        /*
//        The while loops keeps the program running until the user wants to end it.
//        The first block of code in the while loop reads the event file and prints
//        them out for the user to see.
//        While catching any exceptions.
//         */
//        boolean running = true;
//        while (running) {
//            ArrayList<Event> filterList = new ArrayList<Event>();
//            ArrayList<Event> eventList = new ArrayList<Event>();
//            String[] eventTypes = new String[]{"Music", "Food & Drink", "Show", "Charity $ Causes"};
//            System.out.println("Events this month in Auckland:");
//            BufferedReader br = null;
//            try {
//                br = new BufferedReader(new FileReader("resources/events.csv"));
//                String line = null;
//                while ((line = br.readLine()) != null) {
//                    String[] str = line.split(",");
//
//                    Event event = new Event(str[0], str[1], str[2], str[3]);
//                    eventList.add(event);
//
//                }
//
//            } catch (FileNotFoundException ex) {
//                System.out.print("File not found.");
//            } catch (IOException ex) {
//                System.out.print("Something has gone wrong.");
//            }
//
//            for (int i = 0; i < eventList.size(); i++) {
//                System.out.println(eventList.get(i));
//            }
//            /*
//            The next part of the code is the search function.
//            Depending on the user input they can search using the options: Name, Date, Time, Type.
//            Depending on what is choosen, the code continues into the switch case.
//            It is then searched against the eventlist using the filterEvent function.
//            If any other input is entered it tells the user and asks them again for 
//            an input.
//            */
//            boolean validInput = false;
//            Scanner userInteraction = new Scanner(System.in);
//            Option inputOption = Option.DATE;
//            String inputValue = "";
//
//            System.out.println("\nWhat option would you like to search by or type \"Exit\" to quit: \n[1]Name \n[2]Date \n[3]Time \n[4]Type\nInput:");
//            String userChoice = userInteraction.nextLine();
//
//            switch (userChoice) {
//                case "1":
//                    inputOption = Option.NAME;
//                    System.out.println("Enter keyword to search by:");
//                    String nameChoice = userInteraction.nextLine();
//                    inputValue = nameChoice;
//
//                    validInput = true;
//                    break;
//
//                case "2":
//                    inputOption = Option.DATE;
//                    System.out.println("Enter date to search by:");
//                    String dateChoice = userInteraction.nextLine();
//                    inputValue = dateChoice;
//
//                    validInput = true;
//                    break;
//
//                case "3":
//                    inputOption = Option.TIME;
//                    System.out.println("Enter time to search by:");
//                    String timeChoice = userInteraction.nextLine();
//                    inputValue = timeChoice;
//
//                    validInput = true;
//                    break;
//                /*
//                The "type" search is a bit different as there is no free input.
//                The user decides which type of event to search by rather that a key.
//                Once entered there is another switch case to sort through the different types.
//                */
//                case "4":
//                    inputOption = Option.TYPE;
//                    System.out.println("Here are the types, pick the corresponding number: \n[1]Music \n[2]Show \n[3]Food&Drink \n[4]Charity&Causes");
//                    String typeChoice = userInteraction.nextLine();
//                    switch (typeChoice) {
//                        case "1":
//                            inputValue = "Music";
//                            validInput = true;
//                            break;
//
//                        case "2":
//                            inputValue = "Show";
//                            validInput = true;
//                            break;
//
//                        case "3":
//                            inputValue = "Food&Drink";
//                            validInput = true;
//                            break;
//
//                        case "4":
//                            inputValue = "Charity&Causes";
//                            validInput = true;
//                            break;
//                    }
//
//                    break;
//
//                case "Exit":
//                    running = false;
//                    break;
//
//                default:
//                    System.out.println("Wrong input, try again.\n");
//                    break;
//
//            }
//            /*
//            Once the search is done and it is valid this block of code runs.
//            The second check is for checking is there is any search results.
//            If there is none the user is told and it asks them to search again.
//            */
//            if (validInput) {
//                filterList = filterEvent(inputOption, inputValue, eventList);
//                if (filterList.size() > 0) {
//                    //The searched list is printed.
//                    System.out.printf("%nEnter corresponding number to filterSearch by type:%n");
//                    for (int i = 0; i < filterList.size(); i++) {
//                        System.out.printf("[%d]" + filterList.get(i) + "%n", i + 1);
//                    }
//                    /*
//                    This block of code asks the user to book the event.
//                    Entering the corresponding number will allow the user 
//                    to choose the event to book.
//                    If the input is valid the event is booked and is created
//                    in a txt file with the important information.
//                    */
//                    boolean validInput3 = false;
//                    int numberVal;
//                    PrintWriter pw = null;
//                    while (!validInput3) {
//                        System.out.println("Enter number:");
//                        userChoice = userInteraction.nextLine();
//                        try {
//                            numberVal = Integer.parseInt(userChoice);
//                            if (1 <= numberVal && numberVal <= filterList.size()) {
//                                Event bookedEvent = filterList.get(numberVal - 1);
//                                System.out.println("Choosen event: " + bookedEvent);
//                                validInput3 = true;
//                                try {
//                                    pw = new PrintWriter(new FileOutputStream("resources/confirmation.txt"));
//                                    pw.println("Event name: " + bookedEvent.name);
//                                    pw.println("Event date: " + bookedEvent.date);
//                                    pw.println("Event time: " + bookedEvent.time);
//                                    pw.println("\nThank you for booking!! :D");
//                                    System.out.println("A confirmation email has been sent to your account.");
//
//                                    pw.close();
//                                } catch (FileNotFoundException e) {
//                                    System.out.println(e.getMessage());
//                                }
//                            } else {
//                                System.out.println("Invalid input, try again.");
//                            }
//                        } catch (NumberFormatException e) {
//                            System.out.println("Invalid input, try again.");
//                        }
//                    }
//                    /*
//                    Once the event is booked the user is asked if they want to 
//                    book another event of close the program.
//                    If they can to stop the program the "running" value is changed 
//                    to false to stop the while loop running.
//                    If not then the program starts again from the beggining.
//                    */
//                    System.out.println("Would you like to book another? Enter anything to continue or \"n\" to quit.");
//                    String continueBooking = userInteraction.nextLine();
//
//                    if (continueBooking.equals("n")) {
//                        running = false;
//
//                    }
//
//                } else {
//                    System.out.println("No search results, try again.\n");
//                }
//            }
//
//        }
}

}
