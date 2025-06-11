import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static boolean passcheck(String password) {
        String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!]).{8,}$";
        return password.matches(regex);
    }

    public static boolean validemail(String emailadderess) {
        String regex1 = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";
        return emailadderess.matches(regex1);
    }






    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        USER user = null;
        System.out.println("welcome! in our project");
        System.out.println("press 1) for USER");
        System.out.println("press 2) for ADMIN");
        int usership = scanner.nextInt();
        if (usership == 1) {
            scanner.nextLine();
            System.out.println("press 1) for login ");
            System.out.println("press 2) for signup");

            int check = scanner.nextInt();
            scanner.nextLine();

            if (check == 1) {
                System.out.println("LOGIN PAGE");
                System.out.println("***************************************");
                {
                    System.out.println("enter the user name");
                    String userlogin1 = scanner.nextLine();
                    scanner.nextLine();
                    System.out.println("enter the password");
                    String userpass = scanner.nextLine();

                    if (user == null || (user.username == null && user.pass == null)) {
                        System.out.println("Please make an account first.");
                    }
                }
                System.out.println("press 2) for signup");
                check = scanner.nextInt();
                scanner.nextLine();


            }

            if (check == 2) {
                System.out.println("SIGNUP PAGE");
                System.out.println("***************************************");


                System.out.print("Enter your email: ");
                String email = scanner.nextLine();
                String ans;
                while (true) {

                    if (validemail(email)) {
                        System.out.println("✅ Email accepted.");
                        break;
                    } else {
                        System.out.println("❌ Invalid email format. Please try again.");
                        System.out.print("Enter your email: ");
                        email = scanner.nextLine();
                    }

                }


                //username
                System.out.print("enter the username:");
                String username = scanner.nextLine();

                //password

                String password;
                do {
                    System.out.print("Enter your password:");
                    password = scanner.nextLine();
                    if (passcheck(password)) {
                        System.out.println("✅ your password is strong");
                        user = new USER(email, password, username);
                        break;
                    }
                    if (!passcheck(password)) {
                        System.out.println("❌ Invalid password format. Please try again.");
                    }

                } while (true);
                System.out.println("✅ Signup successful!");
                boolean aftersignup = true;
                if (check == 2) {
                    while (aftersignup) {
                        System.out.println("LOGIN PAGE");
                        System.out.println("***************************************");

                        System.out.print("enter the user name: ");
                        String userlogin1 = scanner.nextLine();
                        System.out.print("enter the password: ");
                        String userpass = scanner.nextLine();

                        if ((userlogin1.equals(user.username) && userpass.equals(user.pass))) {
                            System.out.println("✅login successful");
                            aftersignup = false;
                        } else {
                            System.out.println("❌login unsuccessful");
                        }
                    }
                }
            }
        }
        int flightco = 0 ;
        int count = 5;
        if(usership == 2){

         //   Scanner scanner = new Scanner(System.in);
            boolean running = true;
            ADMIN[] admin =  new ADMIN[5];
            while (running) {
                System.out.println("\n--- Admin Menu ---");
                System.out.println("1. Add Flight");
                System.out.println("2. Remove Flight");
                System.out.println("3. View Flights");
                System.out.println("4. Exit");

                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // consume newline


                switch (choice) {
                    case 1:

                        for(int i = flightco ; i< admin.length ; i++) {
                                System.out.println("Enter Flight name: ");
                                String airlinename = scanner.nextLine();
                                System.out.print("ADD FLIGHT NUMBER ");
                                String flightnum = scanner.nextLine();

                            System.out.println("seats in eco");
                            int seatineco = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("seats in bus");
                            int seatinbus = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("seats in stan");
                            int seatinstan = scanner.nextInt();
                            scanner.nextLine();
                            admin[i] =new ADMIN(airlinename, flightnum, seatineco, seatinbus, seatinstan);
                            System.out.println("✅ Flight added.");
                            flightco++;
                            System.out.println("wanna add more if yes press 1)");
                            System.out.println("for exit press 2)");
                            int con = scanner.nextInt();
                            if(con == 2){
                                break;
                            }
                        }
                        break;

                    case 2:

                        System.out.print("Enter Flight Number to Remove: ");
                        String removeNum = scanner.nextLine();
                        boolean found = false;
                        for (int i = 0; i < flightco; i++) {
                            if (admin[i].airnum.equals(removeNum)) {  // ✅ Use .equals() to compare strings
                                // Shift flights to the left
                                for (int j = i; j < 5 - 1; j++) {
                                    admin[j] = admin[j + 1];
                                }
                                admin[5 - 1] = null; // optional: clear last duplicate
                                count--; // reduce total flight count
                                System.out.println("❌ Flight removed.");
                                flightco--;
                                found = true;
                                break;
                            }
                        }
                        if (!found) {
                            System.out.println("⚠️ Flight not found.");
                        }
                        break;

                    case 3:
                        System.out.println("--- List of Flights ---");
                        if (flightco == 0) {
                            System.out.println("No flights available.");
                            break;
                        } else {
                            for(int j = 0 ; j <flightco; j++){
                                System.out.println("AIRLINE NAME : " +admin[j].airline);
                                System.out.println("AIRLINE NUM : " +admin[j].airnum);
                                System.out.println("*******************");
                            }
                        }
                        break;

                    case 4:
                        running = false;
                        break;

                    default:
                        System.out.println("❌ Invalid option.");
                }
            }
        }
    }
        }



