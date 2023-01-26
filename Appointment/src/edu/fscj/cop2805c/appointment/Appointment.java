// Appointment.Java
// G. Li
// 1/25/23
// testing the appointment.

package edu.fscj.cop2805c.appointment;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TimeZone;

enum PREFREMINDER {NONE, TEXT, EMAIL}

//Contact class
class Contact{

    private StringBuilder name;
    private String email;
    private String phone;
    private PREFREMINDER remindPref;
    private ZoneId timeZone;

    //Contact constructor
    public Contact(String fName, String lName,String email, String phone,
                       PREFREMINDER reminderPref,ZoneId timeZone){
            this.name = new StringBuilder();
            this.name.append(fName).append(" ").append(lName);
            this.email = email;
            this.phone = phone;
            this.remindPref = reminderPref;
            this.timeZone = timeZone;
    }



    @Override
    public String toString(){
        String s = "Contact: ";
        s += email + "," + "(" + name + ")" + phone + "," + remindPref + "," + timeZone;
        return s;
    }

}

public class Appointment {

    private Contact contact;
    private String appointTitle;
    private String appointmentDesc = "This is a test appointment";
    private ZonedDateTime appointmentTime;
    private ZonedDateTime remiderTime;

//Appointment Constructor
    public Appointment(String appointTitle, String appointmentDesc,Contact contact,
                       ZonedDateTime appointmentTime, ZonedDateTime remiderTime){
        this.appointmentTime = appointmentTime;
        this.appointmentDesc = appointmentDesc;
        this.contact = contact;
        this.appointTitle = appointTitle;
        this.remiderTime = remiderTime;
    }

    @Override
    public String toString(){
        String s = "Title: ";
        s += appointTitle + "\n" +
        "Desc: " + appointmentDesc + "\n" +
        contact + "\n" +
        "Appt Date/Time: " + appointmentTime + "\n" +
        "Reminder: " + remiderTime;
        return s;
    }
    public static void main(String[] args) {

        Contact contact1 = new Contact("John", "Smith", "JohnSmith@email.com",
                "904-555-1212", PREFREMINDER.EMAIL, ZoneId.systemDefault());

        Appointment appointment = new Appointment("Test Appointment",
                "This is a test appointment", contact1,ZonedDateTime.now().plusHours(12),
                 ZonedDateTime.now().plusHours(10));

        //System.out.println("Title" +);
        System.out.println(appointment.toString());
    }

}

