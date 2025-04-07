import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            String username;
            String password;
            String cellphoneNumber;


            // username entry
            System.out.println("Enter your username");
            username = scanner.nextLine();
            if (username.contains("_") && username.length() <= 5) {
                System.out.println("Username successfully captured");
            } else {
                System.out.println("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length");
            }
            //cellphone number
            System.out.println("Enter your Cellphone number");
            cellphoneNumber = scanner.nextLine();
            if (hasCellphoneNum(cellphoneNumber)) {
                System.out.println("Cellphone number successfully added");
            } else {
                System.out.println("Cellphone number is incorrectly formated or does not contain an international code");
            }

            // passwords
            System.out.println("Enter your password");
            password = scanner.nextLine();

            // password verification
            if (checkPassword(password) && hasSpecialCharacter(password)) {

                System.out.println("Password successfully captured");
            } else {
                System.out.println("Password does not meet the requirements. It should be at least 8 characters long and contain at least one uppercase letter, one lowercase letter, a digit and a special character.");
            }
            scanner.close();
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

        //Cellphone verification
        public static boolean hasCellphoneNum(String in) {
            return in.charAt(0) == '2' && in.charAt(1) == '7' && in.length() == 10 && in.matches("[0-9]+");
        }
    }
