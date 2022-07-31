package battleship;

import java.util.Objects;

public class Board {
    private String[][] fogBoard;
    private String[][] board;
    private String[][] oreolBoard;
    private Ship[] ships = new Ship[5];
    private int helpCounter = 0;

    public Board() {
        char ch = '\u0041';
        this.board = new String[11][11];
        this.fogBoard = new String[11][11];
        for (int i = 0; i < this.board.length; i++) {
            for (int j = 0; j < this.board[0].length; j++) {
                this.board[i][j] = "~ ";
                this.fogBoard[i][j] = "~ ";
                if (i == 0) {
                    this.board[i][j] = j + " ";
                    this.fogBoard[i][j] = j + " ";
                }
                if (j == 0 && i != 0) {
                    this.board[i][j] = ch++ + " ";
                    ch--;
                    this.fogBoard[i][j] = ch++ + " ";
                }
                if (j == 0 && i == 0) {
                    this.board[i][j] = "  ";
                    this.fogBoard[i][j] = "  ";
                }
            }
        }
        fillOreolBoard();
    }

    private void fillOreolBoard() {
        char ch = '\u0041';
        this.oreolBoard = new String[11][11];
        for (int i = 0; i < this.oreolBoard.length; i++) {
            for (int j = 0; j < this.oreolBoard[0].length; j++) {
                this.oreolBoard[i][j] = "~ ";
                if (i == 0) {
                    this.oreolBoard[i][j] = j + " ";
                }
                if (j == 0 && i != 0) {
                    this.oreolBoard[i][j] = ch++ + " ";
                }
                if (j == 0 && i == 0) {
                    this.oreolBoard[i][j] = "  ";
                }
            }
        }
    }

    public void printBoard() {
        for (String[] strings : this.board) {
            for (String string : strings) {
                System.out.print(string);
            }
            System.out.println();
        }
    }
/*
    public void printOreolBoard() {
        for (String[] strings : this.oreolBoard) {
            for (String string : strings) {
                System.out.print(string);
            }
            System.out.println();
        }
    }
*/
    public void printFogBoard() {
        for (String[] strings : this.fogBoard) {
            for (String string : strings) {
                System.out.print(string);
            }
            System.out.println();
        }
    }

    public void placeShipOnBoard(Ship ship) {
        this.ships[helpCounter] = ship;
        this.helpCounter++;
        for (String cord : ship.getCoordsAll()) {
            int i = ChCords.valueOf(cord.substring(0, 1)).getNum();
            int j = Integer.parseInt(cord.substring(1));
            board[i][j] = "O ";
            //next will fill oreolBoard
            oreolBoard[i][j] = "O ";
            if (i != 1) {
                oreolBoard[i - 1][j] = "O ";
            }
            if (i != 1 && j != 10) {
                oreolBoard[i - 1][j + 1] = "O ";
            }
            if (j != 10) {
                oreolBoard[i][j + 1] = "O ";
            }
            if (i != 10 && j != 10) {
                oreolBoard[i + 1][j + 1] = "O ";
            }
            if (i != 10) {
                oreolBoard[i + 1][j] = "O ";
            }
            if (i != 10 && j != 1) {
                oreolBoard[i + 1][j - 1] = "O ";
            }
            if (j != 1) {
                oreolBoard[i][j - 1] = "O ";
            }
            if (i != 1 && j != 1) {
                oreolBoard[i - 1][j - 1] = "O ";
            }
        }
    }

    public boolean checkPlaceShipOnBoard(Ship ship) {
        for (String cord : ship.getCoordsAll()) {
            int i = ChCords.valueOf(cord.substring(0, 1)).getNum();
            int j = Integer.parseInt(cord.substring(1));
            if ("O ".equals(oreolBoard[i][j])) {
                System.out.println("Error! You placed it too close to another one. Try again:");
                return false;
            }
        }
        return true;
    }

    public void shotAt(String shotCord) {
        var a = ChCords.valueOf(shotCord.substring(0, 1)).getNum();
        var b = Integer.parseInt(shotCord.substring(1));
        if ("O ".equals(board[a][b])) {
            board[a][b] = "X ";
            fogBoard[a][b] = "X ";
            printFogBoard();
            int shipEnum = -1;
            for (int i = 0; i < 5; i++) {
                if (ships[i].belongCord(shotCord)) {
                    ships[i].hitAShip();
                    shipEnum = i;
                }
            }
            if (shipEnum != -1) {
                if (ships[shipEnum].getCellsAlive() == 0) {
                    if (isGameOver()) {
                        System.out.println("You sank the last ship. You won. Congratulations!");
                    } else {
                        System.out.println("You sank a ship! Specify a new target:");
                    }

                } else {
                    System.out.println("You hit a ship! Try again:");
                }
            }

            return;
        }
        if ("~ ".equals(board[a][b])) {
            board[a][b] = "M ";
            fogBoard[a][b] = "M ";
            printFogBoard();
            System.out.println("You missed. Try again:");
            return;
        }
        if ("M ".equals(board[a][b])) {
            printFogBoard();
            System.out.println("You missed. Try again:");
            return;
        }
        if ("X ".equals(board[a][b])) {
            printFogBoard();
            System.out.println("You hit a ship! Try again:");
        }
    }

    public boolean isGameOver() {
        int counter = 0;
        for (int i = 0; i < 5; i++) {
            if (ships[i].getCellsAlive() == 0) {
                counter++;
            }
        }
        return counter == 5;
    }
}
