public class Inventory {
    public static void printInventory(){
        System.out.println("***********************************");
        System.out.println("Apple tree. Apple amount - infinity");
        System.out.println("My basket.  Apple amount - " + InventoryDB.count());
        System.out.println("1. Pick an apple");
        System.out.println("2. Eat an apple");
        System.out.println("3. Show my basket");
        System.out.println("0. Quit main menu");
    }
    public static void start(){
        boolean isQuit = false;
        printInventory();

        while (!isQuit) {
            try {
                int userInput = UserInput.pickNumber();
                switch (userInput) {
                    case 0 -> {
                        System.out.println("Quit the game");
                        isQuit = true;
                    }
                    case 1 -> {
                        InventoryDB.insert(new Apple());
                        printInventory();
                    }
                    case 2 -> {
                        InventoryDB.delete();
                        printInventory();
                    }
                    case 3 -> InventoryDB.show();
                    default -> System.out.println("Please, enter \"1\", \"2\", \"3\", or \"Quit\"");
                }
            }
            catch (Exception e){
                System.out.println("This is not a number!");
            }
        }
    }
}
