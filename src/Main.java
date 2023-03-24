import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final int boardSize = 3;
    static Random rand = new Random();
    static Scanner scan = new Scanner(System.in);
    private static boolean isPlayable = true;

    public static void main(String[] args) {

        String[][] board = {{" ", " ", " "},
                            {" ", " ", " "},
                             {" ", " ", " "}
                             };
        drawBoard(board);
        int openSpot = 0;
        int secondOpenSpot = 0;

        String gameState = "Player";
        while (!isFull(board) && isPlayable) {
            if (gameState.equalsIgnoreCase("Player")) {
                while (gameState.equalsIgnoreCase("Player")) {
                    int position = scan.nextInt();
                    switch (position) {
                        case 1:
                            if (board[0][0] == " ") {
                                gameState = "AI";
                                board[0][0] = "X";
                            } else {
                                System.out.println("Position full, try another slot");
                                drawBoard(board);
                                gameState = "Player";
                            }
                            break;
                        case 2:
                            if (board[0][1] == " ") {
                                gameState = "AI";
                                board[0][1] = "X";
                            } else {
                                System.out.println("Position full, try another slot");
                                drawBoard(board);
                                gameState = "Player";
                            }
                            break;
                        case 3:
                            if (board[0][2] == " ") {
                                gameState = "AI";
                                board[0][2] = "X";
                            } else {
                                System.out.println("Position full, try another slot");
                                drawBoard(board);
                                gameState = "Player";
                            }
                            break;
                        case 4:
                            if (board[1][0] == " ") {
                                gameState = "AI";
                                board[1][0] = "X";
                            } else {
                                System.out.println("Position full, try another slot");
                                drawBoard(board);
                                gameState = "Player";
                            }
                            break;
                        case 5:
                            if (board[1][1] == " ") {
                                gameState = "AI";
                                board[1][1] = "X";
                            } else {
                                System.out.println("Position full, try another slot");
                                drawBoard(board);
                                gameState = "Player";
                            }
                            break;
                        case 6:
                            if (board[1][2] == " ") {
                                gameState = "AI";
                                board[1][2] = "X";
                            } else {
                                System.out.println("Position full, try another slot");
                                drawBoard(board);
                                gameState = "Player";
                            }
                            break;
                        case 7:
                            if (board[2][0] == " ") {
                                gameState = "AI";
                                board[2][0] = "X";
                            } else {
                                System.out.println("Position full, try another slot");
                                drawBoard(board);
                                gameState = "Player";
                            }
                            break;
                        case 8:
                            if (board[2][1] == " ") {
                                gameState = "AI";
                                board[2][1] = "X";
                            } else {
                                System.out.println("Position full, try another slot");
                                drawBoard(board);
                                gameState = "Player";
                            }
                            break;
                        case 9:
                            if (board[2][2] == " ") {
                                gameState = "AI";
                                board[2][2] = "X";
                            } else {
                                System.out.println("Position full, try another slot");
                                drawBoard(board);
                                gameState = "Player";
                            }
                            break;
                        default:
                            System.out.println("Position not existing, please play on the board");
                    }

                }
                if(playerWon(board)){
                    System.out.println("PLAYER WON");
                    isPlayable = false;
                }
                gameState = "AI";
                while (gameState.equalsIgnoreCase("AI") && !isFull(board) && isPlayable) {
                    for (int i = 0; i < boardSize; i++) {
                        for (int j = 0; j < boardSize; j++) {
                            if (gameState == "AI") {
                                if (board[i][j] == " ") {
                                    openSpot = rand.nextInt(3);
                                    secondOpenSpot = rand.nextInt(3);
                                    if (board[openSpot][secondOpenSpot] == " ") {
                                        board[openSpot][secondOpenSpot] = "O";
                                        gameState = "Player";
                                    }
                                }
                            }

                        }
                    }

                }
                if(aiWon(board)){
                    System.out.println("AI WON");
                    isPlayable = false;
                }
                drawBoard(board);
            }

        }
        System.out.println("Game ended!");
        drawBoard(board);
    }

    public static void drawBoard(String[][] board) {
        for (int i = 0; i < boardSize; i++) {

            for (int j = 0; j < boardSize; j++) {
                System.out.print(board[i][j]);
                if(j <= 1)
                    System.out.print(" | ");
            }
            System.out.println();
            if(i <= 1){
                System.out.println("--+---+---");
            }

        }
    }
    public static boolean playerWon(String[][] board) {
        for(int i = 0; i < boardSize; i++){
            for(int j = 0; j < boardSize; j++){
                //line
                if((board[i][0] == "X" &&  board[i][1] =="X" && board[i][2] == "X"))
                    return true;
                //column
                if((board[0][j] == "X" &&  board[1][j] =="X" && board[2][j] == "X"))
                    return true;
                //first diagonal
                if((board[0][0] == "X" &&  board[1][1] =="X" && board[2][2] =="X"))
                    return true;
                //second diagonal
                if((board[0][2] == "X" &&  board[1][1] =="X" && board[2][0] =="X"))
                    return true;
            }
        }
        return false;
    }
    public static boolean aiWon(String board[][]) {
        for(int i = 0; i < boardSize; i++){
            for(int j = 0; j < boardSize; j++){
                //line
                if((board[i][0] == "O" &&  board[i][1] =="O" && board[i][2] == "O"))
                    return true;
                //column
                if((board[0][j] == "O" &&  board[1][j] =="O" && board[2][j] == "O"))
                    return true;
                //first diagonal
                if((board[0][0] == "O" &&  board[1][1] =="O" && board[2][2] =="O"))
                    return true;
                //second diagonal
                if((board[0][2] == "O" &&  board[1][1] =="O" && board[2][0] =="O"))
                    return true;
            }
        }
        return false;
    }
    public static boolean isFull(String[][] board) {
        String k;
        for (int i = 0; i < boardSize; i++)
            for (int j = 0; j < boardSize; j++) {
                k = board[i][j];
                if (k == " ")
                    return false;
            }
        return true;
    }
}