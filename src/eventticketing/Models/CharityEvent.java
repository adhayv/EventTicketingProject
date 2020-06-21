/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventticketing.Models;

import eventticketing.Models.Event;
import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author Adhay
 */
public class CharityEvent extends Event {

    String organisation;
    String cause;

    public void setOrganisation(String organisation) {
        this.organisation = organisation;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public String getOrganisation() {
        return organisation;
    }

    public String getCause() {
        return cause;
    }

    public CharityEvent() {

    }

    public CharityEvent(String name, Date date, Time time, String location, String description, String organisation, String cause) {
        super.setName(name);
        super.setDate(date);
        super.setTime(time);
        super.setLocation(location);
        super.setDescription(description);
        this.organisation = organisation;
        this.cause = cause;
    }

    public CharityEvent(String name, Date date, Time time, String location, String description) {
        super.setName(name);
        super.setDate(date);
        super.setTime(time);
        super.setLocation(location);
        super.setDescription(description);
    }

    public String toString() {
        String details = ("Name: " + getName() + "\nDate: " + getDate() + "\nTime: " + getTime()
                + "\nLocation: " + getLocation() + "\nOrganisation: " + organisation + "\nCause: " + cause + "\nDescirption: " + getDescription());
        return details;
    }
}
