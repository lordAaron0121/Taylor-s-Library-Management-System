package library_management_system;

import java.util.ArrayList;

public class User {

    String username;
    String usertype;
    String userpassword;
    int charged_amount;
    ArrayList<String> borrowed = new ArrayList<>();
    ArrayList<String> borrowing = new ArrayList<>();
    int studentbookcountlimit = 5;
    int staffbookcountlimit = 10;

    public User(String name, String type, String password) {
        setusername(name);
        setusertype(type);
        setuserpassword(password);
    }

    public void setusername(String name) {
        username = name;
    }

    public void setusertype(String type) {
        usertype = type;
    }

    public void setuserpassword(String password) {
        userpassword = password;
    }

    public String getusername() {
        return this.username;
    }

    public String getusertype() {
        return this.usertype;
    }

    public String getuserpassword() {
        return this.userpassword;
    }

    public void getuserdetails() {
        System.out.println("Username: " + getusername());
        System.out.println("User type: " + getusertype());
        System.out.println("Password: " + getuserpassword());
        System.out.println("Book(s) borrowed: " + borrowed);
        System.out.println("Total charges: " + charged_amount);
    }

    public void addcharges(int amount) {
        this.charged_amount += amount;
    }

    public void getcharges() {
        System.out.println("This person has been charged RM" + charged_amount + " till date.");
    }

    public int grabcharges() {
        return charged_amount;
    }

    public void addbook(String book) {
        borrowed.add(book);
    }

    public void gethistory() {
        System.out.println("Book(s) borrowed: " + borrowed);
    }

    public ArrayList grabhistory() {
        return borrowed;
    }

    public void setborrowing(String bookname) {
        borrowing.add(bookname);
    }

    public void dropborrowing(String bookname) {
        borrowing.remove(bookname);
    }

    public ArrayList getborrowing() {
        return borrowing;
    }

    public void getcurrentbookborrowed() {
        System.out.println("Borrowing: " + borrowing);
    }

    public int getstudlimit() {
        return studentbookcountlimit;
    }

    public int getstafflimit() {
        return staffbookcountlimit;
    }

    public void setstudentlimit(int a) {
        if (a == 1) {
            studentbookcountlimit--;
        } else {
            studentbookcountlimit++;
        }
    }

    public void setstafflimit(int a) {
        if (a == 1) {
            staffbookcountlimit--;
        } else {
            staffbookcountlimit++;
        }
    }

}
