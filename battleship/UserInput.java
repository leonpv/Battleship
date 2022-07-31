package battleship;

public class UserInput {
    private String firstCord;
    private String secondCord;
    private String[] firstCordArr;
    private String[] secondCordArr;
    private boolean isVertical;
    private boolean isHorizontal;

    public UserInput(String[] inputArray) {
        firstCord = inputArray[0];
        secondCord = inputArray[1];
        firstCordArr = new String[2];
        secondCordArr = new String[2];

        if (secondCord.charAt(0) < firstCord.charAt(0) ||
                Integer.parseInt(secondCord.substring(1)) < Integer.parseInt(firstCord.substring(1))) {
            String temp = firstCord;
            firstCord = secondCord;
            secondCord = temp;
        }

        firstCordArr[0] = firstCord.substring(0, 1);
        firstCordArr[1] = firstCord.substring(1);
        secondCordArr[0] = secondCord.substring(0, 1);
        secondCordArr[1] = secondCord.substring(1);

        if (firstCordArr[0].equals(secondCordArr[0])) {
            isVertical = false;
            isHorizontal = true;
        }
        if (firstCordArr[1].equals(secondCordArr[1])) {
            isVertical = true;
            isHorizontal = false;
        }

    }

    public String[] getCordArr() {
        return new String[]{firstCord,secondCord};
    }

    public boolean checkLength(int length) {
        length--;
        if (isHorizontal) {
            if (Integer.parseInt(secondCordArr[1]) - Integer.parseInt(firstCordArr[1]) != length) {
                System.out.println("Error! Wrong length of the Ship! Try again:");
                return false;
            }
        }
        if (isVertical) {
            if (ChCords.valueOf(secondCordArr[0]).getNum() - ChCords.valueOf(firstCordArr[0]).getNum() != length) {
                System.out.println("Error! Wrong length of the Ship! Try again:");
                return false;
            }
        }
        return true;
    }

    public boolean isVertical() {
        return isVertical;
    }

    public boolean isHorizontal() {
        return isHorizontal;
    }
}
