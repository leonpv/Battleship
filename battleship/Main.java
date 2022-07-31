package battleship;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //player 1
        Board board = new Board();
        System.out.println("Player 1, place your ships on the game field");
        board.printBoard();
        int length;

        while (true) {
            length = 5;
            System.out.println("Enter the coordinates of the Aircraft Carrier (5 cells):");
            String[] inputArray = scanner.nextLine().trim().split("\\s+");
            if (!isCheckInput(inputArray)) continue;

            UserInput userInput = new UserInput(inputArray);
            if (!userInput.checkLength(length)) continue;

            Ship aircraftCarrier5 = new Ship(userInput.getCordArr(), length);
            if (!board.checkPlaceShipOnBoard(aircraftCarrier5)) continue;

            board.placeShipOnBoard(aircraftCarrier5);
            board.printBoard();
            break;
        }
        while (true) {
            length = 4;
            System.out.println("Enter the coordinates of the Battleship (4 cells):");
            String[] inputArray = scanner.nextLine().trim().split("\\s+");
            if (!isCheckInput(inputArray)) continue;

            UserInput userInput = new UserInput(inputArray);
            if (!userInput.checkLength(length)) continue;

            Ship battleship4 = new Ship(userInput.getCordArr(), length);
            if (!board.checkPlaceShipOnBoard(battleship4)) continue;

            board.placeShipOnBoard(battleship4);
            board.printBoard();
            break;
        }
        while (true) {
            length = 3;
            System.out.println("Enter the coordinates of the Submarine (3 cells):");
            String[] inputArray = scanner.nextLine().trim().split("\\s+");
            if (!isCheckInput(inputArray)) continue;

            UserInput userInput = new UserInput(inputArray);
            if (!userInput.checkLength(length)) continue;

            Ship submarine3 = new Ship(userInput.getCordArr(), length);
            if (!board.checkPlaceShipOnBoard(submarine3)) continue;

            board.placeShipOnBoard(submarine3);
            board.printBoard();
            break;
        }
        while (true) {
            //length = 3;
            System.out.println("Enter the coordinates of the Cruiser (3 cells):");
            String[] inputArray = scanner.nextLine().trim().split("\\s+");
            if (!isCheckInput(inputArray)) continue;

            UserInput userInput = new UserInput(inputArray);
            if (!userInput.checkLength(length)) continue;

            Ship cruiser3 = new Ship(userInput.getCordArr(), length);
            if (!board.checkPlaceShipOnBoard(cruiser3)) continue;

            board.placeShipOnBoard(cruiser3);
            board.printBoard();
            break;
        }
        while (true) {
            length = 2;
            System.out.println("Enter the coordinates of the Destroyer (2 cells):");
            String[] inputArray = scanner.nextLine().trim().split("\\s+");
            if (!isCheckInput(inputArray)) continue;

            UserInput userInput = new UserInput(inputArray);
            if (!userInput.checkLength(length)) continue;

            Ship destroyer2 = new Ship(userInput.getCordArr(), length);
            if (!board.checkPlaceShipOnBoard(destroyer2)) continue;

            board.placeShipOnBoard(destroyer2);
            board.printBoard();
            break;
        }

        promptEnterKey();

        //player 2
        Board board2 = new Board();
        System.out.println("Player 2, place your ships on the game field");
        board2.printBoard();
        /*int length;*/

        while (true) {
            length = 5;
            System.out.println("Enter the coordinates of the Aircraft Carrier (5 cells):");
            String[] inputArray = scanner.nextLine().trim().split("\\s+");
            if (!isCheckInput(inputArray)) continue;

            UserInput userInput = new UserInput(inputArray);
            if (!userInput.checkLength(length)) continue;

            Ship aircraftCarrier5 = new Ship(userInput.getCordArr(), length);
            if (!board2.checkPlaceShipOnBoard(aircraftCarrier5)) continue;

            board2.placeShipOnBoard(aircraftCarrier5);
            board2.printBoard();
            break;
        }
        while (true) {
            length = 4;
            System.out.println("Enter the coordinates of the Battleship (4 cells):");
            String[] inputArray = scanner.nextLine().trim().split("\\s+");
            if (!isCheckInput(inputArray)) continue;

            UserInput userInput = new UserInput(inputArray);
            if (!userInput.checkLength(length)) continue;

            Ship battleship4 = new Ship(userInput.getCordArr(), length);
            if (!board2.checkPlaceShipOnBoard(battleship4)) continue;

            board2.placeShipOnBoard(battleship4);
            board2.printBoard();
            break;
        }
        while (true) {
            length = 3;
            System.out.println("Enter the coordinates of the Submarine (3 cells):");
            String[] inputArray = scanner.nextLine().trim().split("\\s+");
            if (!isCheckInput(inputArray)) continue;

            UserInput userInput = new UserInput(inputArray);
            if (!userInput.checkLength(length)) continue;

            Ship submarine3 = new Ship(userInput.getCordArr(), length);
            if (!board2.checkPlaceShipOnBoard(submarine3)) continue;

            board2.placeShipOnBoard(submarine3);
            board2.printBoard();
            break;
        }
        while (true) {
            //length = 3;
            System.out.println("Enter the coordinates of the Cruiser (3 cells):");
            String[] inputArray = scanner.nextLine().trim().split("\\s+");
            if (!isCheckInput(inputArray)) continue;

            UserInput userInput = new UserInput(inputArray);
            if (!userInput.checkLength(length)) continue;

            Ship cruiser3 = new Ship(userInput.getCordArr(), length);
            if (!board2.checkPlaceShipOnBoard(cruiser3)) continue;

            board2.placeShipOnBoard(cruiser3);
            board2.printBoard();
            break;
        }
        while (true) {
            length = 2;
            System.out.println("Enter the coordinates of the Destroyer (2 cells):");
            String[] inputArray = scanner.nextLine().trim().split("\\s+");
            if (!isCheckInput(inputArray)) continue;

            UserInput userInput = new UserInput(inputArray);
            if (!userInput.checkLength(length)) continue;

            Ship destroyer2 = new Ship(userInput.getCordArr(), length);
            if (!board2.checkPlaceShipOnBoard(destroyer2)) continue;

            board2.placeShipOnBoard(destroyer2);
            board2.printBoard();
            break;
        }
        promptEnterKey();
        int playerTurn = 1;

        while (!board.isGameOver() && !board2.isGameOver()) {

            if (playerTurn == 1) {
                board2.printFogBoard();
                System.out.println("---------------------");
                board.printBoard();
                System.out.println("Player 1, it's your turn:");
                String input = scanner.nextLine().trim();
                if (!isCheckInput(input)) continue;
                board2.shotAt(input);
                promptEnterKey();
                playerTurn++;
                continue;
            }

            if (playerTurn == 2) {
                board.printFogBoard();
                System.out.println("---------------------");
                board2.printBoard();
                System.out.println("Player 2, it's your turn:");
                String input = scanner.nextLine().trim();
                if (!isCheckInput(input)) continue;
                board.shotAt(input);
                promptEnterKey();
                playerTurn--;
            }
        }
    }


    private static boolean isCheckInput(String[] inputArray) {
        if (inputArray.length != 2) {
            System.out.println("Error! Wrong Input! Try again:");
            return false;
        }
        if (inputArray[0].charAt(0) != inputArray[1].charAt(0) &&
                !inputArray[0].substring(1).equals(inputArray[1].substring(1))) {
            System.out.println("Error! Wrong ship location! Try again:");
            return false;
        }
        if (Integer.parseInt(inputArray[0].substring(1)) < 1 ||
                Integer.parseInt(inputArray[0].substring(1)) > 10 ||
                Integer.parseInt(inputArray[1].substring(1)) < 1 ||
                Integer.parseInt(inputArray[1].substring(1)) > 10) {
            System.out.println("Error! Wrong ship location! Try again:");
            return false;
        }
        try {
            ChCords.valueOf(String.valueOf(inputArray[0].charAt(0)));
            ChCords.valueOf(String.valueOf(inputArray[1].charAt(0)));
        } catch (IllegalArgumentException e) {
            System.out.println("Error! Wrong ship location! Try again:");
            return false;
        }
        return true;
    }
    private static boolean isCheckInput(String input) {
        if (Integer.parseInt(input.substring(1)) < 1 ||
                Integer.parseInt(input.substring(1)) > 10) {
            System.out.println("Error! Wrong shot location! Try again:");
            return false;
        }
        try {
            ChCords.valueOf(input.substring(0, 1));
        } catch (IllegalArgumentException e) {
            System.out.println("Error! Wrong shot location! Try again:");
            return false;
        }
        return true;
    }
    public static void promptEnterKey() {
        System.out.println("Press Enter and pass the move to another player");
        try {
            System.in.read();
            for (int i = 0; i < 50; ++i) System.out.print("\r\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
