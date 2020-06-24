/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventticketing;

import eventticketing.Models.Event;
import eventticketing.Models.*;
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
public class EventFactoryTest {

    public EventFactoryTest() {
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
    Test of getEvent method, of class EventFactory.
    This has been tested to check where the factory is recognising what type
    of event to create when the type is passed through.
     */
    @Test
    public void testGetEvent() {
        System.out.println("getEvent");
        String type = "Music";
        Event result = EventFactory.getEvent(type);
        assertTrue(result instanceof MusicEvent);

        String type1 = "Show";
        Event result1 = EventFactory.getEvent(type1);
        assertTrue(result1 instanceof ShowEvent);

        String type2 = "Food";
        Event result2 = EventFactory.getEvent(type2);
        assertTrue(result2 instanceof FoodEvent);

        String type3 = "Charity";
        Event result3 = EventFactory.getEvent(type3);
        assertTrue(result3 instanceof CharityEvent);

    }

}
