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
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Adhay
 */
public class DBOperations {

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
        //try{System.out.println(rs.);} catch(Exception ex){System.out.println(ex);}

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

    public static ResultSet bookedEventsData() {
        DBManager dbManager = DBManager.getInstance();
        ResultSet rs = dbManager.myQuery("select * from BOOKEDEVENTS");
        return rs;
//        DefaultTableModel tableModel = (DefaultTableModel) eventGUI.getEventTable().getModel();
//        try {
//            while (rs.next()){
//                int id = rs.getInt("ID");
//                String type = rs.getString("Type");
//                String name = rs.getString("Name");
//                Date date = rs.getDate("Date");
//                Time time = rs.getTime("Time");
//                String location = rs.getString("Location");
//                String description = rs.getString("Description");
//                
//            }
//
//        } catch (SQLException ex) {
//            System.out.println("Error Main: " + ex);
//            ex.printStackTrace();
//
//        }
    }
}
