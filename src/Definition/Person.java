package Definition;

/**
 * This class will serve as a individual element of our Contact List
 * it has 4 fields
 * 1. firstName (String type)
 * 2. lastName (String type)
 * 3. email (String type)
 * 4.A list of Contact Numbers (String type)  (but only digits allowed)
 */
public class Person {
    /**
     * Declaration of the fields
     */
    private String firstName;
    private String lastName;
    private String email;
    private MyList<String> contactNumbers;

    /**
     * Constructor to initialize the value of the fields
     *
     * @param firstName      the First Name of the person
     * @param lastName       the Last Name of the person
     * @param email          the email of the person
     * @param contactNumbers all contact numbers of the person
     */

    public Person(String firstName, String lastName, String email, MyList<String> contactNumbers) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.contactNumbers = contactNumbers;
    }


    /**
     * Getter method of the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Getter method of the lastName
     */

    public String getLastName() {
        return lastName;
    }

    /**
     * Getter method of the email
     */

    public String getEmail() {
        return email;
    }

    /**
     * Getter method of contactNumbers as required
     *
     * @return String of all Contact Numbers
     */

    public String getContactNumbers() {
        /*
          Initialize a new String Builder for storing contact String
         */
        StringBuilder contacts = new StringBuilder();
        /*
          initialization of a boolean variable for ternary operation that was required
          */
        boolean a = false;
        /*
          a loop to traverse all the contactNumbers list
         */
        for (int i = 0; i < contactNumbers.size; i++) {
            if (i == 0) {
                /*
                  first contact append without comma
                 */
                contacts.append(contactNumbers.getData(i));
            } else
            /*
              Second or afterwords contacts append with comma
             */
                contacts.append(",").append(contactNumbers.getData(i));
        }
        /*
          if no contacts found append null
         */
        if (contactNumbers.size == 0) {
            contacts.append("null");
        }
        /*
          if only 1 contact found then change the value of a(boolean value initialized above) to true
         */
        else if (contactNumbers.size == 1) {
            a = true;
        }
        /*
          if a found true return "Contact Number: " + StringBuilder
          otherwise return  "Contact Numbers: " + StringBuilder
         */

        return a ? "Contact Number: " + contacts : "Contact Numbers:" + contacts;
    }

    /**
     * overridden toString() method to print the contact according to requirement
     */

    @Override
    public String toString() {
        return "First Name: " + getFirstName() + "\n" + "Last Name:" + getLastName() + "\n" + getContactNumbers() + "\n" + "Email address:" + getEmail() + "\n" + "-------- * -------- * -------- * --------\n" +
                "-------- * -------- * -------- * --------";
    }


}
