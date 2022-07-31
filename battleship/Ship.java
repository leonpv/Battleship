package battleship;

public class Ship {
    final private int length;


    private int cellsAlive;
    private boolean isVertical;
    private boolean isHorizontal;
    private String[] startEndCoords;
    private String[] coordsAll;

    public Ship(String[] startEndCoordinates, int length) {
        this.startEndCoords = startEndCoordinates;
        this.length = length;
        this.cellsAlive = length;
        setVerticalAndHorizontal();
        setCordsAll();
    }

    private void setCordsAll() {
        coordsAll = new String[length];
        String startCord = startEndCoords[0];
        String endCord = startEndCoords[1];
        String cord = startCord;
        if (isHorizontal) {
            for (int i = 0; i < length; i++) {
                coordsAll[i] = cord;
                if (cord.equals(endCord)) {
                    break;
                }
                cord = cord.substring(0,1) + (Integer.parseInt(cord.substring(1)) + 1);
            }
        }
        if (isVertical) {
            for (int i = 0; i < length; i++) {
                coordsAll[i] = cord;
                if (cord.equals(endCord)) {
                    break;
                }
                char ch = ChCords.valueOf(cord.substring(0,1)).getCh();
                ch++;
                cord = ch + cord.substring(1);
                System.out.println();
            }
        }
    }

    public void setVerticalAndHorizontal() {
        if (startEndCoords[0].substring(0, 1).equals(startEndCoords[1].substring(0, 1))) {
            isVertical = false;
            isHorizontal = true;
        } else if (startEndCoords[0].substring(1).equals(startEndCoords[1].substring(1))) {
            isVertical = true;
            isHorizontal = false;
        }
    }

    public String[] getCoordsAll() {
        return coordsAll;
    }
    public int getLength() {
        return length;
    }
    public boolean belongCord(String shotCord) {
        for (String cord:coordsAll) {
            if (cord.equals(shotCord)) {
                return true;
            }
        }
        return false;
    }

    public void hitAShip() {
        this.cellsAlive--;
    }

    public int getCellsAlive() {
        return cellsAlive;
    }
}

