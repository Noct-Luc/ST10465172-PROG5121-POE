import java.util.Scanner;

public static class Login {
    public static void login() {
        String Username 
        String Password 
        Scanner scanner = new Scanner(System.in);

        //Enter username and password 
        System.out.print("Enter username: ");
        String Username = scanner.nextLine();

        System.out.print("Enter password: ");
        String Password = scanner.nextLine();

        // Credentials validation 
        if (Username.equals(register.getUsername()) && Password.equals(register.getPassword())) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Invalid username or password. Please try again.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Create instances of Register and Login classes
        Register register = new Register();
        Login login = new Login();

        // Register the user
        register.register();

        // Try to log in with the registered details
        login.login(register);
    }
    
