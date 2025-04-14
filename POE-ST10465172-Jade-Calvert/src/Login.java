import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginSystem {

    private static final String USERNAME_REGEX = "^[a-zA-Z][a-zA-Z0-9]*$";


    private static final String PASSWORD_REGEX = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*(),.?\":{}|<>])[A-Za-z\\d!@#$%^&*(),.?\":{}|<>]{8,}$";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstName;
        String lastUserName;
        String username;
        String password;
        String cellNumber;

        // username entry
        System.out.println("Enter your username");
        username = scanner.nextLine();
      while {
          if (isValidUsername) {
            System.out.println("Username successfully captured");
        } else {
            System.out.println("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length");
        }
      }

        System.out.println("Enter your password");
        password = scanner.nextLine();

        // password verification
        if (isValidPassword(password)) {

            System.out.println("Password successfully captured");
        } else {
            System.out.println("Password is incorrect.");
        }
        System.out.println("Welcome");
        scanner.close();
    }

    // Method to validate username using regex
    public static boolean isValidUsername(String username) {
        (username.contains("_") && username.length() <= 5)
        return
    }

    // Method to validate password using regex
    public static boolean isValidPassword(String password) {
        Pattern pattern = Pattern.compile(PASSWORD_REGEX);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
}
