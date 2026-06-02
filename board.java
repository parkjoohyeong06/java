public class Board {

    public static final int BOARD_SIZE = 19;

    public static final int CELL_EMPTY = 0;
    public static final int CELL_BLACK = 1;
    public static final int CELL_WHITE = 2;

    private int[][] board;
    private int[][] forbidden;
    private int[][] winHighlight;

    public Board() {

        board = new int[BOARD_SIZE][BOARD_SIZE];
        forbidden = new int[BOARD_SIZE][BOARD_SIZE];
        winHighlight = new int[BOARD_SIZE][BOARD_SIZE];
    }

    public int[][] getBoard() {
        return board;
    }

    public int[][] getForbidden() {
        return forbidden;
    }

    public int[][] getWinHighlight() {
        return winHighlight;
    }
}
