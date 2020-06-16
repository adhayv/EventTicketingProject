/*
This is the main file for the program.
This program shows the current events around Auckland and prints them out from a csv file.
Then the user can pick a way to search for an event from the list using different options.
Once searched the user can book an event, this creates a txt file which is the booking confirmation.

 */
package eventticketing;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

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

        EventGUI.runGUI();
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
//                    System.out.printf("%nEnter corresponding number to filter by type:%n");
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
