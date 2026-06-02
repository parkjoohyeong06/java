import java.util.Scanner;

public class GameLogic {

    private Board boardObj;

    private int[][] board;
    private int[][] forbidden;
    private int[][] winHighlight;

    private Player p1;
    private Player p2;

    private Scanner sc;

    public GameLogic(Player p1, Player p2) {

        this.p1 = p1;
        this.p2 = p2;

        boardObj = new Board();

        board = boardObj.getBoard();
        forbidden = boardObj.getForbidden();
        winHighlight = boardObj.getWinHighlight();

        sc = new Scanner(System.in);

        updateForbiddenPositions();
    }

    private boolean inRange(int x, int y) {
        return x >= 0 &&
               x < Board.BOARD_SIZE &&
               y >= 0 &&
               y < Board.BOARD_SIZE;
    }

    private void drawBoard() {

        System.out.print("    ");

        for (int c = 0; c < Board.BOARD_SIZE; c++) {
            System.out.printf("%3d", c + 1);
        }

        System.out.println();

        for (int r = 0; r < Board.BOARD_SIZE; r++) {

            System.out.printf("%3d ", r + 1);

            for (int c = 0; c < Board.BOARD_SIZE; c++) {

                if (board[r][c] == Board.CELL_EMPTY) {

                    if (forbidden[r][c])
                        System.out.print(" X ");
                    else
                        System.out.print(" + ");

                } else if (board[r][c] == Board.CELL_BLACK) {
                    System.out.print(" ○ ");
                } else {
                    System.out.print(" ● ");
                }
            }

            System.out.println();
        }
    }

    private boolean forbidden(int y, int x) {
        return forbidden[y][x] == 1;
    }

    public void run() {

        int turn = Board.CELL_BLACK;

        while (true) {

            drawBoard();

            Player currentPlayer =
                    (turn == Board.CELL_BLACK)
                    ? p1
                    : p2;

            System.out.println();
            System.out.println("현재 차례 : "
                    + currentPlayer.getName());

            int row;
            int col;

            System.out.print("행 입력(1~19) : ");
            row = sc.nextInt() - 1;

            System.out.print("열 입력(1~19) : ");
            col = sc.nextInt() - 1;

            if (!inRange(col, row)) {

                System.out.println("범위를 벗어났습니다.");
                continue;
            }

            if (board[row][col] != Board.CELL_EMPTY) {

                System.out.println("이미 돌이 있습니다.");
                continue;
            }

            if (turn == Board.CELL_BLACK &&
                forbidden(row, col)) {

                System.out.println("33 금수 위치입니다.");
                continue;
            }

            board[row][col] = turn;

            if (checkWinAndMark(col, row, turn)) {

                drawBoard();

                System.out.println();
                System.out.println(
                        currentPlayer.getName()
                        + " 승리!");

                break;
            }

            updateForbiddenPositions();

            if (turn == Board.CELL_BLACK)
                turn = Board.CELL_WHITE;
            else
                turn = Board.CELL_BLACK;
        }
    }

    private void updateForbiddenPositions() {
        // 다음 단계에서 구현
    }

    private boolean checkWinAndMark(
            int x,
            int y,
            int color) {

        return false;
    }
}
