public class MainMenu {
    public static void printMainMenu(){
        System.out.println("*****************");
        System.out.println("*** Inventory ***");
        System.out.println("1. Play!");
        System.out.println("0. Exit");
    }

    public static void start(){
        boolean isQuit = false;
        printMainMenu();
        while (!isQuit) {
            try {
                int userInput = UserInput.pickNumber();
                switch (userInput) {
                    case 0 -> {
                        System.out.println("Quit the game");
                        isQuit = true;
                    }
                    case 1 -> {
                        Inventory.start();
                        printMainMenu();
                    }
                    default -> System.out.println("Please, enter \"Play\" or \"Quit\"");
                }
            }
            catch (Exception e){
                System.out.println("This is not a number!");
            }
        }
    }
}
