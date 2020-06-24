/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventticketing.Models;

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
public class MusicEventTest {

    public MusicEventTest() {
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
    Test of setArtist method, of class MusicEvent.
    This tests to see if the set and get method work for the specific details
    within the Music object.
     */
    @Test
    public void testSetandGetArtist() {
        System.out.println("setArtist");
        String artist = "LakeyInspired";
        MusicEvent instance = new MusicEvent();
        instance.setArtist(artist);
        String actual = instance.getArtist();
        String expected = "LakeyInspired";
        assertEquals(expected, actual);
    }
}
