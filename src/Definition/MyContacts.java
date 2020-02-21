package Definition;

import Adt.MyContactsAdt;

import java.util.Scanner;

public class MyContacts implements MyContactsAdt {
    Scanner sc = new Scanner(System.in);

    MyList<Person> MyContactsBook = new MyList<Person>();
    MyList<String> contactNumbers = new MyList<>();

    @Override
    public void addContact() {
        System.out.println("You have chosen to add a new contact:");
        String firstname = GetFirstName();
        String lastname = GetLastname();
        contactNumbers = GetContactnumbers();
        String Email = GetEmail();
        Person newContact;
        newContact = new Person(firstname, lastname, Email, contactNumbers);
        int index = compareFirstname(firstname);
        MyContactsBook.add(newContact, index);
        System.out.println("Contact Added SucessFully");
        System.out.println();
        System.out.println();

    }
    @Override
    public void viewContacts() {
        System.out.println("---Here are all your contacts---\n" +
                "-------- * -------- * -------- * --------");
        Person response = null;
        for (int i = 0; i < MyContactsBook.size; i++) {
            response = MyContactsBook.getData(i);
            System.out.println(response);
        }

    }

    private int compareFirstname(String Firstname) {
        int index = 0;
        if (MyContactsBook.size == 0) {
        } else {
            for (int i = 0; i < MyContactsBook.size; i++) {
                index = i;
                Person temp = MyContactsBook.getData(i);
                String name = temp.getFirstName();
                name = name.toLowerCase();
                Firstname = Firstname.toLowerCase();
                if (name.compareTo(Firstname) < 0) {
                    index++;
                    continue;
                } else {
                    break;
                }

            }

        }
        return index;
    }

    @Override
    public Object deletecontact() {
        return null;
    }

    @Override
    public void searchcontact() {

    }

    private String GetFirstName() {
        System.out.println("Please Enter the name of the Person");
        System.out.print("FirstName: ");
        String firstname = sc.next();
        return firstname;

    }

    private String GetLastname() {
        System.out.print("Lastname: ");
        String lastname = sc.next();
        return lastname;

    }

    private MyList<String> GetContactnumbers() {
        MyList<String> contactNumbers = new MyList<String>();
        System.out.print("ContactNumber: ");
        String contactno = sc.next();
        contactNumbers.add(contactno);
        while (true) {
            System.out.print("Do You Want to add a new Contactnumber? (y/n) :");
            String a = sc.next();
            if (a.equals("y")) {
                System.out.print("ContactNumber: ");
                contactno = sc.next();
                contactNumbers.add(contactno);
            } else if (a.equals("n")) {
                break;
            } else {
                System.out.println("Please Enter a Vaild Input i.e., y(lowercase) for Yes or n(lowercase for NO)");
            }
        }
        return contactNumbers;
    }

    private String GetEmail() {
        String Email = null;
        System.out.print("Do You Want to add an email ? (y/n) :");
        String a = sc.next();
        if (a.equals("y")) {
            System.out.print("Email Address: ");
            Email = sc.next();
        } else if (a.equals("n")) {
        } else {
            System.out.println("Please Enter a Vaild Input i.e., y(lowercase) for Yes or n(lowercase for NO)");
        }
        return Email;
    }


}
