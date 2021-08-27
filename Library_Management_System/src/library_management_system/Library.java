package library_management_system;

import java.text.ParseException;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Library {

    public String title;
    public String author;
    public String category;
    public String synopsis = "No one has write a synopsis yet.";
    public String status = "available";
    public String overduedate = "-";
    public String takenby;
    public String takenuntil;
    public int days_till_overdue;
    public String reservedby;
    public int numberborrowed;

    public Library(String booktitle, String bookauthor, String bookcategory) {
        title = booktitle;
        author = bookauthor;
        category = bookcategory;
    }

    public String gettitle() {
        return this.title;
    }

    public String getauthor() {
        return this.author;
    }

    public String getcategory() {
        return this.category;
    }

    public void getstatus() {
        System.out.println("Status: " + this.status);
    }

    public String grabstatus() {
        return this.status;
    }

    public void getoverduedate() {
        System.out.println("Overdue by: " + this.overduedate);
    }

    public void getsynopsis() {
        System.out.println("Synopsis: " + this.synopsis);
    }

    public void getdetails() {
        System.out.println("Title: " + gettitle());
        System.out.println("Author: " + getauthor());
        System.out.println("Category: " + getcategory());
        System.out.println("Status: " + status);
    }

    public void settitle(String title) {
        this.title = title;
    }

    public void setauthor(String author) {
        this.author = author;
    }

    public void setcategory(String category) {
        this.category = category;
    }

    public void setstatus(String status) {
        this.status = status;
    }

    public void setoverduedate(String date) {
        this.overduedate = date;
    }

    public void setsynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public void settakenby(String takenby) {
        this.takenby = takenby;
    }

    public String gettakenby() {
        return takenby;
    }

    public void setstudtakenuntil(String date) throws ParseException {
        if (date.equals("-")) {
            days_till_overdue = 0;
        } else {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
            LocalDate a = LocalDate.now();
            String b = date;
            LocalDate c = LocalDate.parse(b, formatter);
            long result = ChronoUnit.DAYS.between(a, c);
            days_till_overdue = (int) result;
            if (days_till_overdue < 30) {
                days_till_overdue = (int) result;
            } else {
                System.out.println("Exceeded 30 days. \n System will shut down.");
                System.exit(0);
            }
        }
    }

    public void setstaftakenuntil(String date) throws ParseException {
        if (date.equals("-")) {
            days_till_overdue = 0;
        } else {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
            LocalDate a = LocalDate.now();
            String b = date;
            LocalDate c = LocalDate.parse(b, formatter);
            long result = ChronoUnit.DAYS.between(a, c);
            days_till_overdue = (int) result;
            if (days_till_overdue < 90) {
                days_till_overdue = (int) result;
            } else {
                System.out.println("Exceeded 90 days. \n System will shut down.");
                System.exit(0);
            }
        }
    }

    public int get_days_till_overdue() {
        return days_till_overdue;
    }

    public void setreservation(String bywho) {
        reservedby = bywho;
    }

    public void setnewnumber() {
        this.numberborrowed++;
    }

    public void getborrownumber() {
        System.out.println("This book has been borrowed for " + this.numberborrowed + " times.");
    }

}
