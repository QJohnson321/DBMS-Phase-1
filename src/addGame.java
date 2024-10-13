import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.DoubleUnaryOperator;

public class addGame {

    Scanner scanner = new Scanner(System.in);

    String Yes = "Y";
    String No = "N";
    String title, genre, studio, console, releaseDate, multiplayer, productType;
    int gameId;
    double price;
    gameDatabase db = new gameDatabase();


        public void start() {
            gameId = -1;
            price = -0.1;
            List<gameAttributes> games = new ArrayList<>();

            //This is to make sure that the user can only enter an int
            // That's why the gameID is set at -1 once the user enters
            // a positive number greater than 0 the program will keep that number
            // If the user enters anything other than an int the Integer.parseInt(gameId1);
            // will trigger the (Exception e)
            while (true) {
                try {
                    System.out.println("Enter Game Id");
                    String gameId1 = scanner.nextLine();
                    gameId = Integer.parseInt(gameId1);
                    if (gameId > 0) {
                        break;
                        } else {
                            System.out.println("Please enter a valid game ID");
                        }
                    } catch (Exception e) {
                        System.out.println("Please enter a valid number.");
                }

            }
            // We are just gathering information
            //from the user to add to database
            System.out.println("Enter Title");
            String title = scanner.nextLine();

            System.out.println("Enter Genre");
            String genre = scanner.nextLine();

            System.out.println("Enter Release Month, Day, Year");
            String releaseMonth = scanner.nextLine();

            System.out.println("Enter Console Manufacture");
            String console = scanner.nextLine();

            System.out.println("Enter Console Studio");
            String studio = scanner.nextLine();

            System.out.println("Enter Product Type");
            String productType = scanner.nextLine();

            System.out.println("Multiplayer");
            String multiplayer = scanner.nextLine();



            //This is to make sure that the user can only enter an double
            // That's why the price is set at -1.0 once the user enters
            // a positive number greater than 0 the program will keep that number
            // If the user enters anything other than an int the Double.parseDouble(gamePrice);;
            // will trigger the (Exception e)
            while (true) {
                try {
                    System.out.println("Enter The Price: ");
                    String gamePrice = scanner.nextLine();
                    price = Double.parseDouble(gamePrice);
                    if (price > 0) {
                        break;
                    } else {
                        System.out.println("Please enter a valid game ID");
                    }
                } catch (Exception e) {
                    System.out.println("Please enter a valid number.");
                }

            }

            //This is to confirm the user wants to add the game to the database
            System.out.println("Are you sure you want to add a new game (Y/N) ?");
            String answer = scanner.nextLine();
            answer = answer.toLowerCase();

            if (answer.equalsIgnoreCase("Y")) {
                gameAttributes addingNewGameAttributes = new gameAttributes(gameId, title, genre, releaseMonth, console, studio, productType, multiplayer,price);
                db.addingGamesToDatabase(addingNewGameAttributes);

            } else if (answer.equalsIgnoreCase("N")) {
                System.out.println("Returning To Main Menu");
                MainMenu returnToMainMenu = new MainMenu();
                returnToMainMenu.menuOptions();

            } else {
                System.out.println("Invalid answer");
            }
            returnToMainMenu();
        }
        // When the user is done they will be prompted to return to the
        // Main Menu or if they would like to add another game

    public void returnToMainMenu(){
        int answer = -1;

        while(true) {
            try {
                System.out.println("Return To Main Menu. Press 1 ?");
                System.out.println("Delete Another Game. Press 2 ?");

                answer = Integer.parseInt(scanner.nextLine());
                //scanner.nextLine();


                switch(answer) {
                    case 1:
                        MainMenu returnToMainMenu = new MainMenu();
                        returnToMainMenu.menuOptions();
                        break;

                    case 2:
                        start();
                        break;

                    default:
                        System.out.println("Invalid Choice. Returning To Main Menu");
                        MainMenu returnToMainMenu2 = new MainMenu();
                        returnToMainMenu2.menuOptions();
                        break;
                }
                break;

            }catch(Exception e) {
                System.out.println("Invalid Choice. Returning To Main Menu");
                returnToMainMenu();
            }
        }
    }
}
