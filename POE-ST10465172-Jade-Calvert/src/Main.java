import java.util.Scanner; // For user input
import java.util.regex.Matcher; // For matching regular expressions
import java.util.regex.Pattern; // For defining regular expression patterns
import java.util.HashMap; // For storing usernames and passwords
public class main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, String> users = new HashMap<>();

        String username = "";
        boolean usernameValid = false;
        String cellphoneNumber;
        boolean cellphoneValid = false;
        String password = "";
        boolean passwordValid = false;
        boolean loginSuccess = false;

        // Loops until user puts in the correct username
        while (!usernameValid) {
            System.out.println("Enter your username (max 5 chars, one '_'):");
            username = scanner.nextLine();

            // Validate the username
            if (checkUsername(username)) {
                // Displays success message if the username is valid
                System.out.println("Username successfully captured!");
                usernameValid = true; // This is to exit the loop
            } else {
                // Displays error message and tells the user to try again
                System.out.println("Invalid username format. Please try again.");
            }
        }
        // Storing username and password
        users.put(username, password);

        // Loops until user uses a valid cellphone number
        while (!cellphoneValid) {
            System.out.println("Enter your cellphone number (starting with country code, >= 8 digits):");
            // Prompt the user to enter their cellphone number using an input dialog
            cellphoneNumber = scanner.nextLine();

            // Validate the entered cellphone number
            if (isCellphoneNumberInternational(cellphoneNumber)) {
                // Display a success message if the cellphone number is valid
                System.out.println("Cellphone number successfully added!");
                cellphoneValid = true; // Set the flag to exit the cellphone number input loop
            } else {
                // Display an error message and prompt the user to try again
                System.out.println("Invalid cellphone number format. Please try again.");
            }
        }
        // Loop until a valid password is entered
        while (!passwordValid) {
            // Prompt the user to enter their password using an input dialog
            password = scanner.nextLine();
            System.out.println("Enter your password (>= 8 chars, upper, lower, digit, special):");
            // Validate the entered password
            if (isPasswordValid(password)) {
                // Display a success message if the password is valid
                System.out.println("Password successfully captured!");
                // In a real application, you would hash the password here for security.
                System.out.println("All data validated successfully");
                passwordValid = true; // Set the flag to exit the password input loop
            } else {
                // Display an error message and prompt the user to try again
                System.out.println("Password does not meet the complexity requirements. Please try again.");
            }
        }

        // LOGIN LOOP

        while (!loginSuccess) {
            System.out.print("Please enter your username: ");
            username = scanner.next();
            System.out.print("Please enter your password: ");
            password = scanner.next();

            boolean validUserName = LoginSystem.isValidUserName (username);
            boolean validPassword = LoginSystem.isValidPassword(password);

            if (!validUserName || !validPassword) {
                System.out.println("Login failed due to incorrect username or password format.");
                continue;
            }

            if (users.containsKey(username) && users.get(username).equals(password)) {
                System.out.println("Login successful!");
                System.out.println("Welcome back, " + username+ " " + "! It's good to have you back.");
                loginSuccess = true;
            } else {
                System.out.println("Login failed! Incorrect username or password.");
            }

        }
    }
//username validation
   public static boolean checkUsername (String username) {
           // Count the number of underscore characters in the username
           long underscoreCount = username.chars().filter(ch -> ch == '_').count();
           // Return true if there is exactly one underscore and the length is not more than 5
           return underscoreCount == 1 && username.length() <= 5;
   }

    //Regex pattern is inspired by ChatGPT (OpenAI,2024)
    public static boolean isCellphoneNumberInternational(String cellphoneNumber) {
        // Check if the string is not null or empty, matches the pattern of digits and/or '+', and has at least 8 characters
        return cellphoneNumber != null && cellphoneNumber.matches("^[0-9+]+$") && cellphoneNumber.length() >= 8;
    }


    public static boolean isPasswordValid(String password) {
        // Checks if password has nothing input or the length less than 8
        if (password == null || password.length() < 8) {
            return false;
        }
        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        // Iterate through each character of the password
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (Character.isUpperCase(c)) {
                hasUpper = true;
            } else if (Character.isLowerCase(c)) {
                hasLower = true;
            } else {
                // Use a regular expression to check for special characters (anything not alphanumeric)
                Pattern specialPattern = Pattern.compile("[^a-zA-Z0-9]");
                Matcher specialMatcher = specialPattern.matcher(String.valueOf(c));
                if (specialMatcher.find()) {
                    hasSpecial = true;
                }
            }
        }
        // Return true only if all the required character types are present
        return hasUpper && hasLower && hasDigit && hasSpecial;

    }
}
// Login validation system
class LoginSystem {
    public static boolean isValidUserName(String username) {
        return main.checkUsername(username);
    }

    public static boolean isValidPassword(String password) {
        return main.isPasswordValid (password);
    }
}
