package vttp.ssf.assessment.eventmanagement.models;

import java.time.LocalDate;
import java.time.Period;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Register {
    
    @NotEmpty(message="Name is required")
    @Size(min=5, max=25, message="Min 5 characters, Max 25 characters")
    private String fullName;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past(message = "Birth date must be a past date less than today")
    private LocalDate dob;

    @NotEmpty(message="Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @Pattern(regexp = "(8|9)[0-9]{7}", message = "invalid phone number entered")
    private String mobileNo;

    private String gender;

    @Min(value=1, message="Minimum 1 ticket")
    @Max(value=3, message="Maximum 3 tickets")
    private int tickets;

    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getTickets() {
        return tickets;
    }

    public void setTickets(int tickets) {
        this.tickets = tickets;
    }


}
