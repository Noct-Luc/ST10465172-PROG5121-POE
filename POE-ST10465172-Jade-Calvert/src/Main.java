import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class main {
    public static void main(String[] args) {
        Registration registration = new Registration();
        Scanner scanner = new Scanner(System.in);
        String firstName;
        String lastName;
        String username;
        String password;
        String cellNumber;

        // personal information
        System.out.println("Enter your first name");
        firstName = scanner.nextLine();
        registration.setFirstName(firstName);

        System.out.println("Enter your last name");
        lastName = scanner.nextLine();
        registration.setLastName(lastName);

        //cellphone number
        System.out.println("Enter your cellphone number");
        cellNumber = scanner.nextLine();
        registration.setCellNumber(cellNumber);

        if (!isValidCellphoneNumber(cellNumber))
            System.out.println("Cell phone number incorrectly formatted or does not contain international code.");
        else {
            System.out.println("Cell phone number successfully added.");
        }

        //username entry
        System.out.println("Enter your username");
        username = scanner.nextLine();
        registration.setUsername(username);

        if (username.contains("_") && username.length() <= 5) {
            System.out.println("Username successfully captured");
        } else {
            System.out.println("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length");
        }

        // passwords
        System.out.println("Enter your password");
        password = scanner.nextLine();
        registration.setPassword(password);

        // password verification
        if (checkPassword(password) && hasSpecialCharacter(password)) {

            System.out.println("Password successfully captured");

        } else {
            System.out.println("Password does not meet the requirements. It should be at least 8 characters long and contain at least one uppercase letter, one lowercase letter, a digit and a special character.");
        }
        printRegistrationData(registration);
        scanner.close();

    }

    private static void printRegistrationData(Registration registration) {
        System.out.println(registration.getFirstName());
        System.out.println(registration.getLastName());
        System.out.println(registration.getCellNumber());
        System.out.println(registration.getUsername());
        System.out.println(registration.getPassword());
    }

   static class Registration {
        private String firstName;
        private String lastName;
        private String username;
        private String password;
        private String cellNumber;

        public String getFirstName() {
            return firstName;
        }
        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }
        public String getLastName() {
            return lastName;
        }
        public void setLastName(String lastName) {
            this.lastName = lastName;
        }
        public String getCellNumber() {
            return cellNumber;
        }
        public void setCellNumber(String cellNumber) {
            this.cellNumber = cellNumber;
        }
        public String getUsername() {
            return username;
        }
        public void setUsername(String username) {
            this.username = username;
        }
        public String getPassword() {
            return password;
        }
        public void setPassword(String password) {
            this.password = password;
        }
    }

//cellphone validation
public static boolean isValidCellphoneNumber(String cellNumber) {
        // Check if number starts with + followed by country code and up to 10 digits
        if (cellNumber.startsWith("+27")) {
            String numberPart = cellNumber.substring(3); // Get everything after +27
            return numberPart.matches("\\d{1,10}"); // Only digits, 1 to 10 in length
        }
        return false;
    }
    // password verification
    public static boolean checkPassword(String password) {
        if (password.length() < 8) {
            return false;
        }
        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;

        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (Character.isUpperCase(c)) {
                hasUpper = true;
            } else if (Character.isLowerCase(c)) {
                hasLower = true;
            }
        }
        return hasUpper && hasLower && hasDigit;
    }
    public static boolean hasSpecialCharacter(String password) {
        Pattern sPattern = Pattern.compile("[^a-zA-Z0-9]");
        Matcher sMatcher = sPattern.matcher(password);
        return sMatcher.find();
    }

}
