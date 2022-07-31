package battleship;

public enum ChCords {
    A('A', 1),
    B('B', 2),
    C('C', 3),
    D('D', 4),
    E('E', 5),
    F('F', 6),
    G('G', 7),
    H('H', 8),
    I('I', 9),
    J('J', 10);

    private final char ch;
    private final int num;

    ChCords(char ch, int num) {
        this.ch = ch;
        this.num = num;
    }

    public char getCh() {
        return ch;
    }

    public int getNum() {
        return num;
    }
}
