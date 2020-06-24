/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventticketing.Models;

import java.sql.Date;
import java.sql.Time;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Adhay
 */
public class EventTest {

    public EventTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /*
      Test of setLocation method, of class Event.
     This tests the set and get function for location in the general events class.
     */
    @Test
    public void testSetandGetLocation() {
        System.out.println("setLocation");
        String location = "Auckland";
        Event instance = new EventImpl();
        instance.setLocation(location);
        String actual = instance.getLocation();
        String expected = "Auckland";
        assertEquals(expected, actual);
    }

    /* 
    Test of toString method, of class Event.
    This has been tested as it is used to display all the details for each
    different event.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        int id = 1;
        String name = "Test";
        Date date = Date.valueOf("2020-12-31");
        Time time = Time.valueOf("10:10:10");
        String location = "Home";
        String description = "Its fun";
        Event instance = new EventImpl(id, name, date, time, location, description);
        String expResult = "Name: Test" + "\nDate: 2020-12-31" + "\nTime: 10:10:10"
                + "\nLocation: Home" + "\nDescirption: Its fun";
        String result = instance.toString();
        assertEquals(expResult, result);

    }

    /*
      Test of addDetails method, of class Event.
    This is tested to check whether an event can be set, as this is a part of 
    the factory design.
     */
    @Test
    public void testAddDetails() {
        System.out.println("addDetails");
        int id = 1;
        String name = "Test";
        Date date = Date.valueOf("2020-12-31");
        Time time = Time.valueOf("10:10:10");
        String location = "Home";
        String description = "Its fun";
        String type = "Show";
        Event instance = new EventImpl();
        instance.addDetails(id, name, date, time, location, description, type);
        assertEquals(1, instance.getId());
        assertEquals("Test", instance.getName());
        assertEquals(Date.valueOf("2020-12-31"), instance.getDate());
        assertEquals(Time.valueOf("10:10:10"), instance.getTime());
        assertEquals("Home", instance.getLocation());
        assertEquals("Show", instance.getType());
    }

    public class EventImpl extends Event {

        public EventImpl() {

        }

        public EventImpl(int id, String name, Date date, Time time, String location, String description) {
            setId(id);
            setName(name);
            setDate(date);
            setTime(time);
            setLocation(location);
            setDescription(description);

        }
    }

}
