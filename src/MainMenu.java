import java.util.Scanner;

    public class MainMenu {

        Scanner scanner = new Scanner(System.in);
        String password = "1234";
        String userName = "Login";


        //This is the login method.

        public void Login() {
            while (true) {
                System.out.println("Type In Your Username");
                String userNameAccess = scanner.nextLine();

                System.out.println("Type In Your Password");
                String passwordAccess = scanner.nextLine();

                if (userName.equals(userNameAccess) && passwordAccess.equals(password)) {
                    System.out.println("Login Successful");
                    menuOptions();
                    break;

                } else {
                    System.out.println("Login Failed");
                }

            }
            Login();
        }

        //Once user passes the login method.
        // Then they need to choose an option from the main menu

        public void menuOptions() {

            while (true) {
                try {
                    System.out.println("1. Add Video Games");
                    System.out.println("2. View Video Games");
                    System.out.println("3. Update Video Games");
                    System.out.println("4. Delete Video Games");
                    System.out.println("5. Buy Video Games");
                    System.out.println("6. Exit");

                    String option = scanner.nextLine();

                    switch (option) {
                        case "1":
                            System.out.println("Add Video Game");
                            addGame addGame = new addGame();
                            addGame.start();
                            break;
                        case "2":
                            System.out.println("View Video Games");
                            viewGame viewGame = new viewGame();
                            viewGame.startView();
                            break;

                        case "3":
                            System.out.println("Update Video Games");
                            updateGames UDG = new updateGames();
                            UDG.startUpdate();
                            break;
                        case "4":
                            System.out.println("Delete Video Games");
                            deleteGames delGame = new deleteGames();
                            delGame.startToDeleteGames();
                            break;
                        case "5":
                            System.out.println("Buy Video Games");
                            BuyGames buyGame = new BuyGames();
                            buyGame.startBuying();
                            break;
                        case "6":
                            System.out.println("Exit");
                            System.out.println("Goodbye!");
                            break;

                        default:
                            System.out.println("Invalid Option");
                            menuOptions();
                            break;
                    }
                    break;

                } catch (Exception e) {
                    System.out.println("Invalid Choice. Returning To Main Menu");
                    menuOptions();
                }
            }
        }
    }