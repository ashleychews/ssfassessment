package vttp.ssf.assessment.eventmanagement.utility;

import java.time.LocalDate;

public class Utils {
    
    //check age
    public static String checkAge(LocalDate dob) {

        Integer age = LocalDate.now().getYear() - dob.getYear();
        if (age<21) {
            return "You must be older than 21";
        }
        return null;
    }


    //check if sum of tickets exceed
    // public static String checkParticipants() {
    //     int sum=0;
    //     //get the participants and decrease everytime someone register


    // }
}
