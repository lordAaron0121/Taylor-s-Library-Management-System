package library_management_system;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Library_Management_System {

    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);
        int totalchargesgiven = 0;

        Library book1 = new Library("Naruto", "Masashi Kishimoto", "Manga");
        Library book2 = new Library("Lord of the Rings", "J. R. R. Tolkien", "Heroic romance");
        Library book3 = new Library("Attack on Titan", "Hajime Isayama", "Manga");

        User Ahmad = new User("Ahmad", "student", "Apple");
        User Damian = new User("Damian", "staff", "Durian");
        User Fatimah = new User("Fatimah", "librarian", "Blueberry");

        String answer;

        do {
            System.out.println("Which account do you want to log in?");
            String user = sc.nextLine();
            System.out.println("What's the type of your account?");
            String acctype = sc.nextLine();
            System.out.println("Key in password.");
            String pass = sc.nextLine();
            System.out.println("Which book do you want to interact with?");
            String book = sc.nextLine();
            System.out.println("Which person do you want to interact with?");
            String person = sc.nextLine();

            Boolean Ahmad_logged_in = user.equals("Ahmad") && pass.equals("Apple") && acctype.equals("student");
            Boolean Damian_logged_in = user.equals("Damian") && pass.equals("Durian") && acctype.equals("staff");
            Boolean Fatimah_logged_in = user.equals("Fatimah") && pass.equals("Blueberry") && acctype.equals("librarian");

            Boolean is_librarian = user.equals("Fatimah") && acctype.equals("librarian");
            Boolean is_member = (user.equals("Ahmad") && acctype.equals("student")) || (user.equals("Damian") && acctype.equals("staff"));

            Boolean is_book1 = book.equals("Naruto") || book.equals("Masashi Kishimoto");
            Boolean is_book2 = book.equals("Lord of the Rings") || book.equals("J. R. R. Tolkien");
            Boolean is_book3 = book.equals("Attack on Titan") || book.equals("Hajime Isayama");

            Boolean is_Ahmad = person.equals("Ahmad");
            Boolean is_Damian = person.equals("Damian");

            do {
                if (Fatimah_logged_in || Ahmad_logged_in || Damian_logged_in) {

                    System.out.println("How can we help you?");
                    System.out.println("1. View book's author, title, and category");
                    System.out.println("2. View book status");
                    System.out.println("3. View book synopsis");

                    if (is_librarian) {
                        System.out.println("4. View member’s details.");
                        System.out.println("5. Check the person's charged amount.");
                        System.out.println("6. Collect overdue charges.");
                        System.out.println("7. View total overdue charges received.");
                        System.out.println("8. Take the book back due to overdue.");
                        System.out.println("9. Write synopsis for the book.");
                        System.out.println("10. Change member's username.");
                        System.out.println("11. Change member's password.");
                        System.out.println("12. View that member's currently borrowed book.");
                        System.out.println("13. View that member's borrow history.");
                        System.out.println("14. Check how many times has the book been borrrowed.");
                        System.out.println("15. View total for each book status.");
                        System.out.println("16. Exit program.");

                        String Z = sc.nextLine();
                        switch (Z) {
                            case "1" -> {
                                if (is_book1) {
                                    book1.getdetails();
                                } else if (is_book2) {
                                    book2.getdetails();
                                } else if (is_book3) {
                                    book3.getdetails();
                                }
                                break;
                            }

                            case "2" -> {
                                if (is_book1) {
                                    book1.getstatus();
                                } else if (is_book2) {
                                    book2.getstatus();
                                } else if (is_book3) {
                                    book3.getstatus();
                                }
                                break;
                            }

                            case "3" -> {
                                if (is_book1) {
                                    book1.getsynopsis();
                                } else if (is_book2) {
                                    book2.getsynopsis();
                                } else if (is_book3) {
                                    book3.getsynopsis();
                                }
                                break;
                            }

                            case "4" -> {
                                if (is_Ahmad) {
                                    Ahmad.getuserdetails();
                                } else if (is_Damian) {
                                    Damian.getuserdetails();
                                }
                                break;
                            }

                            case "5" -> {
                                if (is_Ahmad) {
                                    Ahmad.getcharges();
                                } else if (is_Damian) {
                                    Damian.getcharges();
                                }
                                break;
                            }

                            case "6" -> {
                                System.out.println("How much are you collecting?");
                                int money = sc.nextInt();
                                totalchargesgiven += money;
                                if (is_Ahmad) {
                                    Ahmad.addcharges(money);
                                } else if (is_Damian) {
                                    Damian.addcharges(money);
                                }
                                System.out.println("You charged this person RM" + money + ".");
                                break;
                            }

                            case "7" -> {
                                System.out.println("Total overdue charges received is RM" + totalchargesgiven + ".");
                                break;
                            }

                            case "8" -> {
                                if (is_book1) {
                                    if (is_Ahmad) {
                                        Ahmad.dropborrowing(book1.gettitle());
                                        book1.setstudtakenuntil("-");
                                    } else {
                                        Damian.dropborrowing(book1.gettitle());
                                        book1.setstaftakenuntil("-");
                                    }
                                    book1.settakenby("none");
                                    book1.setstatus("available");
                                    book1.setoverduedate("-");

                                } else if (is_book2) {
                                    if (is_Ahmad) {
                                        Ahmad.dropborrowing(book2.gettitle());
                                        book2.setstudtakenuntil("-");
                                    } else {
                                        Damian.dropborrowing(book2.gettitle());
                                        book2.setstaftakenuntil("-");
                                    }
                                    book2.settakenby("none");
                                    book2.setstatus("available");
                                    book2.setoverduedate("-");
                                } else if (is_book3) {
                                    if (is_Ahmad) {
                                        Ahmad.dropborrowing(book3.gettitle());
                                        book3.setstudtakenuntil("-");
                                    } else {
                                        Damian.dropborrowing(book3.gettitle());
                                        book3.setstaftakenuntil("-");
                                    }
                                    book3.settakenby("none");
                                    book3.setstatus("available");
                                    book3.setoverduedate("-");
                                }
                                break;
                            }

                            case "9" -> {
                                if (is_book1) {
                                    book1.setsynopsis(sc.nextLine());
                                } else if (is_book2) {
                                    book2.setsynopsis(sc.nextLine());
                                } else if (is_book3) {
                                    book3.setsynopsis(sc.nextLine());
                                }
                                break;
                            }

                            case "10" -> {
                                System.out.println("What's the new username?");
                                if (is_Ahmad) {
                                    Ahmad.setusername(sc.nextLine());
                                } else if (is_Damian) {
                                    Damian.setusername(sc.nextLine());
                                }
                                break;
                            }

                            case "11" -> {
                                if (is_Ahmad) {
                                    Ahmad.setuserpassword(sc.nextLine());
                                } else if (is_Damian) {
                                    Damian.setuserpassword(sc.nextLine());
                                }
                                break;
                            }

                            case "12" -> {
                                if (is_Ahmad) {
                                    Ahmad.getcurrentbookborrowed();
                                } else if (is_Damian) {
                                    Damian.getcurrentbookborrowed();
                                }
                                break;
                            }

                            case "13" -> {
                                if (is_Ahmad) {
                                    Ahmad.gethistory();
                                } else if (is_Damian) {
                                    Damian.gethistory();
                                }
                                break;
                            }

                            case "14" -> {
                                if (is_book1) {
                                    book1.getborrownumber();
                                } else if (is_book2) {
                                    book2.getborrownumber();
                                } else if (is_book3) {
                                    book3.getborrownumber();
                                }
                                break;
                            }

                            case "15" -> {
                                int availablecount = 0;
                                if (book1.grabstatus().equals("available")) {
                                    availablecount++;
                                }
                                if (book2.grabstatus().equals("available")) {
                                    availablecount++;
                                }
                                if (book3.grabstatus().equals("available")) {
                                    availablecount++;
                                }
                                System.out.println("Available book count: " + availablecount);
                                System.out.println("Borrowed book count: " + (3 - availablecount));
                            }
                            case "16" -> {
                                System.out.println("Thank you for using our system.");
                                System.exit(0);
                                break;
                            }
                        }

                    } else if (is_member) {
                        System.out.println("4. View available books.");
                        System.out.println("5. Borrow book(if available).");
                        System.out.println("6. Renew book.");
                        System.out.println("7. Return book.");
                        System.out.println("8. Reserve book.");
                        System.out.println("9. View remaining days until the book overdues.");
                        System.out.println("10. View how many more books can borrow.");
                        System.out.println("11. View personal details.");
                        System.out.println("12. Exit program.");

                        String Z = sc.nextLine();
                        switch (Z) {

                            case "1" -> {
                                if (is_book1) {
                                    book1.getdetails();
                                } else if (is_book2) {
                                    book2.getdetails();
                                } else if (is_book3) {
                                    book3.getdetails();
                                }
                                break;
                            }

                            case "2" -> {
                                if (is_book1) {
                                    book1.getstatus();
                                } else if (is_book2) {
                                    book2.getstatus();
                                } else if (is_book3) {
                                    book3.getstatus();
                                }
                                break;
                            }

                            case "3" -> {
                                if (is_book1) {
                                    book1.getsynopsis();
                                } else if (is_book2) {
                                    book2.getsynopsis();
                                } else if (is_book3) {
                                    book3.getsynopsis();
                                }
                                break;
                            }

                            case "4" -> {
                                ArrayList<String> availist = new ArrayList<>();
                                if (book1.grabstatus().equals("available")) {
                                    availist.add(book1.gettitle());
                                }
                                if (book2.grabstatus().equals("available")) {
                                    availist.add(book2.gettitle());
                                }
                                if (book3.grabstatus().equals("available")) {
                                    availist.add(book3.gettitle());
                                }
                                System.out.println(availist);
                            }

                            case "5" -> {
                                if (is_book1 && book1.grabstatus().equals("available")) {
                                    book1.setstatus("borrowed");
                                    book1.setnewnumber();
                                    if (Ahmad_logged_in) {
                                        System.out.println("You can only borrow this book for 30 days. (Type in when you want to return the book in this format: dd/MM/yyyy)");
                                        book1.setstudtakenuntil(sc.nextLine());
                                        Ahmad.setborrowing(book1.gettitle());
                                        Ahmad.addbook(book1.gettitle());
                                        Ahmad.setstudentlimit(1);
                                    } else if (Damian_logged_in) {
                                        System.out.println("You can borrow this book for 90 days. (Type in when you want to return the book in this format: dd/MM/yyyy)");
                                        book1.setstaftakenuntil(sc.nextLine());
                                        Damian.setborrowing(book1.gettitle());
                                        Damian.addbook(book1.gettitle());
                                        Damian.setstafflimit(1);
                                    }

                                } else if (is_book2 && book2.grabstatus().equals("available")) {
                                    book2.setstatus("borrowed");
                                    book2.setnewnumber();
                                    if (Ahmad_logged_in) {
                                        System.out.println("You can only borrow this book for 30 days. (Type in when you want to return the book in this format: dd/MM/yyyy)");
                                        book2.setstudtakenuntil(sc.nextLine());
                                        Ahmad.setborrowing(book2.gettitle());
                                        Ahmad.addbook(book2.gettitle());
                                        Ahmad.setstudentlimit(1);
                                    } else if (Damian_logged_in) {
                                        System.out.println("You can borrow this book for 90 days. (Type in when you want to return the book in this format: dd/MM/yyyy)");
                                        book2.setstaftakenuntil(sc.nextLine());
                                        Damian.setborrowing(book2.gettitle());
                                        Damian.addbook(book2.gettitle());
                                        Damian.setstafflimit(1);
                                    }
                                } else if (is_book3 && book3.grabstatus().equals("available")) {
                                    book3.setstatus("borrowed");
                                    book3.setnewnumber();
                                    if (Ahmad_logged_in) {
                                        System.out.println("You can only borrow this book for 30 days. (Type in when you want to return the book in this format: dd/MM/yyyy)");
                                        book3.setstudtakenuntil(sc.nextLine());
                                        Ahmad.setborrowing(book3.gettitle());
                                        Ahmad.addbook(book3.gettitle());
                                        Ahmad.setstudentlimit(1);
                                    } else if (Damian_logged_in) {
                                        System.out.println("You can borrow this book for 90 days. (Type in when you want to return the book in this format: dd/MM/yyyy)");
                                        book3.setstaftakenuntil(sc.nextLine());
                                        Damian.setborrowing(book3.gettitle());
                                        Damian.addbook(book3.gettitle());
                                        Damian.setstafflimit(1);
                                    }
                                } else {
                                    System.out.println("Book is taken.");
                                }
                                break;
                            }

                            case "6" -> {
                                if (is_book1 && book1.grabstatus().equals("borrowed")) {
                                    if (Ahmad_logged_in) {
                                        book1.setstudtakenuntil(sc.nextLine());
                                    } else {
                                        book1.setstaftakenuntil(sc.nextLine());
                                    }
                                } else if (is_book2 && book2.grabstatus().equals("borrowed")) {
                                    if (Ahmad_logged_in) {
                                        book2.setstudtakenuntil(sc.nextLine());
                                    } else {
                                        book2.setstaftakenuntil(sc.nextLine());
                                    }
                                } else if (is_book3 && book3.grabstatus().equals("borrowed")) {
                                    if (Ahmad_logged_in) {
                                        book3.setstudtakenuntil(sc.nextLine());
                                    } else {
                                        book3.setstaftakenuntil(sc.nextLine());
                                    }
                                } else {
                                    System.out.println("Error");
                                }
                                break;
                            }

                            case "7" -> {
                                if (is_book1 && book1.grabstatus().equals("borrowed")) {
                                    book1.setstatus("available");
                                    book1.setoverduedate("none");
                                    if (Ahmad_logged_in) {
                                        Ahmad.dropborrowing(book1.gettitle());
                                        Ahmad.setstudentlimit(0);
                                    } else {
                                        Damian.dropborrowing(book1.gettitle());
                                        Damian.setstafflimit(0);
                                    }
                                } else if (is_book2 && book2.grabstatus().equals("borrowed")) {
                                    book2.setstatus("available");
                                    book2.setoverduedate("none");
                                    if (Ahmad_logged_in) {
                                        Ahmad.dropborrowing(book2.gettitle());
                                        Ahmad.setstudentlimit(0);
                                    } else {
                                        Damian.dropborrowing(book2.gettitle());
                                        Damian.setstafflimit(0);
                                    }
                                } else if (is_book3 && book3.grabstatus().equals("borrowed")) {
                                    book3.setstatus("available");
                                    book3.setoverduedate("none");
                                    if (Ahmad_logged_in) {
                                        Ahmad.dropborrowing(book3.gettitle());
                                        Ahmad.setstudentlimit(0);
                                    } else {
                                        Damian.dropborrowing(book3.gettitle());
                                        Damian.setstafflimit(0);
                                    }
                                } else {
                                    System.out.println("Error");
                                }
                                break;
                            }

                            case "8" -> {
                                if (is_book1 && book1.grabstatus().equals("borrowed")) {
                                    book1.setreservation(sc.nextLine());
                                    book1.setstatus("reserved");
                                } else if (is_book2 && book2.grabstatus().equals("borrowed")) {
                                    book2.setreservation(sc.nextLine());
                                    book2.setstatus("reserved");
                                } else if (is_book3 && book3.grabstatus().equals("borrowed")) {
                                    book3.setreservation(sc.nextLine());
                                    book3.setstatus("reserved");
                                } else {
                                    System.out.println("Error");
                                }
                                break;
                            }

                            case "9" -> {
                                if (is_book1) {
                                    System.out.println(book1.get_days_till_overdue() + " days till overdue.");
                                } else if (is_book2) {
                                    System.out.println(book2.get_days_till_overdue() + " days till overdue.");
                                    book2.getstatus();
                                } else if (is_book3) {
                                    System.out.println(book3.get_days_till_overdue() + " days till overdue.");
                                    book3.getstatus();
                                }
                                break;
                            }

                            case "10" -> {
                                if (is_Ahmad) {
                                    System.out.println("Still can borrow: " + Ahmad.getstudlimit());
                                } else {
                                    System.out.println("Still can borrow: " + Damian.getstafflimit());
                                }
                                break;
                            }
                            case "11" -> {
                                if (is_Ahmad) {
                                    System.out.println("Currently borrowing: " + Ahmad.getborrowing());
                                    System.out.println("Borrow history: " + Ahmad.grabhistory());
                                    System.out.println("Still can borrow: " + Ahmad.getstudlimit());
                                    System.out.println("Currently charged for: RM" + Ahmad.grabcharges());
                                } else {
                                    System.out.println("Currently borrowing: " + Damian.getborrowing());
                                    System.out.println("Borrow history: " + Damian.grabhistory());
                                    System.out.println("Still can borrow: " + Damian.getstafflimit());
                                    System.out.println("Currently charged for: RM" + Damian.grabcharges());
                                }
                                break;
                            }
                            case "12" -> {
                                System.out.println("Thank you for using our system.");
                                System.exit(0);
                                break;
                            }
                        }

                    }
                } else {
                    System.out.println("Error");
                }
                System.out.println("\n\nDo you wish to continue using this account?");
                answer = sc.nextLine();
            } while (answer.equals("yes"));
        } while (answer.equals("no"));
    }
}
