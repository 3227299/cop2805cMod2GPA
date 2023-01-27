// Appointment.Java
// G. Li
// 1/25/23
// testing the appointment.

package edu.fscj.cop2805c.appointment;

import java.time.ZoneId;
import java.time.ZonedDateTime;

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
            this.name.append(lName).append(", ").append(fName);
            this.email = email;
            this.phone = phone;
            this.remindPref = reminderPref;
            this.timeZone = timeZone;
    }

    //override String
    @Override
    public String toString(){
        String s = "Contact: ";
        s += email + "," + "(" + name + ")" + phone + "," + remindPref + "," + timeZone;
        return s;
    }

}

//Appointment class
public class Appointment {

    private Contact contact;
    private String appointTitle;
    private String appointmentDesc;
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

    //override String
    @Override
    public String toString(){
        String s = "Appt: \n";
        s += "\t" + "\t" + "Title: " + appointTitle + "\n" +
        "\t" + "\t" + "Desc: " + appointmentDesc + "\n" +
        "\t" + "\t" + contact + "\n" +
        "\t" + "\t" + "Appt Date/Time: " + appointmentTime + "\n" +
        "\t" + "\t" + "Reminder: " + remiderTime;
        return s;
    }
    public static void main(String[] args) {

        Contact contact1 = new Contact("John", "Smith", "JohnSmith@email.com",
                "904-555-1212", PREFREMINDER.EMAIL, ZoneId.systemDefault());

        Appointment appointment = new Appointment("Test Appointment",
                "This is a test appointment", contact1,ZonedDateTime.now().plusHours(12),
                 ZonedDateTime.now().plusHours(10));

        //System.out.println("Appointment" +);
        System.out.println(appointment.toString());
    }

}

