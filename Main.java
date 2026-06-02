import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=== 오목 게임: 닉네임 입력 ===");

        System.out.print("사용자 1 (흑)의 닉네임: ");
        String p1Name = sc.nextLine();

        System.out.print("사용자 2 (백)의 닉네임: ");
        String p2Name = sc.nextLine();

        if (p1Name.trim().isEmpty())
            p1Name = "Player1";

        if (p2Name.trim().isEmpty())
            p2Name = "Player2";

        Player p1 = new Player(p1Name, Board.CELL_BLACK);
        Player p2 = new Player(p2Name, Board.CELL_WHITE);

        System.out.println();
        System.out.println("=== 오목 게임 메인 메뉴 ===");
        System.out.println("1. 게임 시작");
        System.out.println("2. 게임 종료");
        System.out.print("선택 >> ");

        int choice = sc.nextInt();

        if (choice == 1) {
            GameLogic game = new GameLogic(p1, p2);
            game.run();
        } else {
            System.out.println("게임을 종료합니다.");
        }

        sc.close();
    }
}
