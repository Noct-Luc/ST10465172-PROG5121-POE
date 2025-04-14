import java.util.Scanner; // For user input
import java.util.regex.Matcher; // For matching regular expressions
import java.util.regex.Pattern; // For defining regular expression patterns

public class main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String username;
        boolean usernameValid = false;

        // Loops until user puts in the correct username
        while (!usernameValid) {
            System.out.println("Enter your username (max 5 chars, one '_'):");
            username = scanner.nextLine ();

            // Validate the username
            if (username.length()<=5 && username.contains("_")) {
                // Displays success message if the username is valid
               System.out.println("Username successfully captured!");
                usernameValid = true; // This is to exit the loop
            } else {
                // Displays error message and tells the user to try again
                System.out.println("Invalid username format. Please try again.");
            }
        }

        String cellphoneNumber;
        boolean cellphoneValid = false;

        // Loops until user uses a valid cellphone number 
        while (!cellphoneValid) {
            System.out.println( "Enter your cellphone number (starting with country code, >= 8 digits):");
            // Prompt the user to enter their cellphone number using an input dialog
            cellphoneNumber = scanner.nextLine();

            // Check if the user provided input (didn't cancel)

            // Validate the entered cellphone number
            if (isCellphoneNumberInternational(cellphoneNumber)) {
                // Display a success message if the cellphone number is valid
                System.out.println(  "Cellphone number successfully added!");
                cellphoneValid = true; // Set the flag to exit the cellphone number input loop
            } else {
                // Display an error message and prompt the user to try again
                System.out.println(  "Invalid cellphone number format. Please try again.");
            }
        }

        String password;
        boolean passwordValid = false;

        // Loop until a valid password is entered
        while (!passwordValid) {
            // Prompt the user to enter their password using an input dialog
            password = scanner.nextLine(); System.out.println( "Enter your password (>= 8 chars, upper, lower, digit, special):");

            // Check if the user provided input (didn't cancel)



            // Validate the entered password
            if (isPasswordValid(password)) {
                // Display a success message if the password is valid
                System.out.println(  "Password successfully captured!");
                // In a real application, you would hash the password here for security.
                System.out.println( "All data validated successfully");
                passwordValid = true; // Set the flag to exit the password input loop
            } else {
                // Display an error message and prompt the user to try again
                System.out.println(  "Password does not meet the complexity requirements. Please try again.");
            }
        }
    }

    /**
     * Enhanced username validation: checks if the username contains exactly one underscore
     * and is at most 5 characters long.
     *
     * @param username The username string to validate.
     * @return true if the username is valid according to the criteria, false otherwise.
     */


    /**
     * Enhanced cellphone number validation: checks if the number starts with a digit or '+'
     * (for a country code) and has a minimum length of 8 digits. This is a basic check.
     *
     * @param cellphoneNumber The cellphone number string to validate.
     * @return true if the cellphone number format is potentially valid, false otherwise.
     */
    //Regex pattern inspired by ChatGPT (OpenAI,2024)
    public static boolean isCellphoneNumberInternational(String cellphoneNumber) {
        // Check if the string is not null or empty, matches the pattern of digits and/or '+', and has at least 8 characters
        return cellphoneNumber != null && cellphoneNumber.matches("^[0-9+]+$") && cellphoneNumber.length() >= 8;
    }

    /**
     * Enhanced password strength check: verifies if the password has at least 8 characters
     * and contains at least one uppercase letter, one lowercase letter, one digit, and one special character.
     *
     * @param password The password string to validate.
     * @return true if the password meets all the strength requirements, false otherwise.
     */
    public static boolean isPasswordValid(String password) {
        // Check for null or length less than 8
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
